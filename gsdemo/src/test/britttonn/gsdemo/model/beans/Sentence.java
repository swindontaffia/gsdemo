package test.britttonn.gsdemo.model.beans;

import java.util.ArrayList;
import java.util.List;

public class Sentence {

	private final List<Word> words = new ArrayList<>();
	
	// Optimization for toString
	private String fullText = "";
	private boolean isDirty = false; 

	public List<Word> getWords() {
		return words;
	}

	public Sentence addWord(Word word) {
		words.add(word);
		isDirty = true;
		return this;
	}

	public Sentence addWords(List<Word> words) {
		this.words.addAll(words);
		isDirty = true;
		return this;
	}

	public Sentence addText(String text) {
		if (text != null) {
			String[] textWords = text.split(" ");
			for (String textWord : textWords) {
				addWord(new Word(textWord));
			}
		}
		
		return this;
	}

	@Override
	public String toString() {
		if (isDirty) {
			StringBuilder sb = new StringBuilder();
			for (Word word : words) {
				sb.append(word.getText()).append(" ");
			}
			if(sb.length() > 0)
				fullText = sb.replace(sb.length()-1, sb.length()-1, ".").toString().trim();
			isDirty = false;
		}
		return fullText;
	}
}
