package cs350Project;

public class Driver {

	public static void main(String[] args) {
		
		IOHandler handle = new IOHandler();
		//handle.print(new Integer(handle.getIntInput("gimme")).toString());
		
		boolean running = true;
		
		while(running) {
			
			int choice = handle.getIntInput("1. Make a survey\n"
					+ "2. Exit");
			
			switch(choice) {
			
			case 1:
				makeSurvey();
				break;
				
			case 2:
				running = false;
				break;
			
			}
			
		}

	}
	
	public static void makeSurvey() {
		
	}

}
