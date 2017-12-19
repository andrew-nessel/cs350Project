package cs350Project;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Driver {
	
	public static final IOHandler handle = new IOHandler();
	public static Survey survey = null;
	public static Context context = null;

	public static void main(String[] args) { //display the opening menu which dictates whether the user wants a test or survey
		
		initialize();
		
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
		finish();

	}
	
	public static void makeSurvey() {//display the menu and then create/display/load/save survey based on user input
		
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
						handle.printNewLines(2);
					}else {
						survey.display(handle);
					}
					break;
		
				case 3:
					loadSurvey();
					break;
				
				case 4:
					saveSurvey();
					break;
			
				case 5:
					valid = true;
					survey = null;
					break;
				
				default:
					handle.print("Invalid answer. Please try again");
					handle.printNewLines(2);
					break;
			}
			
		}
	}
	
	public static void makeTest() { //display the menu and then create/display/load/save test based on user input
		
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
						handle.printNewLines(2);
					}else {
						survey.display(handle);
					}
					break;
		
				case 3:
					loadTest();
					break;
				
				case 4:
					saveTest();
					break;
			
				case 5:
					valid = true;
					survey = null;
					break;
				
				default:
					handle.print("Invalid answer. Please try again");
					handle.printNewLines(2);
					break;
			}
		}
	}
	
	public static void loadSurvey() {

        boolean valid = false;
        
        if(context.getSurveyList().isEmpty()) {//if we've never created/saved a survey we can load any
        	handle.print("You don't have any surveys to load");
        	handle.printNewLines(2);
        	return;
        }
        
        handle.print("Surveys found:"); //display the surveys that we have saved
        for(String surveyName : context.getSurveyList()) {
        	handle.printNewLine();
        	handle.print(surveyName);
        }
        handle.printNewLines(2);
        
		String filename = handle.getStringInput("Please input the name of the survey you would like to load");
		handle.printNewLine();
        
        while(!valid) { //ask the user which test to load and then load it from the appropriate file
        	try {
                ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename));
                survey = (Survey) in.readObject();
                in.close();
    			valid = true;
    		} catch (FileNotFoundException e1) {
    			filename = handle.getStringInput("File not found, please try again");
    			handle.printNewLine();
    		} catch (IOException e1) {
    			handle.print("Something went wrong (IOException), please try again");
        		handle.printNewLine();
    			return;
    		} catch (ClassNotFoundException e) {
    			handle.print("Something went wrong (ClassNotFound), please try again");
        		handle.printNewLine();
    			return;
			}
        }
	}
	
	public static void saveSurvey() { //save the current survey
        
        if(survey == null) {
        	handle.print("No survey to save, either load or create one to save");
        	return;
        }
        
        try {
        	ObjectOutputStream oos;
    		oos = new ObjectOutputStream(new FileOutputStream(survey.getName()));
    		oos.writeObject( survey );
    		oos.close();
    		context.addSurvey(survey.getName());
    		handle.print("Survey saved");
    		handle.printNewLines(2);
    	} catch (IOException e1) {
    		handle.print("Something went wrong (IOException), please try again");
    		handle.printNewLine();
    		return;
    	}
	}
	
	public static void loadTest() { 

        boolean valid = false;
        
        if(context.getTestList().isEmpty()) {//if we've never created/saved a test we can load any
        	handle.print("You don't have any tests to load");
        	handle.printNewLines(2);
        	return;
        }
        
        handle.print("Tests found:"); //display the tests we've saved
        for(String surveyName : context.getTestList()) { 
        	handle.printNewLine();
        	handle.print(surveyName);
        }
        handle.printNewLines(2);
        
		String filename = handle.getStringInput("Please input the name of the test you would like to load");
		handle.printNewLine();
        
        while(!valid) { //ask the user which test to load and then load it from the appropriate file
        	try {
                ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename));
                survey = (TestSurvey) in.readObject();
                in.close();
    			valid = true;
    		} catch (FileNotFoundException e1) {
    			filename = handle.getStringInput("File not found, please try again");
    			handle.printNewLine();
    		} catch (IOException e1) {
    			handle.print("Something went wrong (IOException), please try again");
        		handle.printNewLine();
    			return;
    		} catch (ClassNotFoundException e) {
    			handle.print("Something went wrong (ClassNotFound), please try again");
        		handle.printNewLine();
    			return;
			}
        }
	}
	
	public static void saveTest() {//serialize and save the current test
		
        if(survey == null) {
        	handle.print("No test to save, either load or create one to save");
        	return;
        }
        
        try {
        	ObjectOutputStream oos;
    		oos = new ObjectOutputStream(new FileOutputStream(survey.getName()));
    		oos.writeObject( survey );
    		oos.close();
    		context.addTest(survey.getName());
    		handle.print("Test saved");
    		handle.printNewLines(2);
    	} catch (IOException e1) {
    		handle.print("Something went wrong (IOException), please try again");
    		handle.printNewLine();
    		return;
    	}
	}
	
	public static void initialize() { //this creates/loads the context file which keeps a record of the available tests and surveys to load
		
		Context instance = new Context();
        
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("context"));
            instance = (Context) in.readObject();
            in.close();
    	} catch (FileNotFoundException e1) {
    			//There is no context (first launch) so we'll just use the new instance
    	} catch (IOException e1) {
    			handle.print("Something went wrong initializing (IOException)");
        		handle.printNewLine();
    	} catch (ClassNotFoundException e) {
    			handle.print("Something went wrong initializing (ClassNotFound)");
        		handle.printNewLine();
		}
        context = instance;
	}
	
	public static void finish() {//before the program closes it calls this to save the context file
		ObjectOutputStream oos;
        try {
    		oos = new ObjectOutputStream(new FileOutputStream("context"));
    		oos.writeObject( context );
    		oos.close();
    	} catch (IOException e1) {
    		handle.print("Something went wrong finishing (IOException)");
    		handle.printNewLine();
    		return;
    	}
    }
}

