package main.commands;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * The Class AbstractCommandTest.
 */
public abstract class AbstractCommandTest {

	/** The good strings to be asserted true. */
	protected String[] good;

	/**
	 * Abstract method to set up the good and bad strings.
	 * 
	 * @throws Exception
	 *             any generic exception
	 */
	public abstract void setUp() throws Exception;

	/** The bad strings to be asserted false. */
	protected String[] bad;

	/** The tester. */
	ICommand tester;

	/**
	 * Instantiates a new abstract command test.
	 */
	public AbstractCommandTest() {
		super();
	}

	/**
	 * Test matches. Goes through each array and asserts true or false
	 */
	@Test
	public void testMatches() {
		for (String s : good) {
			assertTrue(tester.matches(s));
		}
		for (String s : bad) {
			assertFalse(tester.matches(s));
		}
	}

}