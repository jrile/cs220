package main.commands;

import java.io.FileNotFoundException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import xml.XMLWriter;

/**
 * Exits out of program.
 */
public class ExitCommand implements ICommand {

	private Pattern pattern = Pattern.compile("\\s*exit\\s*;",
			Pattern.CASE_INSENSITIVE);

	/**
	 * Exits out of the program.
	 */
	@Override
	public void execute() {
		String file = "data.xml";
		try {
			new XMLWriter().write("data.xml");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.exit(0);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean matches(String input) {
		Matcher matcher = pattern.matcher(input);
		return (matcher.find());
	}

}
