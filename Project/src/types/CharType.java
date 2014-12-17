package types;

import java.io.IOException;
import java.io.RandomAccessFile;

import main.commands.CommandException;

public class CharType extends AbstractType<CharType> {
	private String data;

	public CharType(String data) {
		this.data = data;
	}

	public CharType(RandomAccessFile raf, long pointer, int length)
			throws IOException {
		data = "";
		raf.seek(pointer);
		for (int i = 0; i < length; i++) {
			data += raf.readChar();
		}

	}

	@Override
	public String getData() {
		return data;
	}

	@Override
	public void write(RandomAccessFile raf, long pointer)
			throws CommandException {
		try {
			raf.seek(pointer);
			raf.writeChars(data);
		} catch (IOException e) {
			throw new CommandException(
					"There was an error writing to the file.");
		}
	}

	@Override
	public int compareTo(CharType o) {
		return data.compareTo(o.data);
	}

}
