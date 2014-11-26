package mocks;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;
import main.LineWriter;
import main.TextFormatter;

public class MockLineWriter implements LineWriter{
	
	private List expectedLines = new ArrayList();
	
	public void addExpectedLine(String expectedLine) {
		// TODO Auto-generated method stub
		addLine(expectedLine);
	}	

	public void verify(TextFormatter formatter) {
		// TODO Auto-generated method stub
		List formattedLines = formatter.getFormattedLines();
		for (int i = 0; i < expectedLines.size(); i++) {
	         String expectedLine = (String) expectedLines.get(i);
	         String formattedLine = (String) formattedLines.get(i);
	         Assert.assertEquals(expectedLine, formattedLine);
	      }
	}

	public void addLine(String line) {
		// TODO Auto-generated method stub
		expectedLines.add(line);
	}

	public List getLines() {
		// TODO Auto-generated method stub
		return null;
	}

}
