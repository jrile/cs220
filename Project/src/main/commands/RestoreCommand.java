package main.commands;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Restores database from user specified file name.
 */
public class RestoreCommand implements ICommand {

	private Pattern pattern = Pattern.compile(
			"\\s*restore\\s+from\\s+'(.*)'\\s*;", Pattern.CASE_INSENSITIVE);

	private String filename;

	/**
	 * Restores the database from a file.
	 */
	@Override
	public void execute() {
		System.out.println("This is a correct restore command.");

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean matches(String input) {
		Matcher matcher = pattern.matcher(input);
		boolean find = (matcher.find());
		if (find) {
			filename = matcher.group(1);
		}
		return find;
	}

}
