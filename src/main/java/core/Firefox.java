package core;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.logging.*;

public class Firefox {
	static Properties p = new Properties();
	static WebDriver driver;

	public static void main(String[] args) throws Exception {
		p.load(new FileInputStream("./input.properties"));
		Logger.getLogger("").setLevel(Level.OFF);
		String driverPath = "";
					
		if (System.getProperty("os.name").toUpperCase().contains("MAC"))
			driverPath = "./firefox.sh";
		else if (System.getProperty("os.name").toUpperCase().contains("WINDOWS"))
			driverPath = ".\\firefox.exe";
		else throw new IllegalArgumentException("Unknown OS");

		System.setProperty("webdriver.gecko.driver", driverPath);
		System.out.println("Browser: Firefox");
		System.out.println("===================================================");
		driver = new FirefoxDriver();
		driver.get(p.getProperty("url"));
		System.out.println("Page URI: " + driver.getCurrentUrl());
		System.out.println("Page Title: " + driver.getTitle());
		driver.manage().window().maximize();
		
		WebDriverWait wait = new WebDriverWait(driver, 15);
		
wait.until(ExpectedConditions.presenceOfElementLocated(By.id(p.getProperty("fname"))))
.sendKeys(p.getProperty("fname_value"));
wait.until(ExpectedConditions.presenceOfElementLocated(By.id(p.getProperty("lname"))))
.sendKeys(p.getProperty("lname_value"));
wait.until(ExpectedConditions.presenceOfElementLocated(By.id(p.getProperty("email"))))
.sendKeys(p.getProperty("email_value"));
wait.until(ExpectedConditions.presenceOfElementLocated(By.id(p.getProperty("phone"))))
.sendKeys(p.getProperty("phone_value"));
wait.until(ExpectedConditions.presenceOfElementLocated(By.id(p.getProperty("submit_id"))))
.click();

System.out.println("===================================================");
System.out.println("Page URI: "   + driver.getCurrentUrl());
System.out.println("Page Title: " + driver.getTitle());
System.out.println("First Name: " + driver.findElement(By.id(p.getProperty("fname"))).getText());
System.out.println("Last Name: "  + driver.findElement(By.id(p.getProperty("lname"))).getText());
System.out.println("Email: "      + driver.findElement(By.id(p.getProperty("email"))).getText());
System.out.println("Phone: "      + driver.findElement(By.id(p.getProperty("phone"))).getText());
		driver.quit();
	}
}
