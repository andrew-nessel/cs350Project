package cs350Project;

public class MultipleChoiceQuestion extends Question {
	
	public MultipleChoiceQuestion(){
		
		super();
	}
	
	public void build(IOHandler handler) {
		
		questionWording = handler.getStringInput("Please input the wording for this multiple choice question: ");
		handler.printNewLine();
		
		boolean moreAnswers = true;
		while(moreAnswers) {
			
			answerOptions.add(handler.getStringInput("Please enter an answer: "));
			handler.printNewLine();
			
			boolean valid = false;
			while(!valid) {

				int more = handler.getIntInput("Would you like to add another answer to this question? \n 1: Yes \n 2: No ");
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
			handler.print(intToLetter(x+1) + ". " + answerOptions.get(x));
			handler.printNewLine();
		}
		
	}
	
	public String answer(IOHandler handler) {
		
		display(handler);
		String answer = "";
		boolean multi = true;
		
		while(multi) {
			
			boolean valid = false;
			while(!valid) {
				String tempanswer = handler.getStringInput("");
				if(validateAnswer(answer)) {
					answer+=tempanswer + ",";
					valid = true;
				}else {
					handler.print("Answer not valid, please only input the letter (ex. a) . Please try again");
				}
			}
			
			valid = false;
			while(!valid) {

				int more = handler.getIntInput("Would you like to add another answer to this question? \n 1: Yes \n 2: No ");
				handler.printNewLine();
				if(more == 1) {
					multi = true;
					valid = true;
				}else if (more == 2) {
					multi = false;
					valid = true;
				}else {
					valid = false;
					handler.print("Please only answer either 1 or 2");
					handler.printNewLine();
				}
			}
			
		}
		
		answer = answer.substring(0,answer.length()-1); //cut off the last comma
		
		return answer;
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
	
	public boolean hasCorrectAnswer() {
		return true;
	}
	
}
