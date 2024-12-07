package main;

import java.util.List;

import lessons.VocabularyLesson;
import lessons.GrammarLesson;

import quizzes.Quiz;

// a class to store all activities(vocabulary and grammar lessons, quizzes)
public class Store {
	private List<VocabularyLesson> vocabLessons;
	private List<GrammarLesson> grammarLessons;
	private List<Quiz> quizzes;
	
	public Store(List<VocabularyLesson> vocabLessons, List<GrammarLesson> grammarLessons, List<Quiz> quizzes) {
		this.vocabLessons = vocabLessons;
		this.grammarLessons = grammarLessons;
		this.quizzes = quizzes;
	}
	
	public void addVocabLesson(VocabularyLesson vocabLesson) {
		this.vocabLessons.add(vocabLesson);
	}
	
	public void addGrammarLesson(GrammarLesson grammarLesson) {
		this.grammarLessons.add(grammarLesson);
	}
	
	public void addQuiz(Quiz quiz) {
		this.quizzes.add(quiz);
	}
	
	public List<VocabularyLesson> getVocabLessons() {
		return vocabLessons;
	}
	
	public List<GrammarLesson> getGrammarLessons() {
		return grammarLessons;
	}
	public List<Quiz> getQuizzes() {
		return quizzes;
	}
}
