package xml;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

import main.TableCollection;

public class XMLWriter {

	public void write(String file) throws FileNotFoundException {
		String ENCODING = "ISO-8859-1";
		PrintWriter out = new PrintWriter(new FileOutputStream(file));
		out.println("<?xml version=\"1.0\" encoding=\"" + ENCODING + "\"?>");
		// out.println("<!DOCTYPE USERS SYSTEM \"tablecollection.dtd\">");
		out.println("<TABLECOLLECTION>");

		out.println(TableCollection.getTC().toXML());

		out.println("</TABLECOLLECTION>");
		out.close();

		if (!new File("tablecollection.dtd").exists()) {
			PrintWriter out2 = new PrintWriter(new FileOutputStream(
					"tablecollection.dtd"));
			out2.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
			out2.println("<!ELEMENT TABLECOLLECTION (TABLE*)>");
			out2.println("<!ELEMENT TABLE (FIELD)>");
			out2.println("<!ELEMENT FIELD>");
			out2.println("<!ELEMENT FIELDNAME (#PCDATA)>");
			out2.println("<!ELEMENT FIELDTYPE (#PCDATA)>");
			out2.println("NAME CDATA #REQUIRED");
			out2.close();
		}
	}
}
