package cs350Project;

import java.io.Serializable;

public class MultipleChoiceQuestion extends Question implements Serializable{
	
	public MultipleChoiceQuestion(){
		
		super();
	}
	
	public void build(IOHandler handler) {
		
		questionWording = handler.getStringInput("Please input the wording for this multiple choice question");
		handler.printNewLine();
		
		boolean moreAnswers = true;
		while(moreAnswers) {
			
			answerOptions.add(handler.getStringInput("Please enter an answer"));
			handler.printNewLine();
			
			boolean valid = false;
			while(!valid) {
				
				int more = handler.getIntInput("Would you like to add another answer to this question? \n 1. Yes \n 2. No ");
				if(more == 1) {
					moreAnswers = true;
					valid = true;
					handler.printNewLine();
				}else if (more == 2) {
					moreAnswers = false;
					valid = true;
				}else {
					valid = false;
					handler.printNewLine();
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
		boolean multi = true;
		handler.printNewLine();
		
		while(multi) {
			
			boolean valid = false;
			while(!valid) {
				String tempanswer = answer + handler.getStringInput("").toUpperCase();
				handler.printNewLine();
				if(validateAnswer(tempanswer)) {
					answer=tempanswer + ",";
					valid = true;
				}else {
					handler.print("Answer not valid, please only input the letter (ex. a) . Please try again");
				}
			}
			
			valid = false;
			while(!valid) {

				int more = handler.getIntInput("Would you like to add another answer to this question? \n 1. Yes \n 2. No ");
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
	
	public void modify(IOHandler handler) {
		
		display(handler);
		
		boolean valid = false;
		
		while(!valid) {
			int modify = handler.getIntInput("Would you like to modify the question wording? \n1. Yes\n2. No");
			handler.printNewLine();
			
			switch (modify) {
			case 1:
				questionWording = handler.getStringInput("Please input the new wording for this question: ");	
				break;
			case 2:
				valid = true;
				break;
			default:
				valid = false;
				handler.print("Invalid input, please try again");
				handler.printNewLine();
				break;
					
			}
		}
		
		valid = false;
		
		while(!valid) {
			int modify = handler.getIntInput("Would you like to modify one of the choices? \n1. Yes\n2. No");
			handler.printNewLine();
			
			switch (modify) {
			case 1:
				boolean correctChoice = false;
				while(!correctChoice) {
					display(handler);
					String answer = handler.getStringInput("Enter the choice you want to modify");
					int choice = letterToInt(answer);
					
					if((choice>=0) || (choice<answerOptions.size())) {
						answerOptions.set(choice, handler.getStringInput("Please enter the replacement choice"));
						handler.printNewLine();
						correctChoice = true;
					}else {
						handler.print("That choice is invalid, please try again");
						handler.printNewLine();
						correctChoice =false;
					}
				}
				valid = false;
				break;
			case 2:
				valid = true;
				break;
			default:
				valid = false;
				handler.print("Invalid input, please try again");
				handler.printNewLine();
				break;
					
			}
		}
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
