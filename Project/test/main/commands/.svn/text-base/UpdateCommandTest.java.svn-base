package main.commands;

import org.junit.Before;

/**
 * The Class UpdateCommandTest.
 */
public class UpdateCommandTest extends AbstractCommandTest {

	/**
	 * Sets up both good and bad strings to be tested with AbstractCommandTest
	 */
	@Override
	@Before
	public void setUp() throws Exception {
		tester = new UpdateCommand();
		good = new String[] { "update a set b = c;", "UPDATE a SET b = c;",
				"update  a  set c =  b;", "  update a set b=c;" };
		bad = new String[] { "update set b = c;", "update a set b c;",
				"update a set b = c" };
	}

}
