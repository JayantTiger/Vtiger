package genericUtilites;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class PropertyFileUtility {
	public String ReadDataFromProprtyFile(String key) throws Throwable {
		FileInputStream fisp=new FileInputStream(IconstantUtility.propertyFilePath);
		Properties p=new Properties();
		p.load(fisp);
		String value = p.getProperty(key);
		return value;
		
	}

}
