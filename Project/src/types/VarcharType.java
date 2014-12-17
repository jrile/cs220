package types;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

import main.commands.CommandException;

public class VarcharType extends AbstractType<VarcharType> {
	private String data;

	public VarcharType(String data) {
		this.data = data;
	}

	public VarcharType(RandomAccessFile raf, long pointer) throws IOException {
		raf.seek(pointer);
		RandomAccessFile stringRAF = new RandomAccessFile(
				new File("stringRAF"), "rw");
		stringRAF.seek(raf.readLong());
		data = stringRAF.readUTF();
		stringRAF.close();
	}

	@Override
	public String getData() {
		return data;
	}

	@Override
	public int compareTo(VarcharType o) {
		return data.compareTo(o.data);
	}

	@Override
	public void write(RandomAccessFile raf, long pointer)
			throws CommandException {
		try {
			raf.seek(pointer);
			RandomAccessFile stringRAF = new RandomAccessFile(new File(
					"stringRAF"), "rw");
			raf.writeLong(stringRAF.length());
			stringRAF.seek(stringRAF.length());
			stringRAF.writeUTF(data);
			stringRAF.close();

		} catch (IOException e) {
			throw new CommandException(
					"There was an error writing to the file.");
		}
	}

}
