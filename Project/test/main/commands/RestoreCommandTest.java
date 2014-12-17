package main.commands;

import org.junit.Before;

/**
 * The Class RestoreCommandTest.
 */
public class RestoreCommandTest extends AbstractCommandTest {

	/**
	 * Sets up both good and bad strings to be tested with AbstractCommandTest
	 */
	@Override
	@Before
	public void setUp() throws Exception {
		tester = new RestoreCommand();
		good = new String[] { "RESTORE FROM 'a';", "restore   from 'a';",
				"restore from  'a' ;", "  restore from 'a';" };
		bad = new String[] { "restorefrom 'a b';", "restore from a" };
	}

}
