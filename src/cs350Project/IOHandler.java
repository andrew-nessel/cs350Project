package cs350Project;

import java.util.Scanner;

public class IOHandler {

	public IOHandler(){
		
	}
	
	public void print(String str) {
		System.out.print(str);
	}
	
	public String getStringInput(String str) {
		
		print(str);
		
		Scanner reader = new Scanner(System.in);
		String input = reader.nextLine();
		reader.close();
		
		
		return input;
	}
	
	public int getIntInput(String str) {
		
		print(str);
		
		boolean gotResult = false;
		int result = -1;
		
		
		while(!gotResult) {
			try {
		
				Scanner reader = new Scanner(System.in);
				result = reader.nextInt();
				reader.close();
				
				gotResult = true;
		
			}catch(Exception e) {
				gotResult = false;
				print("Please input just a number. Please try again: ");
			}
		}
		
		return result;
	}
}
