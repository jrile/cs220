package main.commands;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Subtracts one query from another query.
 */
public class MinusCommand implements ICommand {

	private Pattern pattern = Pattern.compile(
			"\\s*minus\\s+(.*)\\s+and\\s+(.*);", Pattern.CASE_INSENSITIVE);

	private String query;

	private String query2;

	/**
	 * Subtracts the second query from the first.
	 */
	@Override
	public void execute() {
		System.out.println("This is a correct minus statement.");

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
