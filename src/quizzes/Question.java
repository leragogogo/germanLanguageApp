package quizzes;

import java.io.Serializable;

public class Question implements Serializable{
	private static final long serialVersionUID = 1L;
	protected String questionText;
	protected String correctAnswer;
	
	public Question(String questionText, String correctAnswer) {
		this.questionText = questionText;
		this.correctAnswer = correctAnswer;
	}
	
    public void displayQuestion() {
        System.out.println(questionText);
        System.out.print("Your answer: ");
    }

  
    public boolean checkAnswer(String userAnswer) {
        return userAnswer.trim().equalsIgnoreCase(correctAnswer.trim());
    }

    
    public void showCorrectAnswer() {
        System.out.println("The correct answer is: " + correctAnswer);
    }
}
