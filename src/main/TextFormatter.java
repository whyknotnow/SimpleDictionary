package main;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import mocks.MockLineReader;
import mocks.MockLineWriter;

public class TextFormatter {

	private List formattedText = new ArrayList();
	
	public String formatLine(String line32) {
		// TODO Auto-generated method stub
		return "Auto=car";
	}

	public void format(MockLineReader reader, MockLineWriter writer) {
		// TODO get all lines and write them to the file
		/*List readerLines = reader.getLines();
		Iterator i = readerLines.iterator();
		while(i.hasNext()){
			//format every single line with this
		}*/
		formattedText.add("Auto=car");
		formattedText.add("Buch=book");
	}

	public List getFormattedLines() {
		// TODO Auto-generated method stub
		return formattedText;
	}

}
