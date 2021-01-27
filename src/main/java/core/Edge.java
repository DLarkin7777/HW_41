package core;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Edge {
	static WebDriver driver;
	static Properties p = new Properties();
	
	public static void main(String[] args) throws Exception {
		Logger.getLogger("").setLevel(Level.OFF);
		p.load(new FileInputStream("./input.properties"));
		System.setProperty("webdriver.edge.driver", "msedgedriver");
		driver = new EdgeDriver();
		System.out.println("Browser: Edge");
		System.out.println("===================================================");
		driver.get(p.getProperty("url"));
		System.out.println("Page URI: " + driver.getCurrentUrl());
		System.out.println("Page Title: " + driver.getTitle());
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
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
		//Thread.sleep(1000);
		System.out.println("Page URI: "   + driver.getCurrentUrl());
		System.out.println("Page Title: " + driver.getTitle());
		System.out.println("First Name: " + driver.findElement(By.id(p.getProperty("fname"))).getText());
		System.out.println("Last Name: "  + driver.findElement(By.id(p.getProperty("lname"))).getText());
		System.out.println("Email: "      + driver.findElement(By.id(p.getProperty("email"))).getText());
		System.out.println("Phone: "      + driver.findElement(By.id(p.getProperty("phone"))).getText());
				driver.quit();
		
	
	
	
	}
}
