package main.commands;

import org.junit.Before;

/**
 * The Class DefineIndexCommandTest.
 */
public class DefineIndexCommandTest extends AbstractCommandTest {

	/**
	 * {@inheritDoc}
	 */
	@Override
	@Before
	public void setUp() throws Exception {
		tester = new DefineIndexCommand();
		good = new String[] { "define index on (filename);",
				"define  index  on(filename);", "DEFINE INDEX ON (filename);",
				"  define INDEX on (filename);" };
		bad = new String[] { "defineindex on filename;",
				"define indexon filename;", "defin index on filename",
				"define index on filename" };

	}

}
