package main.commands;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Joins two user inputted queries together.
 */
public class JoinCommand implements ICommand {

	private Pattern pattern = Pattern.compile(
			"\\s*join\\s+(.*)\\s+and\\s+(.*);", Pattern.CASE_INSENSITIVE);

	private String query;

	private String query2;

	/**
	 * Attempts to join both queries together.
	 */
	@Override
	public void execute() {
		System.out.println("This is a correct join statement.");

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
			query2 = matcher.group(2);
		}
		return find;
	}

}
