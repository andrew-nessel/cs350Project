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

	public static void main(String[] args) {
		
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
					loadSurvey();
					break;
				
				case 4:
					saveSurvey();
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
					loadTest();
					break;
				
				case 4:
					saveTest();
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
	
	public static void loadSurvey() {

        boolean valid = false;
        
        if(context.getSurveyList().isEmpty()) {
        	handle.print("You don't have any surveys to load");
        	return;
        }
        
        handle.print("Surveys found:");
        for(String surveyName : context.getSurveyList()) {
        	handle.print(surveyName);
        	handle.printNewLine();
        }
        handle.printNewLine();
        
		String filename = handle.getStringInput("Please input the name of the survey you would like to load");
        
        while(!valid) {
        	try {
                ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename));
                survey = (Survey) in.readObject();
                in.close();
    			valid = true;
    		} catch (FileNotFoundException e1) {
    			handle.getStringInput("File not found, please try again");
    		} catch (IOException e1) {
    			handle.getStringInput("Something went wrong (IOException), please try again");
    			return;
    		} catch (ClassNotFoundException e) {
    			handle.getStringInput("Something went wrong (ClassNotFound), please try again");
    			return;
			}
        }
	}
	
	public static void saveSurvey() {
		
        boolean valid = false;
        
        if(survey == null) {
        	handle.print("No Survey to save, either load or create one to save");
        	return;
        }
        
        while(!valid) {
        	try {
                ObjectOutputStream oos;
    			oos = new ObjectOutputStream(new FileOutputStream(survey.getName()));
    			oos.writeObject( survey );
    			oos.close();
    			context.addSurvey(survey.getName());
    			valid = true;
    		} catch (IOException e1) {
    			handle.getStringInput("Something went wrong (IOException), please try again");
    			return;
    		}
        }
	}
	
	public static void loadTest() {

        boolean valid = false;
        
        if(context.getTestList().isEmpty()) {
        	handle.print("You don't have any tests to load");
        	return;
        }
        
        handle.print("Tests found:");
        handle.printNewLine();
        for(String surveyName : context.getTestList()) {
        	handle.print(surveyName);
        	handle.printNewLine();
        }
        handle.printNewLine();
        
		String filename = handle.getStringInput("Please input the name of the test you would like to load");
        
        while(!valid) {
        	try {
                ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename));
                survey = (TestSurvey) in.readObject();
                in.close();
    			valid = true;
    		} catch (FileNotFoundException e1) {
    			handle.getStringInput("File not found, please try again");
    		} catch (IOException e1) {
    			handle.getStringInput("Something went wrong (IOException), please try again");
    			return;
    		} catch (ClassNotFoundException e) {
    			handle.getStringInput("Something went wrong (ClassNotFound), please try again");
    			return;
			}
        }
	}
	
	public static void saveTest() {
		
        boolean valid = false;
        
        if(survey == null) {
        	handle.print("No test to save, either load or create one to save");
        	return;
        }
        
        while(!valid) {
        	try {
                ObjectOutputStream oos;
    			oos = new ObjectOutputStream(new FileOutputStream(survey.getName()));
    			oos.writeObject( survey );
    			oos.close();
    			context.addSurvey(survey.getName());
    			valid = true;
    		} catch (IOException e1) {
    			handle.getStringInput("Something went wrong (IOException), please try again");
    			return;
    		}
        }
	}
	
	public static void initialize() {
		
		Context instance = new Context();
        
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("context"));
            instance = (Context) in.readObject();
            in.close();
    	} catch (FileNotFoundException e1) {
    			//There is no context (first launch) so we'll just use the new instance
    	} catch (IOException e1) {
    			handle.getStringInput("Something went wrong initializing (IOException)");
    	} catch (ClassNotFoundException e) {
    			handle.getStringInput("Something went wrong initializing (ClassNotFound)");
		}
        context = instance;
	}
	
	public static void finish() {
		ObjectOutputStream oos;
        try {
    		oos = new ObjectOutputStream(new FileOutputStream("context"));
    		oos.writeObject( context );
    		oos.close();
    	} catch (IOException e1) {
    		handle.getStringInput("Something went wrong finishing (IOException)");
    		return;
    	}
    }
}

