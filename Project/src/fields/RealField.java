package fields;

import java.io.IOException;
import java.io.RandomAccessFile;

import types.AbstractType;
import types.RealType;

import main.commands.CommandException;

/**
 * Field type for a Real. Real syntax : integer [.] integer
 * 
 */
public class RealField extends AbstractField {

	/**
	 * @inheritDoc
	 */
	public RealField(String name, long position) {
		super(name, "Real", position);

	}

	@Override
	public String print(RandomAccessFile raf, long pos) {
		String out = "";
		try {
			raf.seek(pos);
			out = raf.readFloat() + "";
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return out;
	}

	@Override
	public AbstractType getter(String data) throws CommandException {
		if (!data.matches("\\d*.?\\d*"))
			throw new CommandException("Incorrect real type.");
		return new RealType(data);
	}

	@Override
	public int getSize() {
		return 4;
	}

	@Override
	public AbstractType getter(RandomAccessFile raf, long pointer)
			throws IOException {
		return new RealType(raf, pointer);
	}

}
