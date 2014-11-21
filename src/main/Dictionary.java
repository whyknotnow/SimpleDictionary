package main;

import java.util.HashMap;
import java.util.Map;

public class Dictionary {

	private Map translations = new HashMap();
	
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
