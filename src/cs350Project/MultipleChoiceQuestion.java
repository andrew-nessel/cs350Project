package cs350Project;

import java.util.ArrayList;

public class MultipleChoiceQuestion extends Question {

	
	public MultipleChoiceQuestion(String questionWording){
		
		this.questionWording = questionWording;
	}
	
	public String getWording() {
		
		return questionWording;
	}
	
	public ArrayList<String> getAnswers(){
		
		return answerOptions;
	}
	
	public void addAnswer(String answer) {
		
		answerOptions.add(answer);
	}
	
	public boolean hasAnswers() {
		
		return hasAnswers;
	}
	
}
