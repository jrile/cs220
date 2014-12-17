package main;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import types.AbstractType;

import fields.BooleanField;
import fields.CharField;
import fields.AbstractField;
import fields.DateField;
import fields.IntegerField;
import fields.RealField;
import fields.VarcharField;

import main.commands.CommandException;

/**
 * 
 * Table class that stores all of the fields.
 * 
 */
public class Table {

	private RandomAccessFile raf;
	private ArrayList<AbstractField> fieldsArray = new ArrayList<AbstractField>();
	private int rowByteLength = 0;

	/**
	 * Table constructor that takes in a list of fields defined for this table.
	 * 
	 * @param fields
	 *            The pre-sorted list of fields.
	 * @throws CommandException
	 */

	public Table(String tableName, String fieldlist) throws CommandException {
		String[] arraysSplit = fieldlist.split("\\s*,{1}\\s+");
		try {
			raf = new RandomAccessFile(new File(tableName), "rw");

		} catch (Exception e) {
			throw new CommandException("Unable to write table.");
		}
		rowByteLength += 1;
		for (String s : arraysSplit) {
			Scanner sc = new Scanner(s);

			try {
				String name = sc.next().trim();
				String type = "";
				while (sc.hasNext()) {
					type += sc.next().trim();
				}
				if (!fieldExists(name)) {
					AbstractField af = fieldFactory(name, type);
					af.setPositionInRow(rowByteLength);
					fieldsArray.add(af);
					rowByteLength += af.getSize();

				} else
					throw new CommandException("Field \"" + name
							+ "\" already exists in this table.");

			} catch (NoSuchElementException e) {
				throw new CommandException("Field type / name missing.");
			}
		}

	}

	private boolean fieldExists(String name) {
		boolean exists = false;
		for (AbstractField i : fieldsArray) {
			if (i.getName().equalsIgnoreCase(name))
				exists = true;
		}
		return exists;
	}

	/**
	 * Takes field data and determines what type of field it is.
	 * 
	 * @param name
	 *            The name to be added to the field.
	 * @param type
	 *            The type of field it is (boolean, varchar, etc).
	 * @return Correct field type with the data provided.
	 * @throws CommandException
	 *             if the field type does not exist.
	 */
	private AbstractField fieldFactory(String name, String type)
			throws CommandException {
		Pattern charPattern = Pattern.compile(
				"\\s*char\\((\\s*\\d+\\s*)\\)\\s*", Pattern.CASE_INSENSITIVE);

		Matcher matcher = charPattern.matcher(type);
		AbstractField ff = null;
		if (type.equalsIgnoreCase("boolean"))
			ff = new BooleanField(name, rowByteLength);
		else if (type.equalsIgnoreCase("integer"))
			ff = new IntegerField(name, rowByteLength);
		else if (type.equalsIgnoreCase("real"))
			ff = new RealField(name, rowByteLength);
		else if (type.equalsIgnoreCase("varchar"))
			ff = new VarcharField(name, rowByteLength);
		else if (type.equalsIgnoreCase("date"))
			ff = new DateField(name, rowByteLength);
		else if (matcher.find()) {
			int charLength = Integer.parseInt(matcher.group(1).trim());
			ff = new CharField(name, charLength, rowByteLength);
		} else
			throw new CommandException("Type is not valid.");
		return ff;
	}

	/**
	 * Neatly prints out all field types and their names.
	 */
	@Override
	public String toString() {
		String fields = "";
		for (AbstractField i : fieldsArray) {
			fields += "\n" + i.toString();
		}
		return "-------------------------\nType\t\tName\n-------------------------"
				+ fields + "\n";
	}

	public String toXML() {
		String out = "";
		for (AbstractField name : fieldsArray) {
			out += name.toXML();
		}
		return out;
	}

