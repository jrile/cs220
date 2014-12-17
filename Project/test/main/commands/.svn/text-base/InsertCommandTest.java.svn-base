package main.commands;

import org.junit.Before;

/**
 * The Class InsertCommandTest.
 */
public class InsertCommandTest extends AbstractCommandTest {

	/**
	 * {@inheritDoc}
	 */
	@Override
	@Before
	public void setUp() throws Exception {
		tester = new InsertCommand();
		good = new String[] { "insert (a) into b;", "INSERT(a)INTO b;",
				"insert  (a)  into  b;", "  insert (a) into b;" };
		bad = new String[] { "insert a to b;", "insert a b;" };

	}

}
