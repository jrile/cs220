package main.commands;

import org.junit.Before;

public class PrintCommandTest extends AbstractCommandTest {

	@Override
	@Before
	public void setUp() throws Exception {
		tester = new PrintCommand();
		good = new String[] { "print table;", "PRINT aaaaa;", "print  a a ;",
				" prINT aaaa;" };
		bad = new String[] { "print aaa", "p rint aaa;" };
	}

}
