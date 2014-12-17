package xml;

import java.io.IOException;
import main.Table;
import main.TableCollection;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;

public class XMLImport {

	public void saxReader(String file) throws SAXException, IOException {
		XMLReader reader = XMLReaderFactory.createXMLReader();
		reader.setContentHandler(new TableHandler());
		reader.parse(file);
	}

	private class TableHandler extends DefaultHandler {

		private boolean rows = false;
		private boolean fieldType = false;
		private boolean fieldName = false;
		private boolean charType = false;
		private String charLength;
		private String tableName, fieldList = "";

		@Override
		public void startElement(String uri, String localName, String qName,
				Attributes attributes) throws SAXException {

			if (qName.equals("TABLE")) {
				tableName = attributes.getValue("NAME");
			} else if (qName.equals("ROWS")) {
				rows = true;
			}

			else if (qName.equals("FIELDNAME"))
				fieldName = true;
			else if (qName.equals("FIELDTYPE")) {
				if (attributes.getValue(0) == (null))
					fieldType = true;
				else {
					charType = true;
					charLength = attributes.getValue(0);
				}

			}

		}

		@Override
		public void endElement(String uri, String localName, String qName)
				throws SAXException {
			if (qName.equals("TABLE")) {
				try {
					Table t = new Table(tableName, fieldList.substring(0,
							(fieldList.length() - 2)));

					TableCollection.getTC().add(tableName, t);
					tableName = "";
					fieldList = "";
				} catch (Exception e) {

				}

			}
		}

		@Override
		public void characters(char[] ch, int start, int length)
				throws SAXException {
			String username = new String(ch, start, length);
			if (rows) {
				Integer.parseInt(username);
				rows = false;
			} else if (fieldName) {
				fieldList += username + " ";
				fieldName = false;
			} else if (fieldType) {
				fieldList += username + ", ";
				fieldType = false;
			} else if (charType) {
				fieldList += username + "(" + charLength + "), ";
				charType = false;
				charLength = "";
			}

		}

	}
}
