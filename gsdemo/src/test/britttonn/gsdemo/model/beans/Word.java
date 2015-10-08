package test.britttonn.gsdemo.model.beans;

public class Word {
	private String text;

	public Word() {
	}

	public Word(String text) {
		setText(text);
	}
	
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
	
}
