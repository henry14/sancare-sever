package za.co.sanlam.model.exception;

public class SessionExpiredException extends Exception{

	private static final long serialVersionUID = 1899793833028532724L;
	
	public SessionExpiredException() {
		super();
	}

	public SessionExpiredException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public SessionExpiredException(String arg0) {
		super(arg0);

	}

	public SessionExpiredException(Throwable arg0) {
		super(arg0);
	}

}
