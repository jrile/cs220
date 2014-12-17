package main;

import static org.junit.Assert.*;

import main.commands.CommandException;

import org.junit.Test;

public class TableCollectionTest {

	@Test
	public void testToXML() throws CommandException {
		TableCollection.getTC().add(
				"Hello",
				new Table("Hello",
						"Age integer, Name varchar, Initials char(3)"));
		TableCollection.getTC().add("Blech",
				new Table("Blech", "Sauce varchar"));

		String good = "\t<TABLE NAME=\"Blech\">\n\t\t<FIELD>\n\t\t\t<FIELDNAME>Sauce</FIELDNAME>\n\t\t\t<FIELDTYPE>Varchar</FIELDTYPE>\n</FIELD>\n\t</TABLE>\n\t<TABLE NAME=\"Hello\">\n\t\t<FIELD>\n\t\t\t<FIELDNAME>Age</FIELDNAME>\n\t\t\t<FIELDTYPE>Integer</FIELDTYPE>\n</FIELD>\n\t\t<FIELD>\n\t\t\t<FIELDNAME>Name</FIELDNAME>\n\t\t\t<FIELDTYPE>Varchar</FIELDTYPE>\n</FIELD>\n\t\t<FIELD>\n\t\t\t<FIELDNAME>Initials</FIELDNAME>\n\t\t\t<FIELDTYPE>Char(3)</FIELDTYPE>\n</FIELD>\n\t</TABLE>\n";
		assertTrue(TableCollection.getTC().toXML().equals(good));
	}

}
