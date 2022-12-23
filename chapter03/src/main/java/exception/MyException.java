package exception;

public class MyException extends Exception {

	public MyException() {
		super("MyException Occurs");
	}

	public MyException(String message) {
		super(message);
	}
}
