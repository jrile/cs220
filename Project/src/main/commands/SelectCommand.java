package main.commands;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import main.TableCollection;

/**
 * Selects a user specified table.
 */
public class SelectCommand implements ICommand {

	private Pattern pattern = Pattern.compile("\\s*select\\s+(.*);",
			Pattern.CASE_INSENSITIVE);

	private String query;

	/**
	 * Selects data from a table.
	 * 
	 * @throws CommandException
	 */
	@Override
	public void execute() throws CommandException {
		// System.out.println("This is a correct SELECT statement");
		Pattern where = Pattern.compile("(.*)\\s*where\\s+(.*)\\s*");
		Matcher whereMatch = where.matcher(query);
		if (whereMatch.matches()) {
			try {
				TableCollection.getTC().select(
						whereMatch.group(1).replaceAll("\\s", ""),
						whereMatch.group(2));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		else {
			try {
				TableCollection.getTC().print(query.trim());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean matches(String input) {
		Matcher matcher = pattern.matcher(input);
		boolean find = (matcher.find());
		if (find) {
			query = matcher.group(1);
		}
		return find;
	}

}
