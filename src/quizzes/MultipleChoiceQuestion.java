package quizzes;

import java.util.List;

public class MultipleChoiceQuestion extends Question {
	private static final long serialVersionUID = 1L;
	private List<String> options;
	private int correctAnswerIndex;
	
	public MultipleChoiceQuestion(String questionText, List<String> options ,int correctAnswerIndex) {
		super(questionText, options.get(correctAnswerIndex));
		this.options = options;
		this.correctAnswerIndex = correctAnswerIndex;
	}
	
	@Override
    public void displayQuestion() {
        System.out.println(questionText);
        for (int i = 0; i < options.size(); i++) {
            System.out.println((i + 1) + ") " + options.get(i));
        }
        System.out.print("Enter the number of your choice: ");
    }
	
	@Override
	public boolean checkAnswer(String userAnswer) {
	    try {
	        int chosenIndex = Integer.parseInt(userAnswer) - 1;
	        return chosenIndex == this.correctAnswerIndex;
	    } catch (NumberFormatException e) {
	        return false;
	    }
	}
	
	

}
