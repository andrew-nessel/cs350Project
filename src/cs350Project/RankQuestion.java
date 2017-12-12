package cs350Project;

public class RankQuestion extends Question {
	
	public RankQuestion(String questionWording){
		
		super();
	}
	
	public void build(IOHandler handler) {
		
		questionWording = handler.getStringInput("Please input the wording for this ranking question: ");
		
		boolean moreAnswers = true;
		while(moreAnswers) {
			
			answerOptions.add(handler.getStringInput("Please enter an answer: "));
			handler.printNewLine();
			
			boolean valid = true;
			while(!valid) {

				int more = handler.getIntInput("Would you like to add another answer to this question? \n 1: Yes \n 2: No \n : ");
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
			handler.print(x+1 + ": " + answerOptions.get(x));
			handler.printNewLine();
		}
		
	}
	
	public void answer(IOHandler handler) { //Not Finished
		
	}
	
}
