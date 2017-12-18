package cs350Project;

import java.io.Serializable;

public class RankQuestion extends Question implements Serializable{
	
	public RankQuestion(){
		
		super();
	}
	
	public void build(IOHandler handler) {
		
		questionWording = handler.getStringInput("Please input the wording for this ranking question: ");
		handler.printNewLine();
		
		boolean moreAnswers = true;
		while(moreAnswers) {
			
			answerOptions.add(handler.getStringInput("Please enter an answer: "));
			handler.printNewLine();
			
			boolean valid = false;
			while(!valid) {

				int more = handler.getIntInput("Would you like to add another answer to this question? \n 1: Yes \n 2: No");
				handler.printNewLine();
				if(more == 1) {
					moreAnswers = true;
					valid = true;
				}else if (more == 2) {
					moreAnswers = false;
					valid = true;
				}else {
					valid = false;
					handler.print("Please only answer either 1 or 2");
					handler.printNewLine();
				}
			}
		}
		
	}
	
	public void display(IOHandler handler) {
		
		handler.print(questionWording);
		handler.printNewLine();
		
		for(int x = 0; x < answerOptions.size(); x++) {
			handler.print(intToLetter(x) + ". " + answerOptions.get(x));
			handler.printNewLine();
		}
		
	}
	
	public String answer(IOHandler handler) {
		
		display(handler);
		String answer = "";
		int size = answerOptions.size();
		
		for(int x = 0; x<size; x++){
			
			boolean valid = false;
			while(!valid) {
				String tempanswer = answer + handler.getStringInput("Rank " + x+1);
				if(validateAnswer(answer)) {
					answer+=tempanswer + ",";
					valid = true;
				}else {
					handler.print("Answer not valid, please only input the letter (ex. a) . Please try again");
				}
			}			
		}
		
		answer = answer.substring(0,answer.length()-1); //cut off the last comma
		
		return answer;
	}
	
	public boolean hasCorrectAnswer() {
		return true;
	}
	
	public boolean validateAnswer(String answer) {
		
		String[] list = answer.split(",");
		int size = answerOptions.size();
			
		for(String input : list) {
			if((letterToInt(input)<0) || (letterToInt(input)>=size)) {
				return false;
			}
		}
		
		return true;
	}
	
}
