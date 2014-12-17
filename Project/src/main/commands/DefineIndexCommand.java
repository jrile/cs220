package main.commands;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * The Class DefineIndexCommand. Sets up a new index with user specified table
 * name.
 */
public class DefineIndexCommand implements ICommand {

	private Pattern pattern = Pattern.compile(
			"\\s*define\\s+index\\s+on\\s*\\((.*)\\)\\s*;",
			Pattern.CASE_INSENSITIVE);

	private String tablename;

	/**
	 * Creates a new index on specified table.
	 */
	@Override
	public void execute() {
		System.out.println("This is a correct define index statement.");

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean matches(String input) {
		Matcher matcher = pattern.matcher(input);
		boolean find = (matcher.find());
		if (find)
			tablename = matcher.group(1);
		return find;
	}

}
