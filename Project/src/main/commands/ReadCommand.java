package main.commands;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import main.Driver;

/**
 * The Class ReadCommand. Reads a file and executes commands within the file.
 */
public class ReadCommand implements ICommand {

	private Pattern pattern = Pattern.compile("\\s*read\\s+'(.*)'\\s*;",
			Pattern.CASE_INSENSITIVE);

	private String filename;

	/**
	 * Attempts to read the file and execute all of the commands within it.
	 * 
	 * @throws CommandException
	 *             - If file is not found.
	 */
	@Override
	public void execute() throws CommandException {
		try {
			new Driver().execute(new Scanner(new FileReader(filename)));
		} catch (FileNotFoundException e) {
			throw new CommandException("File was not found.");
		}

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean matches(String input) {
		Matcher matcher = pattern.matcher(input);
		boolean find = (matcher.find());
		if (find)
			filename = matcher.group(1);
		return find;
	}

}
