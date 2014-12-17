package types;

import java.io.RandomAccessFile;

import main.commands.CommandException;

public abstract class AbstractType<T extends AbstractType> implements
		Comparable<T> {

	public abstract String getData();

	public abstract void write(RandomAccessFile raf, long pointer)
			throws CommandException;

}
