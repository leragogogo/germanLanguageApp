package lessons;

import java.io.Serializable;

public abstract class Lesson implements Serializable {
	private static final long serialVersionUID = 1L;
	protected String theme;
	
	public Lesson(String theme) {
		this.theme = theme;
	}
	
	public String getTheme() {
		return this.theme;
	}
	
	public void displayTheme() {
		System.out.println("Theme of the lesson: " + theme);
	}
	
	// simulation of thinking time for user.
	public abstract void delay();
}
