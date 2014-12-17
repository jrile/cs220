package fields;

import static org.junit.Assert.*;

import org.junit.Test;

public class BooleanFieldTest {
	public String[] good = new String[] { "Test", "Yo", "Whatsup", "Howdy",
			"Onetwothree" };
	private String bad = "hello";

	@Test
	public void testToString() {

		for (String i : good) {
			assertTrue(new BooleanField(i, 0).toString().equals(
					"Boolean\t\t" + i));
		}
		for (String i : good) {
			assertFalse(new BooleanField(bad, 0).toString().equals(
					"Boolean\t\t" + i));
		}
	}

}
