package com.qa.opencart.constants;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FrameworkConstants {

	//Error msg:
	public static final String INCORRECT_LOGIN_WARNING_MSG = " Warning: No match for E-Mail Address and/or Password.";
	public static final String INCORRECT_LOGIN_WARNING_MSG_MULTIPLE_TRY =" Warning: Your account has exceeded allowed number of login attempts. Please try again in 1 hour.";
	public static final String POLICY_CHECK_WARNING = "Warning: You must agree to the Privacy Policy!";
	public static final String PASSWORD_CHAR_ERROR = "Password must be between 4 and 20 characters!";
	public static final String PASSWORD_MISMATCH_ERROR = "Password confirmation does not match password!";
	public static final String FORGOT_PASSWORD_EMAIL_ERROR = " Warning: The E-Mail Address was not found in our records, please try again!";
	public static final String FORGOT_PASSWORD_EMAIL_ERROR2 = "  Warning: Your account has exceeded allowed number of login attempts. Please try again in 1 hour.";
	
	//SuccessMsg:
	public static final String ACCOUNT_CREATED_MSG = "Your Account Has Been Created!";
	public static final String FORGOT_PASSWORD_RESET_EMAIL = " An email with a confirmation link has been sent your email address.";
	public static final String PRODUCT_ADDED_TO_CART_First = "Success: You have added ";
	public static final String PRODUCT_ADDED_TO_CART_Last = " to your shopping cart!";
	public static final String SHOPPING_CART_REFRESH = "Success: You have modified your shopping cart!";
	public static final String ORDER_CONFIRMATION = "Your order has been placed!";
	
	//Titles
	public static final String HOME_PAGE_TITLE = "Your Store";
	public static final String LOGIN_PAGE_TITLE = "Account Login";
	public static final String REGISTRATION_PAGE_TITLE = "Register Account";
	public static final String FORGOTTEN_PASSWORD_PAGE_TITLE = "Forgot Your Password?";
	public static final String ACCOUNT_PAGE_TITLE = "My Account";
	public static final String PRODUCT_SEARCH_PAGE_TITLE = "Search";
	public static final String SHOPPING_CART_PAGE_TITLE = "Shopping Cart";
	public static final String CHECKOUT_PAGE_TITLE = "Checkout";
	public static final String ORDER_PLACED_PAGE_TITLE = "Your order has been placed!";
	
	//URLs
	public static final String HOME_PAGE_URL = "common/home";
	public static final String LOGIN_PAGE_URL = "account/login";
	public static final String FORGOTTEN_PASSWORD_PAGE_URL = "account/forgotten";
	public static final String ACCOUNT_CREATED_PAGE_URL = "account/success";
	public static final String REGISTRATION_PAGE_URL = "account/register";
	public static final String ACCOUNT_PAGE_URL = "account/account";
	public static final String ACCOUNT_LOGOUT_PAGE_URL = "account/logout";
	public static final String PRODUCT_SEARCH_PAGE_URL = "product/search";
	public static final String PRODUCT_INFO_PAGE_URL = "product/product";
	public static final String SHOPPING_CART_PAGE_URL = "checkout/cart";
	public static final String CHECKOUT_PAGE_URL = "checkout/checkout";
	public static final String ORDER_PLACED_PAGE_URL = "checkout/success";
	
	
	//Account page headers:
	public static final List<String> ACCOUNTS_PAGE_HEADER = new ArrayList<>(Arrays.asList("My Account","My Orders","My Affiliate Account","Newsletter"));
	
	//Empty acrt message:
	public static final String SHOPPING_CART_EMPTY_MESSAGE = "Your shopping cart is empty!";
	
	//Checkout page form mandatory fields error mesg:
	public static final List<String> BILLING_DETAILS_ERROR_MESSAGE = new ArrayList<>(Arrays.asList("First Name must be between 1 and 32 characters!",
			"Last Name must be between 1 and 32 characters!",
			"Address 1 must be between 3 and 128 characters!",
			"City must be between 2 and 128 characters!",
			"Postcode must be between 2 and 10 characters!",
			"Please select a region / state!"));
	
	public static final String SHIPPING_FLAT_RATE = "Flat Shipping Rate - $5.00";
	
}
