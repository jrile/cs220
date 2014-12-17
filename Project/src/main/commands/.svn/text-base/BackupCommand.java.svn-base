package main.commands;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * The Class BackupCommand. Backs up database to user-specified file name.
 */
public class BackupCommand implements ICommand {

	private Pattern pattern = Pattern.compile(
			"\\s*backup\\s+to\\s+'(.*)'\\s*;", Pattern.CASE_INSENSITIVE);

	private String filename;

	/**
	 * Backs the database up to the user specified file name.
	 */
	@Override
	public void execute() {
		System.out.println("This is a correct backup command.");

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean matches(String input) {
		Matcher matcher = pattern.matcher(input);
		boolean find = matcher.find();
		if (find)
			filename = matcher.group(1);
		return find;
	}

}
