package test;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

import main.DictionaryParser;
import junit.framework.TestCase;

public class DictionaryParserTest extends TestCase {
	
	public DictionaryParserTest(String name){
		
	}
	private DictionaryParser parser;
	private DictionaryParser createParser(String dictText) throws IOException{
		Reader reader=new StringReader(dictText);
		return new DictionaryParser(reader);
	}
	
	public void assertNextTranslation(String german, String trans) throws IOException{
		assertTrue(parser.hasNextTranslation());
		parser.nextTranslation();
		assertEquals(german, parser.currentGermanWord());
		assertEquals(trans, parser.currentTranslation());
	}
	public void testEmptyReader() throws IOException{
		parser = this.createParser("");
		assertFalse(parser.hasNextTranslation());
	}
	
	public void testOneLine() throws IOException{
		String dictText = "Buch=book";
		parser = this.createParser(dictText);
		this.assertNextTranslation("Buch", "book");
		assertFalse(parser.hasNextTranslation());
	}
	
	public void testThreeLines() throws IOException{
		String dictText="Buch=book\n"+"Auto=car\n"+"Buch=volume";
		parser=this.createParser(dictText);
		this.assertNextTranslation("Buch", "book");
		this.assertNextTranslation("Auto", "car");
		this.assertNextTranslation("Buch", "volume");
		assertFalse(parser.hasNextTranslation());
	}
	
}