	public void insert(String[] values) throws CommandException, IOException {
		if (values.length != fieldsArray.size()) {
			throw new CommandException("Incorrect amount of values for table.");
		}
		ArrayList<AbstractType> at = new ArrayList();
		raf.seek(raf.length());
		raf.writeByte(1);
		for (int i = 0; i < fieldsArray.size(); i++) {
			try {
				at.add(fieldsArray.get(i).getter(values[i]));
			} catch (CommandException e) {
				e.printStackTrace();
				return;
			}
		}
		for (AbstractType a : at) {
			long point = raf.length();
			a.write(raf, point);
		}
	}

	public String select(String whereClause) throws CommandException,
			IOException {
		ArrayList<Integer> al = where(whereClause);
		String out = "";
		for (AbstractField i : fieldsArray) {
			out += i.getType() + "\t\t";
		}
		out += "\n";
		for (AbstractField i : fieldsArray) {
			out += i.getName() + "\t\t";
		}
		out += "\n-------------------------------------------------\n";
		for (int row : al) {
			raf.seek(row * rowByteLength);
			if (raf.readByte() == 0) {
				continue; // this row is deleted
			}
			for (AbstractField af : fieldsArray) {
				out += af.print(raf,
						(row * rowByteLength + af.getPositionInRow()))
						+ "\t\t";
			}
			out += "\n";
		}
		return out;
	}

	public void delete(String whereClause) throws CommandException, IOException {
		ArrayList<Integer> al = where(whereClause);
		for (int i : al) {
			raf.seek(i * rowByteLength);
			raf.writeByte(0);
		}
	}

	public void update(String whereClause, String fieldName, String value)
			throws CommandException, IOException {
		ArrayList<Integer> al = where(whereClause);
		AbstractField f = fieldFinder(fieldName);
		for (int i : al) {
			for (AbstractField af : fieldsArray) {
				if (af.getName().equals(fieldName.replaceAll("\\s", "").trim())) {
					f.getter(value).write(raf,
							(i * rowByteLength + f.getPositionInRow()));
					break;
				}
			}
		}
	}

	private AbstractField fieldFinder(String fieldName) throws CommandException {
		AbstractField f = null;
		for (AbstractField af : fieldsArray) {
			if (af.getName().equals(fieldName.replaceAll("\\s", "").trim())) {
				f = af;
			}
		}
		if (f == null)
			throw new CommandException("Field does not exist.");
		return f;
	}

	public ArrayList<Integer> where(String whereClause)
			throws CommandException, IOException {
		ArrayList<Integer> rows = new ArrayList<Integer>();
		// if there is no where clause, add every row to the list and return
		if (whereClause.equals("")) {
			for (int row = 0; row < raf.length() / rowByteLength; row++) {
				rows.add(row);
			}
			return rows;
		}
		// else find what rows need to be updated/deleted
		Pattern where = Pattern
				.compile("(\\w+)\\s*(=|!=|<=|>=|<|>){1}\\s*(.+)");
		Matcher wherem = where.matcher(whereClause);
		if (!wherem.find()) {
			throw new CommandException("Incorrect where clause.");
		}
		AbstractField f = fieldFinder(wherem.group(1).replaceAll("\\s", ""));

		for (int rowP = 0; rowP < raf.length() / rowByteLength; rowP++) {
			// point = rowP + f.getPositionInRow() + 1;
			AbstractType original = f.getter(raf,
					(rowP * rowByteLength + f.getPositionInRow()));
			AbstractType compare = f.getter(wherem.group(3).replaceAll("\\s",
					""));
			if (compare(original.compareTo(compare), wherem.group(2)
					.replaceAll("\\s", ""))) { // compares the field in each row
				rows.add(rowP);
			}
		}

		return rows;
	}

	private boolean compare(int compared, String relop) throws IOException,
			CommandException {
		boolean out = false;
		if (compared == 0) {
			if (relop.equals("=") | relop.equals("<=") | relop.equals(">=")) {
				out = true;
			}
		} else if (compared > 0) {
			if (relop.equals(">=") | relop.equals(">") | relop.equals("!=")) {
				out = true;
			}
		} else {
			if (relop.equals("<=") | relop.equals("<") | relop.equals("!=")) {
				out = true;
			}
		}
		return out;
	}

}
