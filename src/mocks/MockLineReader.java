package mocks;

import java.util.ArrayList;
import java.util.List;

import main.LineReader;

public class MockLineReader implements LineReader{
	
	private List linesToBeRead = new ArrayList();
	
	public void addLineToBeRead(String line) {
		// TODO Auto-generated method stub
		linesToBeRead.add(line);
	}
	
	public List getLines(){
		return linesToBeRead;
	}

}
