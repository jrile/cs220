package types;

import java.io.IOException;
import java.io.RandomAccessFile;

import main.commands.CommandException;

public class RealType extends AbstractType<RealType> {
	private float data;

	public RealType(String data) throws CommandException {
		try {
			this.data = Float.parseFloat(data);
		} catch (NumberFormatException e) {
			throw new CommandException("Incorrect real type.");
		}
	}

	public RealType(RandomAccessFile raf, long pointer) throws IOException {
		raf.seek(pointer);
		data = raf.readFloat();
	}

	public RealType(float data) {
		this.data = data;
	}

	@Override
	public String getData() {
		return Float.toString(data);
	}

	@Override
	public void write(RandomAccessFile raf, long pointer)
			throws CommandException {
		try {
			raf.seek(pointer);
			raf.writeFloat(data);
		} catch (IOException e) {
			throw new CommandException(
					"There was an error writing to the file.");
		}
	}

	@Override
	public int compareTo(RealType o) {
		return Float.compare(data, o.data);
	}

}
