package cs350Project;

import java.util.ArrayList;

public class MatchQuestion extends Question { //NOT FINISHED

	private ArrayList<String> answerOptionsColumn2;
	
	public MatchQuestion() {
		super();
		answerOptionsColumn2 = new ArrayList<String>();
	}
	
	public void build(IOHandler handler) { //Not Finished
		
		questionWording = handler.getStringInput("Please input the wording for this matching question: ");	
		
		boolean moreAnswers = true;
		while(moreAnswers) {
			
			answerOptions.add(handler.getStringInput("Please enter an answer in the first column: "));
			handler.printNewLine();
			
			boolean valid = true;
			while(!valid) {

				int more = handler.getIntInput("Would you like to add another answer to the first column of this question? \n 1: Yes \n 2: No \n : ");
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
		
		moreAnswers = true;
		while(moreAnswers) {
			
			answerOptionsColumn2.add(handler.getStringInput("Please enter an answer in the second column: "));
			handler.printNewLine();
			
			boolean valid = true;
			while(!valid) {

				int more = handler.getIntInput("Would you like to add another answer to the second column of this question? \n 1: Yes \n 2: No \n : ");
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
			handler.print(x+1 + ": " + answerOptions.get(x) + "\t" + answerOptionsColumn2.get(x));
			handler.printNewLine();
		}
	}
	
	public void answer(IOHandler handler) { //Not Finished
		
	}
	
}
