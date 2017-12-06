package cs350Project;

import java.util.ArrayList;

public class TrueFalseQuestion extends Question {

	private IOHandler handler;

	public TrueFalseQuestion(String questionWording){
		
		this.questionWording = questionWording;
		this.answerOptions.add("False");
		this.answerOptions.add("True");
		
		handler = new IOHandler();
	}
	
	public String getWording() {
		
		return questionWording;
	}
	
	public ArrayList<String> getAnswers(){
		
		return answerOptions;
	}
	
	public void addAnswer(String answer) {
		
		handler.print("You can't add answer options to an true-false question. Something went wrong");
	}
	
	public boolean hasAnswers() {
		
		return hasAnswers;
	}
	
}
