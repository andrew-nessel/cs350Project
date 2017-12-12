package cs350Project;

public class TrueFalseQuestion extends Question {

	public TrueFalseQuestion(String questionWording){
		
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
			handler.print(x+1 + ": " + answerOptions.get(x));
			handler.printNewLine();
		}
		
	}
	
	public void answer(IOHandler handler) { //Not Finished
		
	}
	
}
