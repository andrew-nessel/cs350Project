package cs350Project;

import java.io.Serializable;
import java.util.ArrayList;

public class Context implements Serializable {
	
	ArrayList<String> TestFileList;
	ArrayList<String> SurveyFileList;
	
	public Context() {
		TestFileList = new ArrayList<String>();
		SurveyFileList = new ArrayList<String>();
	}
	
	public void addTest(String test) {
		TestFileList.add(test);
	}
	
	public ArrayList<String> getTestList(){
		return TestFileList;
	}
	
	public void addSurvey(String test) {
		SurveyFileList.add(test);
	}
	
	public ArrayList<String> getSurveyList(){
		return SurveyFileList;
	}
	
	
}