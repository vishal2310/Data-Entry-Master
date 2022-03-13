import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WEBDRIVER_CS extends COMMON_FUNCTION_CS{

	WebDriver web_driver;
	WebDriverWait explicit_wait;
	
	public WEBDRIVER_CS()
	{
		super();
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
	}
	
//*************Manage webdriver section*****************
	
	void open_new_webdriver(int wait_time)
	{
		web_driver = new ChromeDriver();
		web_driver.manage().window().maximize();
		set_implicite_wait(wait_time);
		explicit_wait = new WebDriverWait(web_driver, wait_time);
		explicit_wait.ignoring(TimeoutException.class);
	}
	
	void close_webdriver()
	{
		web_driver.quit();
		explicit_wait = null;
		web_driver = null;
	}
	
	void restart_webdriver(int wait_time)
	{
		close_webdriver();
		open_new_webdriver(wait_time);
	}
	
	void set_implicite_wait(int wait_time)
	{
		web_driver.manage().timeouts().implicitlyWait(wait_time, TimeUnit.SECONDS);
	}
	
//***********operation functions**********************
	
	Boolean check_element_existance(String object_value, String type_of_element)
	{
		WebElement element;
		
		try
		{
			if(type_of_element == "XPATH")
			{
				element = web_driver.findElement(By.xpath(object_value));
			}
			else
			{
				element = web_driver.findElement(By.id(object_value));
			}
		}
		catch(NoSuchElementException e)
		{
			return false;
		}
		
		return (element.isDisplayed() && element.isEnabled());
	}
	
	void check_element_clickable(String object_value, String type_of_element)
	{
		if(type_of_element == "XPATH")
		{
			explicit_wait.until(ExpectedConditions.elementToBeClickable(By.xpath(object_value)));
		}
		else
		{
			explicit_wait.until(ExpectedConditions.elementToBeClickable(By.id(object_value)));
		}
	}
	
	void __click_by_xpath(String xpath)
	{
		web_driver.findElement(By.xpath(xpath)).click();
	}
	
	void click_by_xpath(String xpath)
	{
		if(check_element_existance(xpath, "XPATH"))
		{
			check_element_clickable(xpath, "XPATH");
			__click_by_xpath(xpath);
		}
	}
	
	void __click_by_id(String id)
	{
		web_driver.findElement(By.id(id)).click();
	}
	
	void click_by_id(String id)
	{
		if(check_element_existance(id, "ID"))
		{
			check_element_clickable(id, "ID");
			__click_by_id(id);
		}
	}
	
	void click_by_name(String name)
	{
		web_driver.findElement(By.name(name)).click();
	}
	
	void set_value_by_xpath(String xpath, String value_to_set)
	{
		web_driver.findElement(By.xpath(xpath)).sendKeys(value_to_set);
	}
	
	void set_value_by_id(String id, String value_to_set)
	{
		web_driver.findElement(By.id(id)).sendKeys(value_to_set);
	}
	
	String get_value_by_xpath(String xpath)
	{
		return web_driver.findElement(By.xpath(xpath)).getText().toString();
	}
	
	void open_link(String link)
	{
		web_driver.get(link);
	}
}
