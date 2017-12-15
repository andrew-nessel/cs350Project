package cs350Project;

public class TrueFalseQuestion extends Question {

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
			handler.print(x+1 + ": " + answerOptions.get(x));
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
