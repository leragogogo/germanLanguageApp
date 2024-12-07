package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import lessons.GrammarLesson;
import lessons.VocabularyLesson;
import quizzes.Quiz;

// this class contains all methods connected to file input/output
public class FileManager {
	static public void writeQuizes(List<Quiz> quizzes) {
		File file = new File("resourses/quizzes.ser");
		try {
            if (file.getParentFile() != null) {
                file.getParentFile().mkdirs();
            }
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
                oos.writeObject(quizzes);
            }
        } catch (IOException e) {
        	System.out.println("Couldn't write the quizzes to a file");
        }
	}
	
	static public List<Quiz> readQuizes(){
		List<Quiz> restoredList = new ArrayList<>();
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("resourses/quizzes.ser"))) {
            restoredList = (List<Quiz>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
        }
		return restoredList;
	}
	
	static public void writeVocabLessons(List<VocabularyLesson> vocabLessons) {
		File file = new File("resourses/vocabLessons.ser");
		try {
            if (file.getParentFile() != null) {
                file.getParentFile().mkdirs();
            }
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
                oos.writeObject(vocabLessons);
            }
        } catch (IOException e) {
        	System.out.println("Couldn't write the vocabulary lesseons to a file");
        }
	}
	
	static public List<VocabularyLesson> readVocabLessons(){
		List<VocabularyLesson> restoredList = new ArrayList<>();
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("resourses/vocabLessons.ser"))) {
            restoredList = (List<VocabularyLesson>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
        }
		return restoredList;
	}
	
	static public void writeGrammarLessons(List<GrammarLesson> grammarLessons) {
		File file = new File("resourses/grammarLessons.ser");
		try {
            if (file.getParentFile() != null) {
                file.getParentFile().mkdirs();
            }
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
                oos.writeObject(grammarLessons);
            }
        } catch (IOException e) {
        	System.out.println("Couldn't write the grammar lessons to a file");
        }
	}
	
	static public List<GrammarLesson> readGrammarLessons(){
		List<GrammarLesson> restoredList = new ArrayList<>();
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("resourses/grammarLessons.ser"))) {
            restoredList = (List<GrammarLesson>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
        }
		return restoredList;
	}
}
