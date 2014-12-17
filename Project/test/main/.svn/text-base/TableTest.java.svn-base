package main;

import static org.junit.Assert.*;

import java.io.IOException;

import main.commands.CommandException;

import org.junit.Before;
import org.junit.Test;

public class TableTest {
	private Table tester;

	@Before
	public void setUp() throws CommandException {
		tester = new Table("Test", "Name varchar, Age integer");
	}

	@Test
	public void testToString() throws CommandException {
		// Table tester = new Table("", "Name varchar, Age integer");
		String good = "-------------------------\nType\t\tName\n-------------------------\nVarchar\t\tName\nInteger\t\tAge\n";
		String bad = "Field Type: Name \n [Varchar] : Name \n [Integer] : Age";
		String bad2 = "-------------------------\nType\t\tName\n------------------------- Varchar  Name Integer\t\tAge\n";
		assertTrue(tester.toString().equals(good));
		assertFalse(tester.toString().equals(bad));
		assertFalse(tester.toString().equals(bad2));
	}

	@Test
	public void testPrint() throws CommandException, IOException {
		// Jonathan 19
		tester.insert("\'Jonathan\', 19".split(",\\s*"));
		String good = "Varchar\t\tInteger\t\t\nName\t\tAge\t\t\n-------------------------------------------------\nJonathan\t\t19\t\t\n";

		assertTrue(tester.select("").equals(good));
	}

}
