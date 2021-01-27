package core;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Safari {

	static WebDriver driver;
	static Properties p = new Properties();

	public static void main(String[] args) throws Exception {
		p.load(new FileInputStream("./input.properties"));
		Logger.getLogger("").setLevel(Level.OFF);
		
					
		//if (System.getProperty("os.name").toUpperCase().contains("MAC"))
		//	driverPath = "./firefox.sh";
		//else if (System.getProperty("os.name").toUpperCase().contains("WINDOWS"))
		//	driverPath = ".\\firefox.exe";
		//else throw new IllegalArgumentException("Unknown OS");

		System.out.println("Browser: Safari");
		System.out.println("===================================================");
		driver = new SafariDriver();
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
Thread.sleep(1000);
System.out.println("Page URI: "   + driver.getCurrentUrl());
System.out.println("Page Title: " + driver.getTitle());
System.out.println("First Name: " + driver.findElement(By.id(p.getProperty("fname"))).getText());
System.out.println("Last Name: "  + driver.findElement(By.id(p.getProperty("lname"))).getText());
System.out.println("Email: "      + driver.findElement(By.id(p.getProperty("email"))).getText());
System.out.println("Phone: "      + driver.findElement(By.id(p.getProperty("phone"))).getText());
		driver.quit();
	}
		
}
