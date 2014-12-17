package main.commands;

import org.junit.Before;

/**
 * The Class DefineTableCommandTest.
 */
public class DefineTableCommandTest extends AbstractCommandTest {

	/**
	 * {@inheritDoc}
	 */
	@Override
	@Before
	public void setUp() throws Exception {
		tester = new DefineTableCommand();
		good = new String[] { "define table tablename having fields (a);",
				"define  table  tablename  having  fields  (a);",
				"DEFINE TABLE tablename having FIELDS (a);",
				"  define TABLE tablename having fields (a);" };
		bad = new String[] { "define tabletablename;",
				"definetable tablename;", "define table on tablename",
				"define table tablename having fields a" };

	}

}
