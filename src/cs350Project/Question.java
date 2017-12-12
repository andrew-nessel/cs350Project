package cs350Project;

import java.util.ArrayList;

public abstract class Question {

		protected String questionWording;
		protected ArrayList<String> answerOptions;
		
		public Question() {
			
			questionWording = "Wording not set up yet, you shouldn't be seeing this";
			answerOptions = new ArrayList<String>();
		}
		
		public abstract void build(IOHandler handler);
		public abstract void display(IOHandler handler);
		public abstract void answer(IOHandler handler);		

}
