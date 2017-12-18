package cs350Project;

import java.io.Serializable;
import java.util.ArrayList;

public class SurveyResults implements Serializable{

	protected ArrayList<String> answers;
	
	SurveyResults(){
		answers = new ArrayList<String>();
	}
}
