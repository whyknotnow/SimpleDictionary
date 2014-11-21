package test;

import main.Dictionary;
import junit.framework.TestCase;

public class DictionaryTest extends TestCase {
	private Dictionary dict;
	
	public void setUp(){
		dict = new Dictionary();
	}
	
	public void testCreation(){
		assertTrue(dict.isEmpty());
	}
	
	public void testOneTranslation(){
		dict.addTranslation("Buch", "book");
		assertFalse("dict is not empty", dict.isEmpty());
		String trans = dict.getTranslation("Buch");
		assertEquals("book", trans);
	}
	
	public void testTwoTranslations(){
		dict.addTranslation("Buch", "book");
		dict.addTranslation("Auto", "car");
		assertFalse("dict is not empty", dict.isEmpty());
		assertEquals("translation Buch", "book", dict.getTranslation("Buch"));
		assertEquals("translation Auto", "car", dict.getTranslation("Auto"));
	}
	
	public void testTranslationWithTwoEntries(){
		dict.addTranslation("Buch", "book");
		dict.addTranslation("Buch", "volume");
		String trans = dict.getTranslation("Buch");
		assertEquals("book, volume", trans);
	}
}
