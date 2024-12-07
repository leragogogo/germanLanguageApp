package lessons;

import java.io.Serializable;
import java.util.List;

import interfaces.Activity;
import models.GrammarRule;

public class GrammarLesson extends Lesson implements Activity, Serializable{
	private static final long serialVersionUID = 1L;
	private List<GrammarRule> grammarRules;
	public GrammarLesson(String theme, List<GrammarRule> grammarRules){
		super(theme);
		this.grammarRules = grammarRules;
	}
	
	@Override
	public void delay() {
		try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
	}
	
	@Override
    public void start() {
		System.out.println();
        for(var i = 0; i < this.grammarRules.size(); i++) {
        	System.out.println("Recall this rule: " + this.grammarRules.get(i).getName());
        	delay();
        	System.out.println(this.grammarRules.get(i).getExplanation());
        	delay();
        	for(var j = 0; j < this.grammarRules.get(i).getExamplesOfUsage().size(); j++) {
        		System.out.println("Example: " + this.grammarRules.get(i).getExamplesOfUsage().get(j));
        		
        	}
        	System.out.println("-------------------------------");
        	delay();
        }
    }

    @Override
    public void end() {
    	System.out.println("Wunderbar! You've learned today that much complicated grammar rules: " + this.grammarRules.size());
        delay();
        System.out.println();
    }
}
