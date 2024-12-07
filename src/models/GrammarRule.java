package models;

import java.io.Serializable;
import java.util.List;

public class GrammarRule implements Serializable{
	private static final long serialVersionUID = 1L;
	private String name;
	private String explanation;
	private List<String> examplesOfUsage;
	
	public GrammarRule(String name, String explanation, List<String> examplesOfUsage) {
		this.name = name;
		this.explanation = explanation;
		this.examplesOfUsage = examplesOfUsage;
	}
	
	public String getName() {
		return name;
	}

	public String getExplanation() {
		return explanation;
	}

	public List<String> getExamplesOfUsage() {
		return examplesOfUsage;
	}
}
