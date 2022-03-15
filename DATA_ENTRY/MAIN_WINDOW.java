import java.util.Map;
import java.util.concurrent.TimeoutException;

public class MAIN_WINDOW extends  WEBDRIVER_CS{
	
	String entry_result_for_mail = "***********************";
	
	MAIN_WINDOW()
	{
		super();
	}

	public static void main(String[] args)
	{
		MAIN_WINDOW main_window = new MAIN_WINDOW();

		for (Map.Entry<String,String> entry : ID_PASS_DICT.entrySet())
		{
			String user_id = entry.getKey();
			String password = entry.getValue();
			
			main_window.work_task(user_id, password);
		}
		
		main_window.send_result_mail();
	}
	
	void work_task(String user_name, String password)
	{	
		open_new_webdriver(WAIT_TIME_SELENIUM);
		open_link(WEBSITE_MASTER_SOLUTION);
		
		login(user_name, password);

		//close_notification();

		go_to_work_page();
		
		set_implicite_wait(2);
		boolean status = get_work_status(user_name);
		set_implicite_wait(WAIT_TIME_SELENIUM);
		
		if(status)
		{
			complete_work();
			result_to_display(user_name);
		}
		logout();
		
		close_webdriver();
	}
	
	void login(String userName, String password)
	{	
		set_value_by_id(USER_NAME_ID_MST, userName);
		set_value_by_id(PASSWORD_ID_MST, password);

		click_by_xpath(LOGIN_XPATH_MST);
	}
	
	void close_notification()
	{
		click_by_xpath(CLOSE_BUTTON_XPATH_MST);
	}
	
	void go_to_work_page()
	{
		click_by_xpath(TODAYS_WORK_XPATH_MST);
		click_by_xpath(START_WORK_XPATH_MST);
	}
	
	boolean get_work_status(String user_name)
	{
		if(check_element_existance("ENTER_CAPTCHA_ID_MST", "ID"))
		{
			return true;
		}
		else if(check_element_existance(REMAINING_DATA_XPATH_MST, "XPATH"))
		{
			int remaining_data = Integer.parseInt(get_value_by_xpath(REMAINING_DATA_XPATH_MST));
			
			if(remaining_data == 0)
			{
				result_to_display(user_name);
				return false;
			}
			return true;
		}
		else if(check_element_existance(HOLIDAY_NOTICE_XPATH_MST, "XPATH"))
		{
			String holiday_status = "\n user name : "+user_name+ "\n Status : " +get_value_by_xpath(HOLIDAY_NOTICE_XPATH_MST)+"\n";
			
			print_line(holiday_status);
			
			entry_result_for_mail = entry_result_for_mail + holiday_status;
			
			return false;
		}
		else
		{
			String unknown_status = "\n user name : "+user_name+ "\n Status : No Notice But No Work!!!";
			
			print_line(unknown_status);
			
			entry_result_for_mail = entry_result_for_mail + unknown_status;
			
			return false;
		}
	}
	
	void result_to_display(String user_name)
	{
		int remaining_data = Integer.parseInt(get_value_by_xpath(REMAINING_DATA_XPATH_MST));
		int attempted_entry  = Integer.parseInt(get_value_by_xpath(ATTEMPTED_ENTRY_XPATH_MST));
		int rightEntry_entry  = Integer.parseInt(get_value_by_xpath(RIGHT_ENTRY_XPATH_MST));
		int wrongEntry_entry  = Integer.parseInt(get_value_by_xpath(WRONG_ENTRY_XPATH_MST));
		
		String result_desk = "\n user name : "+user_name+ ""
							+ "\n remainingData : " +remaining_data +"\n"
							+ " attempted : "+attempted_entry+"\n"
							+ " right Entry : "+rightEntry_entry+ "\n"
							+ " wrong Entry : "+wrongEntry_entry+ "\n"; 
		
		print_line(result_desk);
		
		entry_result_for_mail = entry_result_for_mail + result_desk;
	}
	
	void complete_work()
	{
		int remaining_data = Integer.parseInt(get_value_by_xpath(REMAINING_DATA_XPATH_MST));
		
		while(remaining_data > 0)
		{
			__set_value_by_id(ENTER_CAPTCHA_ID_MST, get_value_by_xpath(CAPTCHA_IMAGE_XPATH_MST));
			__click_by_id(SAVE_AND_NEXT_BUTTON_ID_MST);
			remaining_data--;
		}
	}
	
	void logout()
	{	
		//here I have added double click bcz we need 2 click to open my acc drop box
		click_by_xpath(MY_ACCOUNT_MENU_XPATH_MST);
		click_by_xpath(MY_ACCOUNT_MENU_XPATH_MST);
		
		click_by_xpath(LOGOUT_XPATH_MST);
	}
	
	void send_result_mail()
	{
		SEND_MAIL_CS send_mail_obj = new SEND_MAIL_CS();
		
		send_mail_obj.send_email(LOGIN_ID_OUTLOOK, PASSWORD_OUTLOOK, MAIL_ID_TO_SEND_RESULT, 
									"ENTRY...RESULT", entry_result_for_mail);
	}
}

