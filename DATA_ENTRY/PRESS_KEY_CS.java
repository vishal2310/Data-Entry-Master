import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

public class PRESS_KEY_CS extends GLOBAL_OBJECT_CS{

	Robot robot;
	
	public PRESS_KEY_CS() 
	{
		super();
		try 
		{
			robot = new Robot();
		} 
		catch (AWTException e) 
		{
			e.printStackTrace();
		}
	}
	
	void press_key_enter()
	{
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}
}
