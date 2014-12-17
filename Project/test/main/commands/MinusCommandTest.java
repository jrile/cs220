package main.commands;

import org.junit.Before;

/**
 * The Class MinusCommandTest.
 */
public class MinusCommandTest extends AbstractCommandTest {

	/**
	 * Sets up both good and bad strings to be tested with AbstractCommandTest
	 */
	@Override
	@Before
	public void setUp() throws Exception {
		tester = new MinusCommand();
		good = new String[] { "minus a and b;", "MINUS a AND b;",
				"minus  a  and  b;", "  minus a and b;" };
		bad = new String[] { "minus a to b;", "minus a b;", "minus a and b" };
	}

}
