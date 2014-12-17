package fields;

import java.io.IOException;
import java.io.RandomAccessFile;

import types.AbstractType;
import types.IntegerType;

import main.commands.CommandException;

/**
 * 
 * Field type for an integer. (0-9)
 * 
 */
public class IntegerField extends AbstractField {

	/**
	 * @inheritDoc
	 */
	public IntegerField(String name, long position) {
		super(name, "Integer", position);
	}

	@Override
	public String print(RandomAccessFile raf, long pos) {
		String out = "";
		try {
			raf.seek(pos);
			out = raf.readInt() + "";
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return out;

	}

	@Override
	public AbstractType getter(String data) throws CommandException {
		if (!data.matches("\\d+"))
			throw new CommandException("Incorrect integer type.");
		return new IntegerType(data);
	}

	@Override
	public int getSize() {
		return 4;
	}

	@Override
	public AbstractType getter(RandomAccessFile raf, long pointer)
			throws IOException {
		return new IntegerType(raf, pointer);
	}

}
