package fields;

import java.io.IOException;
import java.io.RandomAccessFile;

import types.AbstractType;
import types.BooleanType;

import main.commands.CommandException;

/**
 * Field for a boolean field. "yes" and "no" are valid boolean types.
 * 
 */

public class BooleanField extends AbstractField {

	/**
	 * @inheritDoc
	 */
	public BooleanField(String name, long position) {
		super(name, "Boolean", position);

	}

	@Override
	public String print(RandomAccessFile raf, long pos) {
		String out = "";

		try {
			raf.seek(pos);
			out = "" + raf.readBoolean();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return out;
	}

	@Override
	public AbstractType getter(String data) throws CommandException {
		if (!(data.equalsIgnoreCase("true") | data.equalsIgnoreCase("false"))) {
			throw new CommandException("Incorrect boolean type.");
		}

		return new BooleanType(data);
	}

	@Override
	public int getSize() {
		return 1;
	}

	@Override
	public AbstractType getter(RandomAccessFile raf, long pointer)
			throws IOException {
		return new BooleanType(raf, pointer);
	}

}
