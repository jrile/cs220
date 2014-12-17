package main.commands;

import org.junit.Before;

/**
 * The Class ProjectCommandTest.
 */
public class ProjectCommandTest extends AbstractCommandTest {

	/**
	 * Sets up both good and bad strings to be tested with AbstractCommandTest
	 */
	@Override
	@Before
	public void setUp() throws Exception {
		tester = new ProjectCommand();
		good = new String[] { "project a over b;", "PROJECT a over b;",
				"project  a  over  b;", "  project a over b;" };
		bad = new String[] { "project a to b;", "project a b;",
				"project a over b" };
	}

}
