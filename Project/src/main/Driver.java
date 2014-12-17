package main;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import org.xml.sax.SAXException;

import xml.XMLImport;

import main.commands.BackupCommand;
import main.commands.CommandException;
import main.commands.DefineIndexCommand;
import main.commands.DefineTableCommand;
import main.commands.DeleteCommand;
import main.commands.DropTableCommand;
import main.commands.ExitCommand;
import main.commands.InsertCommand;
import main.commands.IntersectCommand;
import main.commands.JoinCommand;
import main.commands.MinusCommand;
import main.commands.PrintCommand;
import main.commands.ProjectCommand;
import main.commands.ReadCommand;
import main.commands.RenameCommand;
import main.commands.RestoreCommand;
import main.commands.SelectCommand;
import main.commands.ICommand;
import main.commands.UnionCommand;
import main.commands.UpdateCommand;

/**
 * a Driver Main class to run the project, finds and executes commands.
 */
public class Driver {

	private ICommand[] commands = new ICommand[] { new PrintCommand(),
			new SelectCommand(), new DropTableCommand(), new BackupCommand(),
			new RenameCommand(), new ExitCommand(), new ReadCommand(),
			new RestoreCommand(), new DefineTableCommand(),
			new DefineIndexCommand(), new DeleteCommand(), new InsertCommand(),
			new UpdateCommand(), new ProjectCommand(), new JoinCommand(),
			new IntersectCommand(), new UnionCommand(), new MinusCommand() };

	/**
	 * Calls for "execute" method to start command prompt.
	 * 
	 * @param args
	 *            the arguments
	 * @throws CommandException
	 * @throws IOException
	 * @throws SAXException
	 * 
	 */
	public static void main(String[] args) throws CommandException,
			SAXException, IOException {

		try {
			new XMLImport().saxReader("data.xml");
		} catch (FileNotFoundException e) {
		}

		new Driver().execute(new Scanner(System.in));
	}

	/**
	 * Finds and executes the inputted commands. While the user does not enter
	 * "exit;", outputs a line for the user to input a command. Loops through
	 * commands until the correct one is found, attempts to execute it and
	 * outputs any errors if applicable. If command is not found, outputs that
	 * it is an incorrect statement.
	 */
	public void execute(Scanner sc) {
		System.out.print(">");

		LOOP: while (sc.hasNext()) {

			String str = (sc.next());

			while (!str.endsWith(";")) {
				str = str.concat(" " + sc.next());
			}

			for (ICommand command : commands) {
				if (command.matches(str)) {
					try {
						command.execute();
					} catch (CommandException e) {
						System.out.println(e.getMessage());
					}
					System.out.print(">");
					continue LOOP;
				}
			}
			System.out.println("This is an incorrect statement.");
			System.out.print(">");
		}
	}
}
