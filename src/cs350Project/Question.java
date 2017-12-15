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
		public abstract String answer(IOHandler handler);	
		public abstract boolean validateAnswer(String answer);
		public abstract boolean hasCorrectAnswer();
		
		
		public String intToLetter(int i) { //inb4 realizing I could've used unicode
			switch(i) {
			
			case 1:
				return "A";
			case 2:
				return "B";
			case 3:
				return "C";
			case 4:
				return "D";
			case 5:
				return "E";
			case 6:
				return "F";
			case 7:
				return "G";
			case 8:
				return "H";
			case 9:
				return "I";
			case 10:
				return "J";
			case 11:
				return "K";
			case 12:
				return "L";
			case 13:
				return "M";
			case 14:
				return "N";
			case 15:
				return "O";
			case 16:
				return "P";
			case 17:
				return "Q";
			case 18:
				return "R";
			case 19:
				return "S";
			case 20:
				return "T";
			case 21:
				return "U";
			case 22:
				return "V";
			case 23:
				return "W";
			case 24:
				return "X";
			case 25:
				return "Y";
			case 26:
				return "Z";				
			default:
				if(i>26) {
					int prefix = i/26;
					int suffix = i%26;
					return intToLetter(prefix) + intToLetter(suffix);
				}else {
					return "";
				}
			}
		}
		
		public static int letterToInt(String str) {//return the conversion of a letter to a number A->0, B->1, AA->27, (learned my lesson and used unicode)
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
