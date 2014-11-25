package main;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;

public class Dictionary {

	private Map translations = new HashMap();
	
	public Dictionary(Reader in) throws IOException {
		// TODO Auto-generated constructor stub
		this.readTranslation(in);
	}

	public Dictionary() {
		// TODO Auto-generated constructor stub
	}

	private void readTranslation(Reader reader) throws IOException{
		// TODO Auto-generated method stub
		DictionaryParser parser = new DictionaryParser(reader);
		while(parser.hasNextTranslation()){
			parser.nextTranslation();
			String german = parser.currentGermanWord();
			String trans = parser.currentTranslation();
			this.addTranslation(german, trans);
		}
		
	}

	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return translations.isEmpty();
	}

	public void addTranslation(String german, String translated) {
		// TODO Auto-generated method stub
		String before = this.getTranslation(german);
		String now;
		if(before==null){
			now = translated;
		} else {
			now = before + ", " + translated;
		} 
		translations.put(german, now);
	}

	public String getTranslation(String german) {
		// TODO Auto-generated method stub
		return (String) translations.get(german);
	}	
}
