import org.openqa.selenium.By;

public class SEND_MAIL_CS extends WEBDRIVER_CS{

	private
	String MAIL_SITE = "https://outlook.live.com/owa/?nlp=1";
	
	String LOGIN_LINE_EDIT = "//*[@id=\"i0116\"]";
	String PASSWOORD_LINE_EDIT = "//*[@id=\"i0118\"]";
	String LOGIN_AND_NEXT_BUTTON_ID = "idSIButton9";
	
	String NEW_MESSAGE_XPATH = "//span[text()='New message']";
	String TO_LINE_EDIT_XPATH = "//input[@aria-label='To']";
	String MAIL_ID_SELECTION_XPATH = "//span[@class='_4wS9glr5lB-SLUR2t26UQ _23JBt7fx0jOvhxZvDAKNBi']";
	String SUBJECT_LINE_EDIT_XPATH = "//input[@placeholder='Add a subject']";
	String MESSAGE_BODY_XPATH =  "//div[@aria-label='Message body']//div";
	String SEND_BUTTON_XPATH = "//button[@title='Send (Ctrl+Enter)']";
	
	public SEND_MAIL_CS()
	{
		open_new_webdriver(WAIT_TIME_SELENIUM);
		open_link(MAIL_SITE);
	}
	
	void send_email(String login_id, String password, String[] mail_id_to_send_result, String mail_subject, String message_content)
	{
		sign_in(login_id, password);
		
		click_by_xpath(NEW_MESSAGE_XPATH);
		
		for(int i = 0; i < mail_id_to_send_result.length; i++)
		{
			set_value_by_xpath(TO_LINE_EDIT_XPATH, mail_id_to_send_result[i]);
			click_by_xpath(MAIL_ID_SELECTION_XPATH);
		}
		
		set_value_by_xpath(SUBJECT_LINE_EDIT_XPATH, mail_subject);
		
		set_value_by_xpath(MESSAGE_BODY_XPATH, message_content);
		
		click_by_xpath(SEND_BUTTON_XPATH);
		
		close_webdriver();
	}
	
	void sign_in(String login_id, String password)
	{
		set_value_by_xpath(LOGIN_LINE_EDIT, login_id);
		click_by_id(LOGIN_AND_NEXT_BUTTON_ID);
		
		set_value_by_xpath(PASSWOORD_LINE_EDIT, password);
		click_by_id(LOGIN_AND_NEXT_BUTTON_ID);
		
		click_by_id(LOGIN_AND_NEXT_BUTTON_ID);
	}
}
