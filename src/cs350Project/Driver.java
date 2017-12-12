package cs350Project;

public class Driver {
	
	public static final IOHandler handle = new IOHandler();

	public static void main(String[] args) {
		
		boolean running = true;
		
		while(running) {
			
			int choice = handle.getIntInput("1. Make a survey\n"
					+ "2. Make a test\n"
					+ "3. Exit\n:");
			
			switch(choice) {
			
				case 1:
					makeSurvey();
					break;
				
				case 2:
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
		int choice = handle.getIntInput("1. Create a survey\n"
				+ "2. Display a survey\n"
				+ "3. Load a survey\n"
				+ "4. Save a survey\n"
				+ "5. Go back");
		
		switch(choice) {
		
			case 1:
				//this is making a new survey
				break;
			
			case 2:
				//this is display the survey
				break;
		
			case 3:
				//this is loading a survey
				break;
				
			case 4:
				//this is saving the survey
				break;
			
			case 5:
				return;
		}
	}
	
	public static void makeTest() {
		int choice = handle.getIntInput("1. Create a test\n"
				+ "2. Display a test\n"
				+ "3. Load a test\n"
				+ "4. Save a test\n"
				+ "5. Go back");
		
		switch(choice) {
		
			case 1:
				//this is making a new test
				break;
			
			case 2:
				//this is display the test
				break;
		
			case 3:
				//this is loading a test
				break;
				
			case 4:
				//this is saving the test
				break;
			
			case 5:
				return;
		}
	}

}
