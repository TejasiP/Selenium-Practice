package com.selenium.keyworddriven;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class ReadProperties {
	public static void main(String[] args) throws Exception
	{
		String projectPath=System.getProperty("user.dir");
		
	    FileInputStream fin=new FileInputStream(projectPath+"\\config.properties");
		
	    Properties prop=new Properties();
	    prop.load(fin);
	    
	    System.out.println(prop.getProperty("url"));
	    System.out.println(prop.getProperty("browser"));
	}

}
