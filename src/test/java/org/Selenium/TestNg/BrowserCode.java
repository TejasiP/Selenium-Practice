package org.Selenium.TestNg;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class BrowserCode {
	
	WebDriver w;
	String projectPath = System.getProperty("user.dir");
	
  @Test(priority = 0, description = "verify chrome")
  public void chrome() {
	  
	  System.setProperty("webdriver.chrome.driver", projectPath+"\\Drivers\\chromedriver.exe");
	  w = new ChromeDriver();
	  w.get("https://www.google.com/");
  }
  
  @Test(priority = 1, description = "verify firefox")
  public void firefox() {
	  
	  System.setProperty("webdriver.gecko.driver", projectPath+"\\Drivers\\geckodriver.exe");
	  w = new FirefoxDriver();
	  w.get("https://www.google.com/");
  }
  
  @Test(priority = 2, description = "verify edge")
  public void edge() {
	  
	  System.setProperty("webdriver.edge.driver", projectPath+"\\Drivers\\msedgedriver.exe");
	  w = new EdgeDriver();
	  w.get("https://www.google.com/");
  }
}
