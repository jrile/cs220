package main.commands;

import org.junit.Before;

/**
 * The Class UnionCommandTest.
 */
public class UnionCommandTest extends AbstractCommandTest {

	/**
	 * Sets up both good and bad strings to be tested with AbstractCommandTest
	 */
	@Override
	@Before
	public void setUp() throws Exception {
		tester = new UnionCommand();
		good = new String[] { "union a and b;", "UNION a AND b;",
				"union  a  and  b;", "  union a and b;" };
		bad = new String[] { "union a to b;", "union a b;", "union a and b" };
	}

}
