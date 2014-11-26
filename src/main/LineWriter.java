package main;

import java.util.List;

public interface LineWriter {
	//writes line to the buffer

	public void addLine(String line);
	public List getLines();
}
