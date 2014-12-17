package fields;

import java.io.IOException;
import java.io.RandomAccessFile;

import main.commands.CommandException;

import types.AbstractType;
import xml.XMLEncoder;

public abstract class AbstractField {
	/**
	 * The name of the field.
	 */
	private String name;
	private String type;
	private int position;

	public String getName() {
		return name;
	}

	public String getType() {
		return type;
	}

	/**
	 * Constructs the field, changes name to user-inputted name.
	 * 
	 * @param name
	 */
	public AbstractField(String name, String type, long position) {
		this.name = name;
		this.type = type;
	}

	@Override
	public String toString() {
		return type + "\t\t" + name;
	}

	public String toXML() {
		return "\t\t<FIELD>\n\t\t\t<FIELDNAME>" + XMLEncoder.encode(name)
				+ "</FIELDNAME>\n\t\t\t<FIELDTYPE>" + XMLEncoder.encode(type)
				+ "</FIELDTYPE>\n</FIELD>\n";
	}

	public abstract int getSize();

	public abstract String print(RandomAccessFile raf, long pos);

	public abstract AbstractType getter(String data) throws CommandException;

	public abstract AbstractType getter(RandomAccessFile raf, long pointer)
			throws IOException;

	public void setPositionInRow(int p) {
		position = p;
	}

	public int getPositionInRow() {
		return position;
	}

}
