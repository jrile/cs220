package main.commands;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Takes two queries and creates a union out of them.
 */
public class UnionCommand implements ICommand {

	private Pattern pattern = Pattern.compile(
			"\\s*union\\s+(.*)\\s+and\\s+(.*);", Pattern.CASE_INSENSITIVE);

	private String query;
	private String query2;

	/**
	 * Creates a union out of two queries.
	 */
	@Override
	public void execute() {
		System.out.println("This is a correct union statement.");

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
