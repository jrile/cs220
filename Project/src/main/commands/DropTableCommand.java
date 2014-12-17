package main.commands;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import main.TableCollection;

/**
 * Searches through TableCollection and drops the specified table if it can be
 * found.
 */
public class DropTableCommand implements ICommand {

	private Pattern pattern = Pattern.compile(
			"(\\s*)drop(\\s+)table(\\s+)(.*);", Pattern.CASE_INSENSITIVE);

	private String tablename;

	/**
	 * Attempts to find table from TableCollection and drop it from the
	 * collection. Prints out whether or not it was successful in finding table
	 * from collection.
	 * 
	 * @throws CommandException
	 *             if table does not exist.
	 */
	@Override
	public void execute() throws CommandException {
		TableCollection.getTC().remove(tablename);

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean matches(String input) {
		Matcher matcher = pattern.matcher(input);
		boolean find = (matcher.find());
		if (find)
			tablename = matcher.group(4);
		return find;
	}

}
