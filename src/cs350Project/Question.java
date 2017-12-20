package cs350Project;

import java.io.Serializable;
import java.util.ArrayList;

public abstract class Question implements Serializable { //the abstract class of a question
															//this has the methods that allow the survey/test classes
															//to easily create, display, answer, etc. while letting the question 
															//handle the specifics of how each kind of question operates

		protected String questionWording;
		protected ArrayList<String> answerOptions;
		
		public Question() {
			
			questionWording = "Wording not set up yet, you shouldn't be seeing this";
			answerOptions = new ArrayList<String>();
		}
		
		public abstract void build(IOHandler handler);
		public abstract void display(IOHandler handler);
		public abstract String answer(IOHandler handler);
		public abstract void modify(IOHandler handler);
		public abstract boolean validateAnswer(String answer);
		public abstract boolean hasCorrectAnswer();
		
		
	public String intToLetter(int i) { //this method is for easily translating numbers to letters for formatting 
										//inb4 realizing I could've used unicode
			switch(i) {
			
			case 0:
				return "A";
			case 1:
				return "B";
			case 2:
				return "C";
			case 3:
				return "D";
			case 4:
				return "E";
			case 5:
				return "F";
			case 6:
				return "G";
			case 7:
				return "H";
			case 8:
				return "I";
			case 9:
				return "J";
			case 10:
				return "K";
			case 11:
				return "L";
			case 12:
				return "M";
			case 13:
				return "N";
			case 14:
				return "O";
			case 15:
				return "P";
			case 16:
				return "Q";
			case 17:
				return "R";
			case 18:
				return "S";
			case 19:
				return "T";
			case 20:
				return "U";
			case 21:
				return "V";
			case 22:
				return "W";
			case 23:
				return "X";
			case 24:
				return "Y";
			case 25:
				return "Z";				
			default:
				if(i>25) { //this is here so if the number is higher than 25 than we need to move to double letters Y, Z, AA, AB, etc.
					int prefix = i/26-1;
					int suffix = i%26;
					return intToLetter(prefix) + intToLetter(suffix);
				}else {
					return "";
				}
			}
		}
		
		public int letterToInt(String str) {//return the conversion of a letter to a number A->0, B->1, AA->27, (learned my lesson and used unicode)
			int num = -1;
			int ten = 0;
			String i = str.toLowerCase();
			
			
			if(!i.matches("^[a-z]*$")) {//if this isn't just letters something went wrong
				System.out.println("got here you nut");
				return -1;
			}
			
			for(char c : i.toCharArray()){//this converts letters to numbers through unicode (the 26^ten is in case there are 26+ answers so we have to use AA, AB, etc.)
				num += (c - 'a' + 1) * Math.pow(26,ten);
				ten+=1;
			}
			
			return num;
		}

}
