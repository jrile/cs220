package main.commands;

import org.junit.Before;

/**
 * The Class SelectCommandTest.
 */
public class SelectCommandTest extends AbstractCommandTest {

	/**
	 * Sets up both good and bad strings to be tested with AbstractCommandTest
	 */
	@Override
	@Before
	public void setUp() throws Exception {
		tester = new SelectCommand();
		good = new String[] { "SELECT a;", "select  a ;", "  select  a ;" };
		bad = new String[] { "selecta;", "select;", "select a" };
	}

}
