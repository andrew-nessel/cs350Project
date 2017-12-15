package cs350Project;

import java.util.Scanner;

public class IOHandler {
	
	Scanner reader;

	public IOHandler(){
		reader = new Scanner(System.in);
	}
	
	public void finalize() {
		print("Please call close, this could cause problems");
		close();
	}
	
	public void close() {
		reader.close();
	}
	
	public void print(String str) {
		
		System.out.print(str);
	}
	
	public void printNewLine() {
		
		printNewLines(1);
	}
	
	public void printNewLines(int num) {
		
		for(int i = 0; i < num; i++) {
			
			System.out.println();			
		}
	}
	
	public String getStringInput(String str) {
		
		print(str + "\n:");
		String input = reader.nextLine();
		
		return input.trim();
	}
	
	public int getIntInput(String str) {
		
		print(str);
		
		boolean gotResult = false;
		int result = -1;
		
		while(!gotResult) {
			try {
				
				result = Integer.parseInt(getStringInput(""));  				
				gotResult = true;
			}catch(Exception e) {
				printNewLine();
				gotResult = false;
				print("Please input just a number. Please try again");
			}
		}
		
		return result;
	}
	
	//public boolean continue
	
}
