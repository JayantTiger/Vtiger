package Practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class Property_fetching {
	public static void main(String[] args) throws Throwable {
		FileInputStream fisp=new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		//create proprty class
		Properties p=new Properties();
		p.load(fisp);
		String BROWSER = p.getProperty("browser");
		System.out.println(BROWSER);
		
		String URL = p.getProperty("url");
		System.out.println(URL);
		
		String USERNAME = p.getProperty("username");
		System.out.println(USERNAME);
		
		String PASSWORD = p.getProperty("password");
		System.out.println(PASSWORD);
		
	}

}
