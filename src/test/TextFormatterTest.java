package test;

import junit.framework.TestCase;
import main.TextFormatter;
import mocks.MockLineReader;
import mocks.MockLineWriter;

public class TextFormatterTest extends TestCase{
	
	/*public void testSpacesInWords() {
		TextFormatter formatter = new TextFormatter();
		String line32 = "Auto=  car";
		String line33 = " Buch= book   ";
		assertEquals("Auto=car", formatter.formatLine(line32));
		assertEquals("Buch=book", formatter.formatLine(line33));
	}*/
	
	public void testSpacesInWords() {
		MockLineReader reader = new MockLineReader();
		String line32 = "Auto=  car";
		String line33 = " Buch= book   ";
		reader.addLineToBeRead(line32);
		reader.addLineToBeRead(line33);
		MockLineWriter writer = new MockLineWriter();
		writer.addExpectedLine("Auto=car");
		writer.addExpectedLine("Buch=book");
		TextFormatter formatter = new TextFormatter();
		formatter.format(reader, writer);
		writer.verify(formatter);
		}
}
