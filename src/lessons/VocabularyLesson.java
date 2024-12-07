package lessons;

import java.io.Serializable;
import java.util.List;

import interfaces.Activity;
import models.FlashCard;

public class VocabularyLesson extends Lesson implements Activity,Serializable {
	private static final long serialVersionUID = 1L;
	private List<FlashCard> flashCards;
	public VocabularyLesson(String theme, List<FlashCard> flashCards) {
		super(theme);
		this.flashCards = flashCards;
	}
	
	@Override
	public void delay() {
		try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
	}
	
	@Override
    public void start() {
		System.out.println();
	    for(var i = 0; i < this.flashCards.size(); i++) {
		    System.out.println("English word: "+ this.flashCards.get(i).getEnglishWord());
		    delay();
		    System.out.println("Deutsche Wort: "+ this.flashCards.get(i).getGermanWord());
		    System.out.println("-------------------------------");
		    delay();
	    }
    }

    @Override
    public void end() {
        System.out.println("Schön! You've learned today " + this.flashCards.size() + " words");
        delay();
        System.out.println();
    }
}

