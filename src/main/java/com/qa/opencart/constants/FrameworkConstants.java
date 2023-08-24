package com.qa.opencart.constants;

import java.util.Arrays;
import java.util.List;

public class FrameworkConstants {

	public static final int DEFAULT_MEDIUM_TIMEOUT = 200;
	public static final int DEFAULT_SHORT_TIMEOUT = 100;
	public static final int DEFAULT_LONG_TIMEOUT = 500;
	
	public static final String LOGIN_PAGE_TITLE_VALUE = "Account Login";
	public static final String ACCOUNT_PAGE_TITLE_VALUE = "My Account";
	public static final String REGISTRATION_PAGE_TITLE_VALUE = "Register Account";
	public static final String ACCOUNT_CREATED_PAGE_TITLE_VALUE = "Your Account Has Been Created!";
	
	public static final String LOGIN_PAGE_URL = "route=account/login";
	public static final String ACCOUNT_PAGE_URL = "route=account/account";
	public static final String REGISTRATION_PAGE_URL = "route=account/register";
	public static final String ACCOUNT_CREATED_URL = "route=account/success";
	
	public static final String ACCOUNT_CREATED_SUCCESS_MSG = "Congratulations! Your new account has been successfully created!";
	public static final String ACCOUNT_ALREADY_EXISTS_MSG = "If you already have an account with us, please login at the login page.";
	
	public static final String FOOTER_TEXT = "Powered By OpenCart\nnaveenopencart © 2023";
	public static final List<String> LOGIN_NAV_BAR_MENU = Arrays.asList("Desktops","Laptops & Notebooks","Components","Tablets","Software","Phones & PDAs","Cameras","MP3 Players"); 
	public static final List<String> ACCOUNT_PAGE_HEADERS = Arrays.asList("My Account","My Orders","My Affiliate Account","Newsletter");
	public static final int ACCOUNT_PAGE_HEADER_COUNT = 4;
	public static final List<String> ALL_RIGHT_COLUMN_MENU = Arrays.asList("Login", "Register", "Forgotten Password", "My Account", "Address Book", "Wish List", "Order History", "Downloads", "Recurring payments", "Reward Points", "Returns", "Transactions", "Newsletter");
	public static final List<String> ALL_FOOTER_MENU = Arrays.asList("About Us", "Delivery Information", "Privacy Policy", "Terms & Conditions", "Contact Us", "Returns", "Site Map", "Brands", "Gift Certificates", "Affiliate", "Specials", "My Account", "Order History", "Wish List", "Newsletter");
	public static final List<String> ALL_FOOTER_HEADERS = Arrays.asList("Information", "Customer Service", "Extras", "My Account");
			
	public static final String REGISTRATION_PAGE_NEWSLETTER_RADIO_VALUE = "0";
}
