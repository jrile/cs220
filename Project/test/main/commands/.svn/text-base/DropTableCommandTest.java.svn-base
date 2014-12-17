package main.commands;

import org.junit.Before;

/**
 * The Class DropTableCommandTest.
 */
public class DropTableCommandTest extends AbstractCommandTest {

	/**
	 * {@inheritDoc}
	 */
	@Override
	@Before
	public void setUp() throws Exception {
		tester = new DropTableCommand();
		good = new String[] { "drop table filename;", "DROP table filename;",
				"drop table   filename;", " DROP TABLE  filename;" };
		bad = new String[] { "droptable filename;", "drop tablefilename;" };

	}

}
