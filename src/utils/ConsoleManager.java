package utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import lessons.GrammarLesson;
import lessons.VocabularyLesson;
import main.Store;
import models.FlashCard;
import models.GrammarRule;
import quizzes.MultipleChoiceQuestion;
import quizzes.Question;
import quizzes.Quiz;

// this class contains all method connecting to console
public class ConsoleManager {
	public static Scanner scanner = new Scanner(System.in);
	
	public static void addVocabularyLesson(Store store) {
		System.out.println();
		// user inputs a theme of the lesson
		System.out.println("What theme of a vocabulary lesson?");
		String theme = scanner.nextLine();
		
		// user inputs a number of words for a lesson
		int number;
		while(true) {
			System.out.println("How many words do you want to add to the lesson?");
			String input = scanner.nextLine();
			try {
		        number = Integer.parseInt(input);
		        break;
		    } catch (NumberFormatException e) {
		    	System.out.println("Your input was't a number :( Try again!");
		    	continue;
		    }
		}
		
		// user inputs English and German names of a word.
		List<FlashCard> flashCards = new ArrayList<>();
		for(var i = 1; i <= number; i++) {
			System.out.println("Input English word");
			String english = scanner.nextLine();
			System.out.println("Input German word");
			String german = scanner.nextLine();
			flashCards.add(new FlashCard(english,german));
		}
		
		store.addVocabLesson(new VocabularyLesson(theme,flashCards));
		System.out.println("Vocabulary lesson was added!");
		System.out.println();
	}
	
	public static void addGrammarLesson(Store store) {
		System.out.println();
		// user inputs a theme of the lesson
		System.out.println("What thema of a grammar lesson?");
		String thema = scanner.nextLine();
		
		// user inputs a number of grammar rules for a lesson
		int number;
		while(true) {
			System.out.println("How many rules do you want to add to the lesson?");
			String input = scanner.nextLine();
			try {
		        number = Integer.parseInt(input);
		        break;
		    } catch (NumberFormatException e) {
		    	System.out.println("Your input was't a number :( Try again!");
		    	continue;
		    }
		}
		
		// user inputs a name, an explanation and examples of usage 
		List<GrammarRule> grammarRules = new ArrayList<>();
		for(var i = 1; i <= number; i++) {
			System.out.println("Input the name of the rule");
			String name = scanner.nextLine();
			System.out.println("Input the explanation of the rule");
			String explanation = scanner.nextLine();
			int numberOfExamples;
			while(true) {
				System.out.println("How many examples do you want to add?");
				String input = scanner.nextLine();
				try {
					numberOfExamples = Integer.parseInt(input);
			        break;
			    } catch (NumberFormatException e) {
			    	System.out.println("Your input was't a number :( Try again!");
			    	continue;
			    }
			}
			List<String> examples = new ArrayList<>();
			for(var j = 0; j < numberOfExamples; j++) {
				System.out.println("Input an example");
				String example = scanner.nextLine();
				examples.add(example);
			}
			grammarRules.add(new GrammarRule(name,explanation,examples));
			
		}
		
		store.addGrammarLesson(new GrammarLesson(thema,grammarRules));
		System.out.println("Grammar lesson was added!");
		System.out.println();
	}
	
