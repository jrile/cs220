package main.commands;

import org.junit.Before;

/**
 * The Class IntersectCommandTest.
 */
public class IntersectCommandTest extends AbstractCommandTest {

	/**
	 * Sets up both good and bad strings to be tested with AbstractCommandTest
	 */
	@Override
	@Before
	public void setUp() throws Exception {
		tester = new IntersectCommand();
		good = new String[] { "intersect a and b;", "INTERSECT a AND b;",
				"intersect  a  and  b;", "  intersect a and b;" };
		bad = new String[] { "intersect a to b;", "intersect a b;",
				"intersect a and b" };

	}

}
