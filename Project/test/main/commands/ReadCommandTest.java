package main.commands;

import org.junit.Before;

/**
 * The Class ReadCommandTest.
 */
public class ReadCommandTest extends AbstractCommandTest {

	/**
	 * Sets up both good and bad strings to be tested with AbstractCommandTest
	 */
	@Override
	@Before
	public void setUp() throws Exception {
		tester = new ReadCommand();
		good = new String[] { "read 'a';", " READ 'a';", "read  'a';" };
		bad = new String[] { "reada;", "read a" };
	}

}
