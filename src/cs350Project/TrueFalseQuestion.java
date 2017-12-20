package cs350Project;

import java.io.Serializable;

public class TrueFalseQuestion extends Question implements Serializable{

	public TrueFalseQuestion() {
		super();
	}
	
	public void build(IOHandler handler) {
		
		questionWording = handler.getStringInput("Please input the wording for this true/false question: ");
		answerOptions.add("True");
		answerOptions.add("False");
	}
	
	public void display(IOHandler handler) {
		
		handler.print(questionWording);
		handler.printNewLine();
		
		for(int x = 0; x < answerOptions.size(); x++) {
			handler.print(answerOptions.get(x).substring(0,1) + ": " + answerOptions.get(x));
			handler.printNewLine();
		}
		
	}
	
	public String answer(IOHandler handler) {
		
		display(handler);
		String answer = "";
		boolean valid = false;
		
		while(!valid) {
			answer = handler.getStringInput("");
			if(validateAnswer(answer)) {
				valid = true;
			}else {
				handler.printNewLine();
				handler.print("Answer not valid, please only input 't' or 'f'. Please try again");
			}
		}
		
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
				valid = true;
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
		
		if(answer.toLowerCase().equals("t") || answer.toLowerCase().equals("f")) {
			return true;
		}
		
		return false;
	}
	
	public boolean hasCorrectAnswer() {
		return true;
	}
	
}
