package cs350Project;

import java.util.ArrayList;

public class RankQuestion extends Question {
	
	public RankQuestion(String questionWording){
		
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
