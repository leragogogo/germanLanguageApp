package models;

import java.io.Serializable;

public class FlashCard implements Serializable{
	private static final long serialVersionUID = 1L;
	private String german;
	private String english;
	
	public FlashCard(String english, String german) {
		this.english = english;
		this.german = german;
	}
	
	public String getGermanWord() {
		return german;
	}
	
	public String getEnglishWord() {
		return english;
	}
	
}
