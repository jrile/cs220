package main;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import main.commands.CommandException;

/**
 * Main collection that contains all of the tables in the database.
 * 
 */
public class TableCollection {

	private HashMap<String, Table> hm = new HashMap<String, Table>();

	private TableCollection() {
	}

	private static TableCollection tc = null;

	/**
	 * Returns the single table collection which contains all tables defined.
	 * 
	 * @return the Table Collection
	 */
	public static TableCollection getTC() {
		if (tc == null)
			tc = new TableCollection();
		return tc;
	}

	/**
	 * Adds a defined table into the collection.
	 * 
	 * @param table
	 *            - Single table to be added to collection.
	 * @throws CommandException
	 */
	public void add(String tableName, Table table) throws CommandException {
		if (hm.get(tableName) != null)
			throw new CommandException("Table name \"" + tableName
					+ "\" already exists.");
		hm.put(tableName, table);
	}

	/**
	 * Neatly iterates through the table collection and prints out all of the
	 * table names and fields contained within.
	 */
	@Override
	public String toString() {
		String out = new String("");

		for (String key : hm.keySet()) {
			out += "\n" + "    Table \"" + key + "\" -\n"
					+ hm.get(key).toString() + "\n";
		}
		return out;

	}

	/**
	 * Attempts to drop a table from the collection by searching through it
	 * 
	 * @param tablename
	 *            - The table name that is to be dropped from the collection.
	 * @throws CommandException
	 *             - If table is not found.
	 */
	public void remove(String tablename) throws CommandException {
		if (hm.remove(tablename) == null)
			throw new CommandException("Table name \"" + tablename
					+ "\" does not exist.");
		else {
			System.out.println(tablename + " was dropped.");
			new File(tablename).delete(); // deletes random access file for this
			// table
		}
	}

	/**
	 * Changes the name of a table.
	 * 
	 * @param oldTableName
	 *            The old table name to be renamed.
	 * @param newTableName
	 *            The new name.
	 * @throws CommandException
	 *             if Table can not be found.
	 */
	public void rename(String oldTableName, String newTableName)
			throws CommandException {

		Table v = hm.remove(oldTableName);
		if (v == null)
			throw new CommandException("Table name \"" + oldTableName
					+ "\" does not exist.");
		else {
			hm.put(newTableName, v);
			System.out.println(oldTableName + " was renamed to " + newTableName
					+ ".");
		}
	}

	public String toXML() {
		String out = "";

		for (String key : hm.keySet()) {
			out += "\t<TABLE NAME=\"" + key + "\">" + hm.get(key).toXML()
					+ "\t</TABLE>\n";

		}

		return out;
	}

	public void insert(String tableName, String[] values)
			throws CommandException {
		if (hm.get(tableName) == null)
			throw new CommandException(tableName + " does not exist!");

		try {
			hm.get(tableName).insert(values);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void print(String query) throws IOException, CommandException {
		if (hm.get(query) == null)
			throw new CommandException(query + " does not exist!");
		System.out.print(hm.get(query).select(""));

	}

	public void select(String tableName, String whereClause)
			throws CommandException, IOException {
		if (hm.get(tableName) == null)
			throw new CommandException(tableName + " does not exist!");
		System.out.print(hm.get(tableName).select(whereClause));
	}

	public void update(String tableName, String value, String fieldName,
			String whereClause) throws CommandException, IOException {
		if (hm.get(tableName) == null)
			throw new CommandException(tableName + " does not exist!");
		hm.get(tableName).update(whereClause, fieldName, value);
	}

	public void delete(String tableName, String whereClause)
			throws CommandException, IOException {
		if (hm.get(tableName) == null)
			throw new CommandException(tableName + " does not exist!");
		hm.get(tableName).delete(whereClause);
	}
}
