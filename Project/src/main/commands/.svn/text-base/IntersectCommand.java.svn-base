package main.commands;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import main.commands.ICommand;

/**
 * Intersects two user inputted queries.
 */
public class IntersectCommand implements ICommand {

	private Pattern pattern = Pattern.compile(
			"\\s*intersect\\s+(.*)\\s+and\\s+(.*);", Pattern.CASE_INSENSITIVE);

	private String query1;

	private String query2;

	/**
	 * Intersects both queries together.
	 */
	@Override
	public void execute() {
		System.out.println("This is a correct intersect statement.");

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean matches(String input) {
		Matcher matcher = pattern.matcher(input);
		boolean find = (matcher.find());
		if (find) {
			query1 = matcher.group(1);
			query2 = matcher.group(2);
		}
		return find;
	}

}
