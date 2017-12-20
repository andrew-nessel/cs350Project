package cs350Project;

import java.io.Serializable;
import java.util.ArrayList;

public class TestSurvey extends Survey implements Serializable{//A test holds its name, its questions and its results
																//it has each question handle the specifics of each question and 
																//the test just handles the overarching work of housing all the questions together
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
			switch(more) {
			
				case 1:
					handler.printNewLine();
					Question q = makeQuestion(handler);
					addQuestion(q);
					if(q.hasCorrectAnswer()) {
						handler.printNewLine();
						handler.print("Please now answer this question with the correct answer");
						answerKey.add(q.answer(handler));
					}else {
						answerKey.add("");
					}
					handler.printNewLine();
					valid = false;
					break;
					
				case 2:
					handler.printNewLine();
					valid = true;
					break;
					
				default:
					handler.printNewLine();
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
					valid = true;
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
			handler.print((x+1) + ". ");
			question.display(handler);
			if(question.hasCorrectAnswer()) {
				handler.print("Correct answer is " + answerKey.get(x));				
			}
			handler.printNewLines(2);
		}
	}
	
	public void modify(IOHandler handler) {

		display(handler);
		
		boolean valid = false;
		
		while(!valid) {

			int more = handler.getIntInput("Would you like to modify a question? \n1: Yes \n2: No ");
			switch(more) {
			
				case 1:
					handler.printNewLine();
					boolean correctInput = false;
					while(!correctInput) {
						int q = handler.getIntInput("Which question would you like to modify?");
						if((q>=0) || (q<questions.size())) {
							Question question = questions.get(q);
							question.modify(handler);
							if(question.hasCorrectAnswer()) {
								boolean notCorrectAnswer = false;
								while(!notCorrectAnswer) {
									int change = handler.getIntInput("Would you like to modify the answer to this question? \n1: Yes \n2: No ");
									switch(change) {
									
										case 1:
											handler.printNewLine();
											handler.print("Please now answer this question with the correct answer");
											answerKey.add(question.answer(handler));
											handler.printNewLine();
											notCorrectAnswer = false;
											break;
											
										case 2:
											notCorrectAnswer = true;
											handler.printNewLine();
											break;
											
										default:
											handler.printNewLine();
											handler.print("Invalid answer. Please try again");
											handler.printNewLine();
											notCorrectAnswer = false;
											break;
									}
								}
							}
						}else {
							handler.print("Invalid input, please try again");
							handler.printNewLine();
							correctInput = false;
						}
					}
					handler.printNewLine();
					valid = false;
					break;
					
				case 2:
					valid = true;
					handler.printNewLine();
					break;
					
				default:
					handler.printNewLine();
					handler.print("Invalid answer. Please try again");
					handler.printNewLine();
					valid = false;
					break;
			}
		}
	}
	
}
