package main.commands;

/**
 * The Class CommandException. Generic exception class to pass other exceptions
 * through
 */
public class CommandException extends Exception {

	/**
	 * Instantiates a new command exception.
	 */
	public CommandException() {
		/*
		 * Generic command exception, super class
		 */
	}

	/**
	 * Instantiates a new command exception.
	 * 
	 * @param message
	 *            the error message
	 */
	public CommandException(String message) {
		super(message);
	}

	/**
	 * Instantiates a new command exception.
	 * 
	 * @param cause
	 *            the cause
	 */
	public CommandException(Throwable cause) {
		super(cause);
	}

	/**
	 * Instantiates a new command exception.
	 * 
	 * @param message
	 *            the message
	 * @param cause
	 *            the cause
	 */
	public CommandException(String message, Throwable cause) {
		super(message, cause);

	}

}
