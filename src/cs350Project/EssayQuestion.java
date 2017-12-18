package cs350Project;

import java.io.Serializable;

public class EssayQuestion extends Question implements Serializable{

	public EssayQuestion(){
		
		super();
	}
	
	public void build(IOHandler handler) {
		
		questionWording = handler.getStringInput("Please input the wording for this essay question: ");		
	}
	
	public void display(IOHandler handler) {
		
		handler.print(questionWording);
		handler.printNewLine();
	}
	
	public String answer(IOHandler handler) {
		
		display(handler);
		return handler.getStringInput("");
	}
	
	public boolean validateAnswer(String answer) {
		
		return true;
	}
	
	public boolean hasCorrectAnswer() {
		return false;
	}
	
}
