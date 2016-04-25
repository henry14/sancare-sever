package za.co.sanlam.model.exception;

import org.apache.commons.lang.StringUtils;

public class IdNotFoundInDataBaseException extends Exception {

	private static final long serialVersionUID = 6463846284238179074L;
	
	public IdNotFoundInDataBaseException() {
	}

	public IdNotFoundInDataBaseException(String objectName) {
		super(
				StringUtils.isBlank(objectName) ? "Object with given ID not found in database"
						: objectName + " with given ID not found in database");
	}

	public IdNotFoundInDataBaseException(Throwable cause) {
		super(cause);
	}

	public IdNotFoundInDataBaseException(String message, Throwable cause) {
		super(message, cause);
	}

}
