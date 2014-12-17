package main.commands;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import main.TableCollection;

public class PrintCommand implements ICommand {

	private Pattern pattern = Pattern.compile("\\s*print\\s+(.*);",
			Pattern.CASE_INSENSITIVE);

	private String query;

	/**
	 * Prints out the user specified query.
	 * 
	 * @throws CommandException
	 */
	@Override
	public void execute() throws CommandException {

		if (query.trim().equalsIgnoreCase("dictionary")) {
			System.out.print(TableCollection.getTC());
		} else
			try {
				TableCollection.getTC().select(query, "");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
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
