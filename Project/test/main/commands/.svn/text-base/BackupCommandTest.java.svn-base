package main.commands;

import org.junit.Before;

/**
 * The Class BackupCommandTest.
 */
public class BackupCommandTest extends AbstractCommandTest {

	/**
	 * {@inheritDoc}
	 */
	@Override
	@Before
	public void setUp() throws Exception {
		tester = new BackupCommand();
		good = new String[] { "backup to 'filename';",
				"BACKUP  to 'filename';", "backup to   'filename';",
				"BACKUP  TO  'filename';" };
		bad = new String[] { "back up to filename;", "bac k up to filename;",
				"back up to filename;" };

	}

}
