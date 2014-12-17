package fields;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import types.AbstractType;
import types.VarcharType;

import main.commands.CommandException;

/**
 * Field type for a varchar (string of characters).
 * 
 */
public class VarcharField extends AbstractField {

	/**
	 * @inheritDoc
	 */

	public VarcharField(String name, long position) {
		super(name, "Varchar", position);

	}

	@Override
	public String print(RandomAccessFile raf, long pos) {
		String out = "";
		try {
			raf.seek(pos);
			RandomAccessFile stringRAF = new RandomAccessFile(new File(
					"stringRAF"), "rw");

			stringRAF.seek(raf.readLong());
			out = stringRAF.readUTF();
			stringRAF.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return out;

	}

	@Override
	public AbstractType getter(String data) throws CommandException {
		Pattern pattern = Pattern.compile("\\s*'(.*)'\\s*");
		Matcher matcher = pattern.matcher(data);

		if (!matcher.find())
			throw new CommandException("Incorrect varchar type.");
		return new VarcharType(matcher.group(1));
	}

	@Override
	public int getSize() {
		return 8;
	}

	@Override
	public AbstractType getter(RandomAccessFile raf, long pointer)
			throws IOException {
		return new VarcharType(raf, pointer);
	}

}
