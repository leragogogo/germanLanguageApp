package main;

import lessons.VocabularyLesson;
import lessons.GrammarLesson;
import quizzes.Quiz;
import java.util.List;

import utils.ConsoleManager;
import utils.FileManager;

public class Main {
	
	// printing of all actions that user can perform
	public static void printAllOptions() {
		System.out.println("What do you want to do?");
		System.out.println("1) Vocabulary lesson");
		System.out.println("2) Grammar lesson");
		System.out.println("3) Quiz");
		System.out.println("4) Add a new vocabulary lesson");
		System.out.println("5) Add a new grammar lesson");
		System.out.println("6) Add a quizz");
		System.out.println("7) Finish training. Sehr schade. Ich werde weinen :(");
		System.out.print("Enter the number of your choice: ");
	}

	public static void main(String[] args) {
		// reading of information from files
		List<VocabularyLesson> vocabLessons = FileManager.readVocabLessons();
		List<GrammarLesson> grammarLessons = FileManager.readGrammarLessons();
		List<Quiz> quizzes = FileManager.readQuizes();
		
		Store store = new Store(vocabLessons, grammarLessons, quizzes);
		System.out.println("Guten Tag! I guess you want to learn some German today.");
	
		while (true){
			printAllOptions();
			String userAnswer = ConsoleManager.scanner.nextLine();
			
			// processing of chosen option
			if(userAnswer.trim().equalsIgnoreCase("1")) {
				ConsoleManager.chooseVocabularyLesson(store);
			}
			else if(userAnswer.trim().equalsIgnoreCase("2")) {
				ConsoleManager.chooseGrammarLesson(store);
			}
			else if(userAnswer.trim().equalsIgnoreCase("3")) {
				ConsoleManager.chooseQuiz(store);
			}
			else if(userAnswer.trim().equalsIgnoreCase("4")) {
				ConsoleManager.addVocabularyLesson(store);
				FileManager.writeVocabLessons(store.getVocabLessons());
			}
			else if(userAnswer.trim().equalsIgnoreCase("5")) {
				ConsoleManager.addGrammarLesson(store);
				FileManager.writeGrammarLessons(store.getGrammarLessons());
			}
			else if(userAnswer.trim().equalsIgnoreCase("6")) {
				ConsoleManager.addQuiz(store);
				FileManager.writeQuizes(store.getQuizzes());
			}
			else if(userAnswer.trim().equalsIgnoreCase("7")) {
				System.out.println("Tchüss!");
				break;
			}
			else {
				System.out.println("There is no such option :( Try again!");
			}
			
		}
		ConsoleManager.scanner.close();
		
	}

}
