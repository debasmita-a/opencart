package com.qa.opencart.constants;

public class FrameworkConstants {

	//Error msg:
	public static final String INCORRECT_LOGIN_WARNING_MSG = " Warning: No match for E-Mail Address and/or Password.";
	public static final String POLICY_CHECK_WARNING = "Warning: You must agree to the Privacy Policy!";
	public static final String PASSWORD_CHAR_ERROR = "Password must be between 4 and 20 characters!";
	public static final String PASSWORD_MISMATCH_ERROR = "Password confirmation does not match password!";
	public static final String FORGOT_PASSWORD_EMAIL_ERROR = " Warning: The E-Mail Address was not found in our records, please try again!";
	public static final String FORGOT_PASSWORD_EMAIL_ERROR2 = "  Warning: Your account has exceeded allowed number of login attempts. Please try again in 1 hour.";
	
	//SuccessMsg:
	public static final String ACCOUNT_CREATED_MSG = "Your Account Has Been Created!";
	public static final String FORGOT_PASSWORD_RESET_EMAIL = " An email with a confirmation link has been sent your email address.";
	
	//Titles
	public static final String HOME_PAGE_TITLE = "Your Store";
	public static final String LOGIN_PAGE_TITLE = "Account Login";
	public static final String REGISTRATION_PAGE_TITLE = "Register Account";
	public static final String FORGOTTEN_PASSWORD_PAGE_TITLE = "Forgot Your Password?";
	public static final String ACCOUNT_PAGE_TITLE = "My Account";
	
	//URLs
	public static final String HOME_PAGE_URL = "common/home";
	public static final String LOGIN_PAGE_URL = "account/login";
	public static final String FORGOTTEN_PASSWORD_PAGE_URL = "account/forgotten";
	public static final String ACCOUNT_CREATED_PAGE_URL = "account/success";
	public static final String REGISTRATION_PAGE_URL = "account/register";
	public static final String ACCOUNT_PAGE_URL = "account/account";
	public static final String ACCOUNT_LOGOUT_PAGE_URL = "account/logout";
	
}
