package cs350Project;

import java.io.Serializable;
import java.util.ArrayList;

public class MatchQuestion extends Question implements Serializable{ 

	private ArrayList<String> answerOptionsColumn2;
	
	public MatchQuestion() {
		super();
		answerOptionsColumn2 = new ArrayList<String>();
	}
	
	public void build(IOHandler handler) { 
		
		questionWording = handler.getStringInput("Please input the wording for this matching question");	
		handler.printNewLine();
		
		boolean moreAnswers = true;
		while(moreAnswers) {
			
			answerOptions.add(handler.getStringInput("Please enter an answer in the first column"));
			handler.printNewLine();
			
			boolean valid = false;
			while(!valid) {

				int more = handler.getIntInput("Would you like to add another answer to the first column of this question? \n 1. Yes \n 2. No");
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
			
			answerOptionsColumn2.add(handler.getStringInput("Please enter an answer in the second column"));
			handler.printNewLine();
			
			boolean valid = false;
			while(!valid) {

				int more = handler.getIntInput("Would you like to add another answer to the second column of this question? \n 1. Yes \n 2. No ");
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
		int c1size = answerOptions.size();
		
		for(int x = 0; x < answerOptions.size(); x++) {
			handler.print(intToLetter(x) + ". " + answerOptions.get(x) + "     " + intToLetter(x+c1size) + ". " + answerOptionsColumn2.get(x));
			handler.printNewLine();
		}
	}
	
	public String answer(IOHandler handler) {
		
		display(handler);
		String answer = "";
		int c1size = answerOptions.size();		
		
		for(int x = 0; x<c1size; x++) {

			boolean valid = false;
			while(!valid) {
				String tempanswer1 = intToLetter(x);
				String tempanswer2 = handler.getStringInput(tempanswer1 + " matches with").toUpperCase();
				answer+=tempanswer1 + "-" + tempanswer2 + ",";
				
				if(validateAnswer(answer)) {
					valid = true;
				}else {
					handler.print("Answer not valid, please only input the letter (ex. a) . Please try again");
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
					}else if((choice>=answerOptions.size()) || (choice<answerOptionsColumn2.size())){
						answerOptionsColumn2.set(answerOptionsColumn2.size()-choice, handler.getStringInput("Please enter the replacement choice"));
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

	public boolean hasCorrectAnswer() {
		return true;
	}
	
	public boolean validateAnswer(String answer) {
		
		String[] list = answer.split(",");
		int c1size = answerOptions.size();
		int c2size = answerOptionsColumn2.size();
			
		for(String input : list) {
			String[] column = input.split("-");
			
			if(column.length != 2) {
				return false;
			}
			
			if((letterToInt(column[0])<0) || (letterToInt(column[0])>=c1size)) {
				return false;
			}
			
			if((letterToInt(column[1])<c1size) || (letterToInt(column[1])>=c2size+c1size)) {
				return false;
			}
		}
		
		return true;
	}
	
}
