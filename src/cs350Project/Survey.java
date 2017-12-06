package cs350Project;

import java.util.ArrayList;

public abstract class Survey {
	
	private ArrayList<Question> questions;
	private String surveyName;
	
	public Survey(String name) {
		surveyName = name;
	}
	
	public void addQuestion(Question question) {
		questions.add(question);
	}
	
	public String getName() {
		return surveyName;
	}
	
	public Question getQuestion(int index) {
		return questions.get(index);
	}

}