	public static void addQuiz(Store store) {
		System.out.println();
		// user inputs a name of the quiz
		System.out.println("What the name of a quiz?");
		String name = scanner.nextLine();
		
		// user inputs a number of questions for a quiz
		int number;
		while(true) {
			System.out.println("How many questions do you want to add to the quiz?");
			String input = scanner.nextLine();
			try {
		        number = Integer.parseInt(input);
		        break;
		    } catch (NumberFormatException e) {
		    	System.out.println("Your input was't a number :( Try again!");
		    	continue;
		    }
		}
		
		// user inputs questions
		List<Question> questions = new ArrayList<>();
		for(var i = 0; i < number; i++) {
			while(true) {
				// user chooses a type of a question
				System.out.println("Is it multiple-choice question?");
				System.out.println("Input y or n");
				String answer = scanner.nextLine();
				if(answer.trim().equalsIgnoreCase("n")) {
					// one-choice question
					System.out.println("Input question text");
					String questionText = scanner.nextLine();
					System.out.println("Input correct answer");
					String correctAnswer = scanner.nextLine();
					questions.add(new Question(questionText, correctAnswer));
					break;
				}
				else if(answer.trim().equalsIgnoreCase("y")) {
					// multiple-choice question
					System.out.println("Input question text");
					String questionText = scanner.nextLine();
					int optionsNumber;
					while(true) {
						System.out.println("How many options should question have?");
						String input = scanner.nextLine();
						try {
							optionsNumber = Integer.parseInt(input);
					        break;
					    } catch (NumberFormatException e) {
					    	System.out.println("Your input was't a number :( Try again!");
					    	continue;
					    }
					}
					
					// user inputs options of answer.
					List<String> options = new ArrayList<>();
					for(var j = 0; j < optionsNumber;j++) {
						System.out.println("Input option");
						String option = scanner.nextLine();
						options.add(option);
					}
					
					// user inputs number of correct answer
					int correctAnswerIndex;
					while(true) {
						System.out.println("Input number of correct answer");
						String option = scanner.nextLine();
						try {
							correctAnswerIndex = Integer.parseInt(option);
					        
					    } catch (NumberFormatException e) {
					    	System.out.println("Your input wasn't a number :( Try again!");
					    	continue;
					    }
						if((correctAnswerIndex > 1) && (correctAnswerIndex <= optionsNumber)) {
							break;
						}
						else {
							System.out.println("Your input isn't a valid choice :( Try again!");
					    	continue;
						}
					}
					questions.add(new MultipleChoiceQuestion(
							questionText,
							options, 
							(correctAnswerIndex - 1))
						);
					break;
				}
				else {
					System.out.println("Your input was't a y or n :( Try again!");
			    	continue;
				}
			}
			
		}
		store.addQuiz(new Quiz(name,questions));
		System.out.println("Quiz was added!");
		System.out.println();
		
	}
	
	public static void chooseVocabularyLesson(Store store) {
		System.out.println();
		if(store.getVocabLessons().size() == 0) {
			System.out.println("Oops.. It seems that you didn't add any vocabulary lessons");
			System.out.println("Let's do it!");
			System.out.println();
		}
		else {
			// user chooses a vocabulary lesson to do
			while(true) {
				System.out.println("What vocabulary lesson do you want to do?");
				for(var i = 0; i < store.getVocabLessons().size();i++) {
					System.out.println((i+1) +") " + store.getVocabLessons().get(i).getTheme());
				}
				System.out.print("Enter the number of your choice: ");
				String vocab = scanner.nextLine();
				int chosenIndex;
				try {
			        chosenIndex = Integer.parseInt(vocab) - 1;
			    } catch (NumberFormatException e) {
			    	System.out.println("There is no such option :( Try again!");
			    	continue;
			    }
				store.getVocabLessons().get(chosenIndex).start();
				store.getVocabLessons().get(chosenIndex).end();
				break;
			}
		}
	}
	
	public static void chooseGrammarLesson(Store store) {
		System.out.println();
		if(store.getGrammarLessons().size() == 0) {
			System.out.println("Oops.. It seems that you didn't add any grammar lessons");
			System.out.println("Let's do it!");
			System.out.println();
		}
		else {
			// user chooses a grammar lesson to do
			while(true) {
				System.out.println("What grammar lesson do you want to do?");
				for(var i = 0; i < store.getGrammarLessons().size();i++) {
					System.out.println((i+1) +") " + store.getGrammarLessons().get(i).getTheme());
				}
				System.out.print("Enter the number of your choice: ");
				String vocab = scanner.nextLine();
				int chosenIndex;
				try {
			        chosenIndex = Integer.parseInt(vocab) - 1;
			    } catch (NumberFormatException e) {
			    	System.out.println("There is no such option :( Try again!");
			    	continue;
			    }
				store.getGrammarLessons().get(chosenIndex).start();
				store.getGrammarLessons().get(chosenIndex).end();
				break;
			}
		}
	}
	
	public static void chooseQuiz(Store store) {
		System.out.println();
		if(store.getQuizzes().size() == 0) {
			System.out.println("Oops.. It seems that you didn't add any quizzes");
			System.out.println("Let's do it!");
			System.out.println();
		}
		else {
			// user chooses a quiz to do
			while(true) {
				System.out.println("What quiz do you want to do?");
				for(var i = 0; i < store.getQuizzes().size();i++) {
					System.out.println((i+1) +") " + store.getQuizzes().get(i).getName());
				}
				System.out.print("Enter the number of your choice: ");
				String vocab = scanner.nextLine();
				int chosenIndex;
				try {
			        chosenIndex = Integer.parseInt(vocab) - 1;
			    } catch (NumberFormatException e) {
			    	System.out.println("There is no such option :( Try again!");
			    	continue;
			    }
				store.getQuizzes().get(chosenIndex).start();
				store.getQuizzes().get(chosenIndex).end();
				break;
			}
		}
	}
}
