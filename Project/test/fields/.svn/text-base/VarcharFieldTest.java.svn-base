package fields;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

import org.junit.Before;
import org.junit.Test;

public class VarcharFieldTest {
	private String out;
	private RandomAccessFile rafTest;
	private RandomAccessFile rafTest2;

	@Before
	public void setUp() throws Exception {
		rafTest = new RandomAccessFile(new File("rafTest"), "rw");
		rafTest2 = new RandomAccessFile(new File("rafTest2"), "rw");
		rafTest2.writeUTF("TEST");
		rafTest.writeLong(0);

		rafTest.seek(0);
		rafTest2.seek(rafTest.readLong());
		out = rafTest2.readUTF();
		rafTest.close();
		rafTest2.close();
	}

	@Test
	public void testPrint() throws IOException {

		assertTrue(out.equals("TEST"));
	}

}
