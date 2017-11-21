package cs350Project;

public class Driver {

	public static void main(String[] args) {
		
		IOHandler handle = new IOHandler();
		handle.print(new Integer(handle.getIntInput("gimme")).toString());

	}

}
