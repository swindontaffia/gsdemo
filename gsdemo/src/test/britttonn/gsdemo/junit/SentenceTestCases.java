package test.britttonn.gsdemo.junit;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import test.britttonn.gsdemo.model.beans.Sentence;
import test.britttonn.gsdemo.model.beans.Word;

public class SentenceTestCases {
	
	private static final String [] TEST_SENTENCE_1_WORDS = { "This", "is", "test", "one" };
	private static final String TEST_SENTENCE_1_SENTENCE = "This is test one.";
	private static final String [] TEST_SENTENCE_2_WORDS = { "This", "is", "test", "two" };
	private static final String TEST_SENTENCE_2_SENTENCE = "This is test two.";
	
	private static List<Word> words1 = new ArrayList<>();
	private List<Word> words2 = new ArrayList<>(); 

	private static List<Word> getWordList(String[] testSentenceWords) {
		List<Word> words = new ArrayList<>();
		for(String word : testSentenceWords) {
			words.add(new Word(word));
		}
		
		return words;
	}

	@BeforeClass
	public static void setUpBeforeClass() {
		// Run once at start of test
		words1 = getWordList(TEST_SENTENCE_1_WORDS);
	}

	@AfterClass
	public static void tearDownAfterClass() {
	}

	@Before
	public void setUp() {
		// run for each test
		words2 = getWordList(TEST_SENTENCE_2_WORDS);
	}

	@After
	public void tearDown() {
	}

	@Test
	public void test1() {
		Sentence sentence = new Sentence();
		for(Word word : words1) {
			sentence.addWord(word);
		}
		
		assertTrue(sentence.toString().equals(TEST_SENTENCE_1_SENTENCE));
		int i = 0;
		for(Word word2 : sentence.getWords()) {
			assertTrue(words1.get(i).equals(word2));
			i++;
		}
		
	}
	
	@Test
	public void test2() {
	
		Sentence sentence = new Sentence().addWords(words2);
		assertTrue(sentence.toString().equals(TEST_SENTENCE_2_SENTENCE));
		int i = 0;
		for(Word word2 : sentence.getWords()) {
			assertTrue(words2.get(i).equals(word2));
			i++;
		}
	}

}
