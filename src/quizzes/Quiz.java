package quizzes;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import interfaces.Activity;
import utils.ConsoleManager;

public class Quiz implements Activity, Serializable{
	private static final long serialVersionUID = 1L;
	private String name;
	private List<Question> questions;
	transient private int score;
	
	public Quiz(String name,List<Question> questions) {
		this.name = name;
		this.questions = questions;
		this.score = 0;
	}
	
	public Quiz(String name) {
		this.name = name;
		this.questions = new ArrayList<>();
		this.score = 0;
	}
	
	public void addQuestion(Question question) {
        this.questions.add(question);
    }
	
	@Override
	public void start() {
		System.out.println();
        for (Question q : questions) {
            q.displayQuestion();
            String userAnswer = ConsoleManager.scanner.nextLine();

            boolean correct = q.checkAnswer(userAnswer);
            if (correct) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Incorrect!");
                q.showCorrectAnswer();
            }
            System.out.println();
        }

	}
	
	
	@Override
	public void end() {
		System.out.println("Quiz completed!");
		System.out.println("You got " + this.score + " points!");
		System.out.println();
	}

	public String getName() {
		return name;
	}

	
	
}
