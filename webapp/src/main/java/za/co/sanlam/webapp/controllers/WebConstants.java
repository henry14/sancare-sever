package za.co.sanlam.webapp.controllers;

//import org.springframework.ui.ModelMap;

public class WebConstants {
	
	public static final String SUB_SYSTEM = "subSystem";

    /**
	 * default private constructor
	 */
	private WebConstants() {

	}

	/**
	 * name of the header in a request. The represent of this header in the
	 * request indicates that the request is an ajax call
	 */
	public static final String AJAX_REQUEST_HEADER = "X-AjaxRequest";

	/**
	 * the value specified for an ajax request in the header
	 */
	public static final String AJAX_REQUEST_HEADER_SET = "X-AjaxRequest=1";

	/**
	 * model attribute name that can be used to access the system message of an
	 * operation.
	 */
	public static final String SYSTEM_MESSAGE = "systemMessage";

	/**
	 * model attribute name that can be used to access the error message
	 */
	public static final String ERROR_MESSAGE = "errorMessage";

	/**
	 * model attribute name that can be used to access the content header
	 * message
	 */
	public static final String CONTENT_HEADER = "contentHeader";

	/**
	 * a boolean model attribute to indicate whether we show the report view (in
	 * this view, we hide the add/edit/delete buttons)
	 * 
	 */
	public static final String REPORT_VIEW_ATTRIBUTE = "reportView";

	/**
	 * model attribute name for long-response-text
	 */
	public static final String LONG_RESPONSE_TEXT = "longResponseText";

	/**
	 * Request parameter name for the search query
	 */
	public static final String SEARCH_QUERY_REQUEST_PARAMETER_NAME = "query";

	public static final String NO_PAY_ACTION = "nopayaction";

	/**
	 * represents the default image size of the uploaded images.
	 */
	public static final long DEFAULT_IMAGE_SIZE_IN_BYTES = 9097152;

	/*public static void loadLoggedInUserProfile(User u, ModelMap model) {
//		if (u.getPicture() == null) {
//			model.put("profile_Img", "empty");
//		}

		model.put("loggedUser", u);
	}*/

}
