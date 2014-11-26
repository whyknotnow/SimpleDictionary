package main;

import java.util.List;


public interface LineReader {
	//reads line from file

	public void addLineToBeRead(String line);
	public List getLines();
}
