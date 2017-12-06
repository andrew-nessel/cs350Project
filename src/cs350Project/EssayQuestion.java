package cs350Project;

import java.util.ArrayList;

public class EssayQuestion extends Question {
	
	private IOHandler handler;

	public EssayQuestion(String questionWording){
		
		this.questionWording = questionWording;
		
		handler = new IOHandler();
	}
	
	public String getWording() {
		
		return questionWording;
	}
	
	public ArrayList<String> getAnswers(){
		
		handler.print("An essay does not has answer options. Something went wrong");
		
		return null;
	}
	
	public void addAnswer(String answer) {
		
		handler.print("You can't add answer options to an essay. Something went wrong");
	}
	
	public boolean hasAnswers() {
		
		return hasAnswers;
	}
	
	
}
