package cs350Project;

import java.util.ArrayList;

public abstract class Question {

		protected String questionWording;
		protected ArrayList<String> answerOptions;
		protected boolean hasAnswers;
		
		public Question() {
			
		}
		
		public abstract String getWording();
		public abstract ArrayList<String> getAnswers();
		public abstract void addAnswer(String answer);
		public abstract boolean hasAnswers();
		

}
