import java.util.HashMap;
import java.util.Map;

public class GLOBAL_OBJECT_CS{

	public
	String ADMIN_USER_NAME = "Vishalpatel";
	static Map<String,String> ID_PASS_DICT = new HashMap<String,String>();
	
	public GLOBAL_OBJECT_CS()
	{
		ID_PASS_DICT.put("IFNU9559", "Vishal.21");
		ID_PASS_DICT.put("IFNU11339", "Vishal.21");	
		ID_PASS_DICT.put("IFNU14233", "Vishal.21");
		ID_PASS_DICT.put("IFNU6172", "@karan1212");
		ID_PASS_DICT.put("IFNU6173", "@karan1212");
		ID_PASS_DICT.put("IFNU6187", "Priyank@1209");
	    ID_PASS_DICT.put("IFNU5039", "Pankil@1209");	
		ID_PASS_DICT.put("IFNU11438", "Yuvipatel17@");		
		ID_PASS_DICT.put("IFNU11441", "#Mmn2102");	
		ID_PASS_DICT.put("IFNU11610", "Pankil@1209");		
		ID_PASS_DICT.put("RKU12614", "ROOT@1111");
		ID_PASS_DICT.put("IFNU14828", "Mayank.02");
		ID_PASS_DICT.put("IFNU14544", "priyank@1209");
	}

//selenium parameters
	int WAIT_TIME_SELENIUM = 7;

//outlook
	String LOGIN_ID_OUTLOOK = "vishal.patel2310@outlook.com";
	String PASSWORD_OUTLOOK = "vishal.21";
	
	String[] MAIL_ID_TO_SEND_RESULT = { 
										"patvishal.01@gmail.com",
										"pankil909@gmail.com",
										"priyank1051p@gmail.com"
										
										};
	
//master solution website's objects
	String WEBSITE_MASTER_SOLUTION = "https://mastersolutions.online/Users/JobWork";
	String USER_NAME_ID_MST = "UserName";
	String PASSWORD_ID_MST = "Password";
	String LOGIN_XPATH_MST = "//input[@value='Log In']";
//	String CLOSE_BUTTON_XPATH_MST = "//button[text()='Close']";
	String CLOSE_BUTTON_XPATH_MST = "//*[@id=\\\"NotificationModel\\\"]/div/div/div[2]/div[2]/button";
	String TODAYS_WORK_XPATH_MST = "//a[@href='/Users/TodayWork']";
	String START_WORK_XPATH_MST = "//a[@href='/Users/JobWork']";
	
	String ENTER_CAPTCHA_ID_MST = "EnteredCaptcha";
	String REMAINING_DATA_XPATH_MST = "//div[3]//div[2]//div[1]//div[2]//h3[1]";
	String ATTEMPTED_ENTRY_XPATH_MST = "//div[4]//div[1]//div[1]//div[2]//h3[1]";
	String RIGHT_ENTRY_XPATH_MST = "//div[4]//div[2]//div[1]//div[2]//h3[1]";
	String WRONG_ENTRY_XPATH_MST = "//div[@class='row dashboard']//div[3]//div[1]//div[2]//h3[1]";
	String HOLIDAY_NOTICE_XPATH_MST = "//div[normalize-space()='Today is Holiday. No work today!']";
	
	String CAPTCHA_IMAGE_XPATH_MST = "//*[@id=\"frmJobWork\"]/div[1]/div[1]";
	String SAVE_AND_NEXT_BUTTON_ID_MST = "btnSubmit";
	String MY_ACCOUNT_MENU_XPATH_MST = "//a[normalize-space()='My Account']";
	String LOGOUT_XPATH_MST = "//a[@href='/Users/Logout']";
}
