package cs350Project;

public class Driver {
	
	public static final IOHandler handle = new IOHandler();
	public static Survey survey = null;

	public static void main(String[] args) {
		
		boolean running = true;
		
		while(running) {
			
			int choice = handle.getIntInput("1. Survey\n"
					+ "2. Test\n"
					+ "3. Exit");
			
			switch(choice) {
			
				case 1:
					handle.printNewLine();
					makeSurvey();
					break;
				
				case 2:
					handle.printNewLine();
					makeTest();
					break;
			
				case 3:
					running = false;
					break;
			}
		}
		
		handle.close();

	}
	
	public static void makeSurvey() {
		
		boolean valid = false;
		
		while(!valid) {
			
			String surveyName = "n/a";
			if(survey != null) {
				surveyName = survey.getName();
			}
		
			int choice = handle.getIntInput("Current survey: " + surveyName + "\n" 
					+ "1. Create a survey\n"
					+ "2. Display a survey\n"
					+ "3. Load a survey\n"
					+ "4. Save a survey\n"
					+ "5. Go back");
			
			handle.printNewLine();
		
			switch(choice) {
		
				case 1:
					survey = new Survey(handle.getStringInput("Please name this new survey"));
					handle.printNewLine();
					survey.build(handle);
					break;
		
				case 2:
					if(survey == null) {
						handle.print("You haven't loaded or created a survey to be displayed");
						handle.printNewLine();
					}else {
						survey.display(handle);
					}
					break;
		
				case 3:
					//this is loading a survey
					break;
				
				case 4:
					//this is saving the survey
					break;
			
				case 5:
					valid = true;
					break;
				
				default:
					handle.print("Invalid answer. Please try again");
					handle.printNewLine();
					break;
			}
			
			handle.printNewLine();
		}
	}
	
	public static void makeTest() {
		
		boolean valid = false;
		
		while(!valid) {
			
			String surveyName = "n/a";
			if(survey != null) {
				surveyName = survey.getName();
			}
			
			int choice = handle.getIntInput("Current test: " + surveyName + "\n"
					+ "1. Create a test\n"
					+ "2. Display a test\n"
					+ "3. Load a test\n"
					+ "4. Save a test\n"
					+ "5. Go back");
			
			handle.printNewLine();
		
			switch(choice) {
		
				case 1:
					survey = new TestSurvey(handle.getStringInput("Please name this new test"));
					handle.printNewLine();
					survey.build(handle);
					break;
			
				case 2:
					if(survey == null) {
						handle.print("You haven't loaded or created a test to be displayed");
						handle.printNewLine();
					}else {
						survey.display(handle);
					}
					break;
		
				case 3:
					//this is loading a test
					break;
				
				case 4:
					//this is saving the test
					break;
			
				case 5:
					valid = true;
					break;
				
				default:
					handle.print("Invalid answer. Please try again");
					handle.printNewLine();
					break;
			}
			handle.printNewLine();
		}
		
		handle.printNewLine();
	}

}
