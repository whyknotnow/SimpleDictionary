package test;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

import exception.DictionaryParserException;
import main.DictionaryParser;
import junit.framework.TestCase;

public class DictionaryParserTest extends TestCase {
	
	private DictionaryParser parser;
	
	private DictionaryParser createParser(String dictText) throws IOException{
		Reader reader=new StringReader(dictText);
		return new DictionaryParser(reader);
	}
	
	public void assertNextTranslation(String german, String trans) throws IOException, DictionaryParserException{
		assertTrue(parser.hasNextTranslation());
		parser.nextTranslation();
		assertEquals(german, parser.currentGermanWord());
		assertEquals(trans, parser.currentTranslation());
	}
	public void testEmptyReader() throws IOException{
		parser = this.createParser("");
		assertFalse(parser.hasNextTranslation());
	}
	
	public void testOneLine() throws IOException, DictionaryParserException{
		String dictText = "Buch=book";
		parser = this.createParser(dictText);
		this.assertNextTranslation("Buch", "book");
		assertFalse(parser.hasNextTranslation());
	}
	
	public void testThreeLines() throws IOException, DictionaryParserException{
		String dictText="Buch=book\n"+"Auto=car\n"+"Buch=volume";
		parser=this.createParser(dictText);
		this.assertNextTranslation("Buch", "book");
		this.assertNextTranslation("Auto", "car");
		this.assertNextTranslation("Buch", "volume");
		assertFalse(parser.hasNextTranslation());
	}
	
	public void testEmptyLine() throws IOException, DictionaryParserException{
		String dictText = "Buch=book\n" +"\n" + "Auto=car";
		parser = this.createParser(dictText);
		this.assertNextTranslation("Buch","book");
		try{
			parser.nextTranslation();
			fail("DictionaryParserException expected");
		} catch(DictionaryParserException expected){
			assertEquals("message", expected.getMessage());
		}
		this.assertNextTranslation("Auto", "car");
		assertFalse(parser.hasNextTranslation());
	}
	
	public void testLineWithoutEquals() throws Exception{
		String dictText = "Buch=book\n" + "Auto car";
		parser = this.createParser(dictText);
		this.assertNextTranslation("Buch","book");
		try{
			parser.nextTranslation();
			fail("DictionaryParserException expected");
		}catch(DictionaryParserException expected){
			
		}
		this.assertNextTranslation("Auto", "car");
		assertFalse(parser.hasNextTranslation());
	}
}
