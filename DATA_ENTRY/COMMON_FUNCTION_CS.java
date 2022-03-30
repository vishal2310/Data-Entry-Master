
public class COMMON_FUNCTION_CS extends PRESS_KEY_CS{

	public COMMON_FUNCTION_CS() 
	{
		super();
	}
	
	void print_line(String value_to_print)
	{
		System.out.print(value_to_print);
	}
	
	void static_wait(int static_sleep_time)
	{
		try 
		{
			Thread.sleep(static_sleep_time);
		} 
		catch (InterruptedException e) 
		{
			
		}
	}

}
