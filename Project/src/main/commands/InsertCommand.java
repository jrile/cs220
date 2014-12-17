package main.commands;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import main.TableCollection;

/**
 * Inserts a value into a table.
 */
public class InsertCommand implements ICommand {

	private Pattern pattern = Pattern.compile(
			"\\s*insert\\s*\\((.*)\\)\\s*into\\s+(.*);",
			Pattern.CASE_INSENSITIVE);

	private String valueList;

	private String tablename;

	/**
	 * Searches through TableCollection and inserts value into correct table if
	 * table exists.
	 * 
	 * @throws CommandException
	 */
	@Override
	public void execute() throws CommandException {
		TableCollection.getTC().insert(tablename, valueList.split("\\s*,\\s+"));

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean matches(String input) {
		Matcher matcher = pattern.matcher(input);
		boolean find = (matcher.find());
		if (find) {
			valueList = matcher.group(1);
			tablename = matcher.group(2);
		}
		return find;
	}

}
