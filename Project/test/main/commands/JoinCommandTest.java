package main.commands;

import org.junit.Before;

/**
 * The Class JoinCommandTest.
 */
public class JoinCommandTest extends AbstractCommandTest {

	/**
	 * Sets up both good and bad strings to be tested with AbstractCommandTest
	 */
	@Override
	@Before
	public void setUp() throws Exception {
		tester = new JoinCommand();
		good = new String[] { "join a and b;", "JOIN a AND b;",
				"join  a  and  b;", "  join a and b;" };
		bad = new String[] { "join a to b;", "join a b;", "join a and b" };
	}

}
