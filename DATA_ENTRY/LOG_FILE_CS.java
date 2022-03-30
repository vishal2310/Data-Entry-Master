import java.io.*;

import com.testing.framework.FileUtilities;

public class LOG_FILE_CS extends COMMON_FUNCTION_CS{
	
	String file_path;
	FileUtilities file_utilities;
	File file;
	PrintWriter pw;

	public LOG_FILE_CS(String folder_name, String file_name) throws IOException
	{
		file_utilities = new FileUtilities();
		file_path = folder_name+"//"+file_name;
		
		create_folder(folder_name);
		create_file(file_name);
		
		pw = new PrintWriter(file);
	}
	
	void create_folder(String folder_name)
	{
		file = new File(folder_name);
		file.mkdir();
		file = null;
	}
	
	void create_file(String file_name)
	{	
		file = new File(file_path);
		try 
		{
			file.createNewFile();
		} 
		catch (IOException e) 
		{

		}
		
	}
	
	boolean check_file_exist(String file_name)
	{
		boolean file_exists = false;
		try 
		{
			file_exists = file_utilities.isFileExists("C:\\Users\\Vishalpatel\\Desktop\\Master_Solution", file_name);
			return file_exists;
		} 
		catch (IOException e) 
		{
			return false;
		}
	}
	
	void write_in_file(String value)
	{
		pw.println(value);
		pw.flush();
	}
	
}
