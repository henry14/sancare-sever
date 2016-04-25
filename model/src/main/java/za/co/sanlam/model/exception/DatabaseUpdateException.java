package za.co.sanlam.model.exception;

public class DatabaseUpdateException extends Exception{

	private static final long serialVersionUID = 8596457769110876790L;
	
	public DatabaseUpdateException() {
	}

	public DatabaseUpdateException(String message) {
		super(message);
	}

	public DatabaseUpdateException(Throwable cause) {
		super(cause);
	}

	public DatabaseUpdateException(String message, Throwable cause) {
		super(message, cause);
	}

}
