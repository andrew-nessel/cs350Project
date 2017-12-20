package cs350Project;

import java.io.Serializable;

public class ShortAnswerQuestion extends Question implements Serializable{

	public ShortAnswerQuestion(){
		
		super();
	}
	
	public void build(IOHandler handler) {
		
		questionWording = handler.getStringInput("Please input the wording for this short answer question: ");		
	}
	
	public void display(IOHandler handler) {
		
		handler.print(questionWording);
		handler.printNewLine();
	}
	
	public String answer(IOHandler handler) {
		
		display(handler);
		return handler.getStringInput("");
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
		
		return true;
	}
	
	public boolean hasCorrectAnswer() {
		return true;
	}
	
}
