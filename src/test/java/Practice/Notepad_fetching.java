package Practice;

import genericUtilites.PropertyFileUtility;

public class Notepad_fetching {
	public static void main(String[] args) throws Throwable {
		PropertyFileUtility p=new PropertyFileUtility();
		String URL = p.ReadDataFromProprtyFile("url");
		System.out.println(URL);
	}

}
