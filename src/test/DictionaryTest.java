package test;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.io.StringBufferInputStream;

import junit.framework.TestCase;
import main.Dictionary;

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
	
	/*public void testSimpleFile(){
		dict = new Dictionary("C:\\Dictionary\\simple.dic");
		assertTrue(!dict.isEmpty());
	}*/
	
	/*public void testTwoTranslationsFromStream() throws IOException{
		String dictText = "Buch=book\n" + "Auto=car";
		InputStream in = new InputStream(dictText);
		dict = new Dictionary(in);
		assertFalse("dict not empty", dict.isEmpty());
		assertEquals("translation Buch", "book", dict.getTranslation("Buch"));
		assertEquals("translation Auto", "car", dict.getTranslation("Auto"));
	}
	
	public void testTranslationsWithTwoEntriesFromStream() throws IOException{
		String dictText = "Buch=book\n" + "Buch=volume";
		InputStream in = new StringBufferInputStream(dictText);
		dict = new Dictionary(in);
		String trans = dict.getTranslation("Buch");
		assertEquals("book, volume", trans);
	}*/
}
