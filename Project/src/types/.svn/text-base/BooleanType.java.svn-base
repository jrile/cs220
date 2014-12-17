package types;

import java.io.IOException;
import java.io.RandomAccessFile;

import main.commands.CommandException;

public class BooleanType extends AbstractType<BooleanType> {
	private boolean data;

	public BooleanType(String data) {
		this.data = Boolean.parseBoolean(data);
	}

	public BooleanType(RandomAccessFile raf, long pointer) throws IOException {
		raf.seek(pointer);
		data = raf.readBoolean();
	}

	public BooleanType(boolean data) {
		this.data = data;
	}

	@Override
	public void write(RandomAccessFile raf, long pointer)
			throws CommandException {
		try {
			raf.seek(pointer);
			raf.writeBoolean(data);
		} catch (IOException e) {
			throw new CommandException(
					"There was an error writing to the file.");
		}
	}

	@Override
	public String getData() {
		return Boolean.toString(data);
	}

	@Override
	public int compareTo(BooleanType o) {
		if (data == o.data)
			return 0;
		else if (data == false)
			return -1;
		return 1;
	}

}
