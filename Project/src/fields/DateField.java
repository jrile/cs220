package fields;

import java.io.IOException;
import java.io.RandomAccessFile;

import types.AbstractType;

import types.DateType;

import main.commands.CommandException;

/**
 * Field for a date. Dates must be in format 00/00/0000
 * 
 */
public class DateField extends AbstractField {

	/**
	 * @inheritDoc
	 */
	public DateField(String name, long position) {
		super(name, "Date", position);

	}

	@Override
	public String print(RandomAccessFile raf, long pos) {
		String out = "";
		try {
			out += new DateType(raf, pos).getData();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return out;

	}

	@Override
	public AbstractType getter(String data) throws CommandException {
		return new DateType(data);
	}

	@Override
	public int getSize() {
		return 8;
	}

	@Override
	public AbstractType getter(RandomAccessFile raf, long pointer)
			throws IOException {
		return new DateType(raf, pointer);
	}

}
