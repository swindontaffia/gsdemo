package test.britttonn.gsdemo.junit;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import test.britttonn.gsdemo.model.beans.Word;


public class WordTestCases {

	private static final String TEST_TEXT_1 = "Test1";
	private static final String TEST_TEXT_2 = "Test2";

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test1() {
		Word word = new Word();
		word.setText(TEST_TEXT_1);
		assertTrue(word.getText().equals(TEST_TEXT_1));
	}
	
	@Test
	public void test2() {
		Word word = new Word(TEST_TEXT_2);
		assertTrue(word.getText().equals(TEST_TEXT_2));
		assertFalse(word.getText().equals(TEST_TEXT_1));
	}

}
