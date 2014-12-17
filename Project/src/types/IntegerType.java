package types;

import java.io.IOException;
import java.io.RandomAccessFile;

import main.commands.CommandException;

public class IntegerType extends AbstractType<IntegerType> {
	private int data;

	public IntegerType(String data) throws CommandException {
		try {
			this.data = Integer.parseInt(data);
		} catch (NumberFormatException e) {
			throw new CommandException("Incorrect integer type.");
		}
	}

	public IntegerType(RandomAccessFile raf, long pointer) throws IOException {
		raf.seek(pointer);
		data = raf.readInt();
	}

	public IntegerType(int data) {
		this.data = data;
	}

	@Override
	public String getData() {
		return Integer.toString(data);
	}

	@Override
	public void write(RandomAccessFile raf, long pointer)
			throws CommandException {
		try {
			raf.seek(pointer);
			raf.writeInt(data);
		} catch (IOException e) {
			throw new CommandException(
					"There was an error writing to the file.");
		}
	}

	@Override
	public int compareTo(IntegerType o) {
		if (o.data == data)
			return 0;
		else if (o.data > data) {
			return -1;
		}
		return 1;
	}

}
