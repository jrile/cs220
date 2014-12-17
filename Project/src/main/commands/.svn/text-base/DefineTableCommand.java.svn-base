package main.commands;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import main.Table;
import main.TableCollection;

/**
 * 
 * Takes user specified table name and field list and creates a new table in the
 * TableCollection.
 */
public class DefineTableCommand implements ICommand {

	private Pattern pattern = Pattern
			.compile(
					"\\s*define\\s+table\\s+(.*)\\s+having\\s+fields\\s*\\(\\s*(.*)\\s*\\)\\s*;",
					Pattern.CASE_INSENSITIVE);

	private String tablename;
	private String fieldlist;

	/**
	 * Goes through field list and adds all fields into a list and creates a
	 * Table to be added to the TableCollection with that information.
	 * 
	 * @throws CommandException
	 *             if the field list is not syntactically correct.
	 * */
	@Override
	public void execute() throws CommandException {

		TableCollection.getTC().add(tablename, new Table(tablename, fieldlist));
		System.out.println(tablename + " was added.");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean matches(String input) {
		Matcher matcher = pattern.matcher(input);
		boolean find = (matcher.find());
		if (find) {
			tablename = matcher.group(1);
			fieldlist = matcher.group(2);
		}
		return find;
	}

}
