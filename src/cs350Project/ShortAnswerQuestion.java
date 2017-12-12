package cs350Project;

public class ShortAnswerQuestion extends Question {

	public ShortAnswerQuestion(String questionWording){
		
		super();
	}
	
	public void build(IOHandler handler) {
		
		questionWording = handler.getStringInput("Please input the wording for this short answer question: ");		
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
