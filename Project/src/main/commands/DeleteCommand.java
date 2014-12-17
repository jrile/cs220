package main.commands;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import main.TableCollection;

/**
 * Goes through TableCollection and finds the table and then deletes it from the
 * Collection.
 */
public class DeleteCommand implements ICommand {

	private Pattern pattern = Pattern.compile("\\s*delete\\s+(.*);");

	private String tablename;

	/**
	 * Searches through TableCollection and deletes the table.
	 * 
	 * @throws CommandException
	 */
	@Override
	public void execute() throws CommandException {

		Pattern where = Pattern.compile("(.*?)\\s*where\\s+(.*?)");
		Matcher whereMatch = where.matcher(tablename);
		if (whereMatch.matches()) {
			try {
				TableCollection.getTC().delete(
						whereMatch.group(1).replaceAll("\\s", ""),
						whereMatch.group(2).replaceAll("\\s", ""));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			try {

				TableCollection.getTC().delete(tablename.replaceAll("\\s", ""),
						"");
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
		boolean find = matcher.find();
		if (find) {
			tablename = matcher.group(1);
		}
		return find;
	}

}
