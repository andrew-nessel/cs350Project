package cs350Project;

public class EssayQuestion extends Question {
	
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
