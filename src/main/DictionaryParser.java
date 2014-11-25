package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;

public class DictionaryParser {
	private BufferedReader reader;
	private String nextLine;
	private String currentGermanWord;
	private String currentTranslation;
	
	public DictionaryParser(Reader unbufferedReader) throws IOException{
		reader = new BufferedReader(unbufferedReader);
		this.readNextLine();
	}

	public String currentTranslation() {
		// TODO Auto-generated method stub
		return currentTranslation;
	}

	public String currentGermanWord() {
		// TODO Auto-generated method stub
		return currentGermanWord;
	}

	public boolean hasNextTranslation() {
		// TODO Auto-generated method stub
		return nextLine != null;
	}

	public void nextTranslation() throws IOException {
		// TODO Auto-generated method stub
		int index = nextLine.indexOf("=");
		currentGermanWord = nextLine.substring(0, index);
		currentTranslation = nextLine.substring(index + 1);
		this.readNextLine();
	}

	private void readNextLine() throws IOException {
		// TODO Auto-generated method stub
		nextLine = reader.readLine();
	}
	
	
}
