package fields;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import main.commands.CommandException;
import types.AbstractType;
import types.CharType;
import xml.XMLEncoder;

/**
 * Field type for a character. Specific number of characters should be declared
 * with this field type.
 * 
 */
public class CharField extends AbstractField {
	protected int length;
	private String name;

	/**
	 * @inheritDoc
	 */
	public CharField(String name, int l, long position) {
		super(name, "Char", position);
		length = l;
		this.name = name;
	}

	@Override
	public String toString() {
		return "Char(" + length + ")\t\t" + name;
	}

	@Override
	public String toXML() {
		return "\t\t<FIELD>\n\t\t\t<FIELDNAME>" + XMLEncoder.encode(name)
				+ "</FIELDNAME>\n\t\t\t<FIELDTYPE LENGTH=\"" + length
				+ "\">Char</FIELDTYPE>\n</FIELD>\n";
	}

	@Override
	public String print(RandomAccessFile raf, long pos) {
		String out = new String("");
		try {
			raf.seek(pos);
			for (int i = 0; i < length; i++) {
				out += raf.readChar();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return out;
	}

	@Override
	public AbstractType getter(String data) throws CommandException {
		Pattern pattern = Pattern.compile("\\s*\'(.*)\'\\s*");
		Matcher matcher = pattern.matcher(data);
		if (!matcher.find())
			throw new CommandException("Incorrect char type.");
		if (matcher.group(1).length() != length)
			throw new CommandException("Incorrect char length.");
		return new CharType(matcher.group(1));
	}

	public void write(AbstractType a, RandomAccessFile raf, long pointer)
			throws IOException {
		raf.seek(pointer);
		raf.writeChars(a.getData());
	}

	@Override
	public int getSize() {
		return length * 2;
	}

	@Override
	public AbstractType getter(RandomAccessFile raf, long pointer)
			throws IOException {
		return new CharType(raf, pointer, length);
	}

}
