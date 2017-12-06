package cs350Project;

import java.util.ArrayList;

public class MatchQuestion extends Question { //NOT FINISHED

	private ArrayList<String> answerOptionsColumn2;
	//private IOHandler handler;
	
	public MatchQuestion() {
			
		this.questionWording = questionWording;
			
		//handler = new IOHandler();
	}
	
	public String getWording() {
		
		return questionWording;
	}
	
	public ArrayList<String> getAnswers(){
		
		return answerOptions;
	}
	
	public void addAnswer(String answer) {
		
	}
	
	public boolean hasAnswers() {
		
		return hasAnswers;
	}
	
}
