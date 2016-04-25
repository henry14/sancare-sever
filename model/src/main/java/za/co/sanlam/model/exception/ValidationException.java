package za.co.sanlam.model.exception;

public class ValidationException extends Exception{

	private static final long serialVersionUID = 7715465807558864835L;
	
	public ValidationException() {
		super();
	}

	public ValidationException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public ValidationException(String arg0) {
		super(arg0);

	}

	public ValidationException(Throwable arg0) {
		super(arg0);
	}

}
