package za.co.sanlam.model.exception;

public class UnexpectedException extends RuntimeException{

	private static final long serialVersionUID = -6741631173668176443L;
	
	public UnexpectedException() {
		super();
	}

	public UnexpectedException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public UnexpectedException(String arg0) {
		super(arg0);

	}

	public UnexpectedException(Throwable arg0) {
		super(arg0);
	}

}
