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
	
	public void answer(IOHandler handler) { //Not Finished
		
		display(handler);
		handler.getStringInput("Answer: ");
	}
	
}
