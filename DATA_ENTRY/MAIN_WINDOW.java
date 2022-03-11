import java.util.Map;
import java.util.concurrent.TimeoutException;

public class MAIN_WINDOW extends  WEBDRIVER_CS{
	
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
			
			main_window.work_task(user_id, password, 3);
		}
	}
	
	void work_task(String user_id, String password, int counter)
	{	
		open_new_webdriver(15);
		open_link(WEBSITE_MASTER_SOLUTION);
		
		login(user_id, password);

		close_notification();

		go_to_work_page();
		
		if(get_work_status(user_id))
		{
			System.out.print("hiiiii");
		}
//		
//		goToWorkPage(2);
//
//		boolean status = check_for_work(user_id);
//
//		if(status)
//		{
//			boolean work_status = false;
//			
//			work_status = completeDataEntry(0);;
//			
//			while (counter > 0 && !work_status)
//			{
//				counter--;
//				global_obj.web_driver.quit();
//				global_obj.web_driver = null;
//				work_task(user_id, password, counter);
//			}
//			
//			Thread.sleep(2000); 
//			
//			resultAfterDataEntry(user_id);
//		}
//			
//		logoutAccount();
//		global_obj.web_driver.quit();
//		global_obj.web_driver = null;
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
		if(check_element_existance("SSDASD", "ID"))
		{
			return true;
		}
		else if(check_element_existance(REMAINING_DATA_XPATH_MST, "XPATH"))
		{
			int remaining_data = Integer.parseInt(get_value_by_xpath(REMAINING_DATA_XPATH_MST));
			
			if(remaining_data == 299)
			{
				result_to_display(user_name);
				return false;
			}
			return true;
		}
		
		return false;
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
	
	}
}


