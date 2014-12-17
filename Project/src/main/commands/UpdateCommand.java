package main.commands;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import main.TableCollection;

/**
 * Updates a table by changing a fieldname.
 */
public class UpdateCommand implements ICommand {

	private Pattern pattern = Pattern.compile(
			"\\s*update\\s+(.*)\\s+set\\s+(.*?)\\s*={1}\\s*(.*);",
			Pattern.CASE_INSENSITIVE);

	private String tableName;

	private String fieldName;

	private String value;

	/**
	 * Updates a table by changing it's field name.
	 * 
	 * @throws CommandException
	 */
	@Override
	public void execute() throws CommandException {

		Pattern where = Pattern.compile("(.*?)\\s*where\\s+(.*?)");
		Matcher whereMatch = where.matcher(value);
		if (whereMatch.matches()) {
			try {
				TableCollection.getTC().update(tableName.replaceAll("\\s", ""),
						whereMatch.group(1).replaceAll("\\s", ""), fieldName,
						whereMatch.group(2));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			try {

				TableCollection.getTC().update(tableName, value, fieldName, "");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean matches(String input) {
		Matcher matcher = pattern.matcher(input);
		boolean find = (matcher.find());
		if (find) {
			tableName = matcher.group(1);
			fieldName = matcher.group(2);
			value = matcher.group(3);
		}
		return find;
	}

}
