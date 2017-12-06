package cs350Project;

import java.util.ArrayList;

public class ShortAnswerQuestion extends Question {

	private IOHandler handler;

	public ShortAnswerQuestion(String questionWording){
		
		this.questionWording = questionWording;
		
		handler = new IOHandler();
	}
	
	public String getWording() {
		
		return questionWording;
	}
	
	public ArrayList<String> getAnswers(){
		
		handler.print("A short answer does not has answer options. Something went wrong");
		
		return null;
	}
	
	public void addAnswer(String answer) {
		
		handler.print("You can't add answer options to an short answer question. Something went wrong");
	}
	
	public boolean hasAnswers() {
		
		return hasAnswers;
	}
	
}
