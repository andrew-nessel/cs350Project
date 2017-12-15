package cs350Project;

import java.util.ArrayList;

public class TestSurvey extends Survey{
	
	protected ArrayList<String> answerKey;

	public TestSurvey(String name) {
		super(name);
		surveyResults = new TestSurveyResults();
		answerKey = new ArrayList<String>();
	}
	
	public void build(IOHandler handler) {
		
		boolean valid = false;
		
		while(!valid) {

			int more = handler.getIntInput("Would you like to add a question? \n1: Yes \n2: No ");
			handler.printNewLine();
			switch(more) {
			
				case 1:
					Question q = makeQuestion(handler);
					addQuestion(q);
					if(q.hasCorrectAnswer()) {
						handler.print("Please now answer this question with the correct answer");
						handler.printNewLine();
						answerKey.add(q.answer(handler));
					}else {
						answerKey.add("");
					}
					handler.printNewLine();
					valid = false;
					break;
					
				case 2:
					valid = true;
					break;
					
				default:
					handler.print("Invalid answer. Please try again");
					handler.printNewLine();
					valid = false;
					break;
			}
		}
	}
	
	
	public Question makeQuestion(IOHandler handler) {
		
		Question question = null;
		boolean valid = false;
		
		while(!valid) {
		
			int choice = handler.getIntInput("1. Add True/False\n"
					+ "2. Add Multiple Choice\n"
					+ "3. Add Short Answer\n"
					+ "4. Add Essay\n"
					+ "5. Add Ranking\n"
					+ "6. Add Matching");
			
			handler.printNewLine();
		
			switch(choice) {
		
				case 1:
					question = new TrueFalseQuestion();
					question.build(handler);
					valid = true;
					break;
			
				case 2:
					question = new MultipleChoiceQuestion();
					question.build(handler);
					valid = true;
					break;
		
				case 3:
					question = new ShortAnswerQuestion();
					question.build(handler);
					valid = true;
					break;
				
				case 4:
					question = new EssayQuestion();
					question.build(handler);
					valid = true;
					break;
			
				case 5:
					question = new RankQuestion();
					question.build(handler);
					valid = false;
					break;
			
				case 6:
					question = new MatchQuestion();
					question.build(handler);
					valid = true;
					break;
				
				default:
					handler.print("Invalid answer. Please try again");
					handler.printNewLine();
					valid = false;
					break;
			}
		}
		
		return question;
	}
	
	public void display(IOHandler handler) {
		
		handler.print("Test: " + surveyName);
		handler.printNewLines(2);
		
		for(int x = 0; x < questions.size(); x++) {
			Question question = questions.get(x);
			handler.print(x+". ");
			question.display(handler);
			if(question.hasCorrectAnswer()) {
				handler.print("Correct answer is " + answerKey.get(x));				
			}
			handler.printNewLine();
		}
	}
	
}
