package org.Selenium.Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTestCase {

	public static void main(String[] args) {
	
		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath+"\\Drivers\\chromedriver.exe");
		
		WebDriver w = new ChromeDriver();
		
		w.get("http://demo.testfire.net/login.jsp");
		w.findElement(By.id("uid")).sendKeys("admin");
		w.findElement(By.id("passw")).sendKeys("admin");
		w.findElement(By.name("btnSubmit")).click();
		//w.findElement(By.id("LoginLink")).click();
		w.findElement(By.linkText("Sign Off")).click();
		
		System.out.println("Test case executed");
		
		w.quit();
		
	}

}
