package main.commands;

/**
 * Interface that all the commands will inherit.
 */
public interface ICommand {

	/**
	 * Checks to see if command matches input.
	 * 
	 * @param input
	 *            the input the user sends
	 * @return true if successfully matches the command pattern ; false, if it
	 *         doesn't match the command pattern.
	 */
	public boolean matches(String input);

	/**
	 * Executes the user-defined command. Prints out that it was a successful
	 * statement and then runs that command.
	 * 
	 * @throws CommandException
	 *             the generic command exception
	 */
	public void execute() throws CommandException;
}
