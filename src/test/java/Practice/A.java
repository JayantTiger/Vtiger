package Practice;

import genericUtilites.PropertyFileUtility;

public class A {
public static void main(String[] args) throws Throwable {
	PropertyFileUtility p=new PropertyFileUtility();
	String UN = p.ReadDataFromProprtyFile("username");
	System.out.println(UN);
	String pwd = p.ReadDataFromProprtyFile("password");
	System.out.println(pwd);
	System.out.println("i am frm github");
}
}
