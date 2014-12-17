package main.commands;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Projects a query over a field.
 */
public class ProjectCommand implements ICommand {

	private Pattern pattern = Pattern.compile(
			"\\s*project\\s+(.*)\\s+over\\s+(.*);", Pattern.CASE_INSENSITIVE);

	private String query;
	private String field;

	/**
	 * Executes the "project" command; projects the query over the field.
	 */
	@Override
	public void execute() {
		System.out.println("This is a correct project statement.");

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
			field = matcher.group(2);
		}
		return find;
	}

}
