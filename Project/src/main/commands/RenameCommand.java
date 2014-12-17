package main.commands;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import main.TableCollection;

/**
 * The Class RenameCommand. Renames a table to a different name.
 */
public class RenameCommand implements ICommand {

	private Pattern pattern = Pattern.compile(
			"\\s*rename\\s+table\\s+(.*)\\s+to\\s+(.*);",
			Pattern.CASE_INSENSITIVE);
	private String oldTableName;
	private String newTableName;

	/**
	 * Changes old table name to a new table name.
	 * 
	 * @throws CommandException
	 *             if table does not exist
	 */
	@Override
	public void execute() throws CommandException {
		TableCollection.getTC().rename(oldTableName, newTableName);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean matches(String input) {
		Matcher matcher = pattern.matcher(input);
		boolean find = (matcher.find());
		if (find) {
			oldTableName = matcher.group(1);
			newTableName = matcher.group(2);
		}
		return find;
	}

}
