package main.commands;

import org.junit.Before;

/**
 * The Class RenameCommandTest.
 */
public class RenameCommandTest extends AbstractCommandTest {

	/**
	 * Sets up both good and bad strings to be tested with AbstractCommandTest
	 */
	@Override
	@Before
	public void setUp() throws Exception {
		tester = new RenameCommand();
		good = new String[] { "rename table   a TO b;",
				"rename   table a TO b;", "rename TABLE  a  TO  b;",
				"  rename table a to b;" };
		bad = new String[] { "rename table a and b;", "rename table a b;",
				"rename table a to b" };
	}

}
