package week6assignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Cucumber {
	
	public static void main(String[] args) throws InterruptedException {
		
	
	ChromeDriver driver = new ChromeDriver();
	
	driver.manage().window().maximize();
	
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	
	driver.get("https://login.salesforce.com");
	
	driver.findElement(By.id("username")).sendKeys("dilip@testleaf.com");
    
    driver.findElement(By.id("password")).sendKeys("testleaf@2024");
    
    driver.findElement(By.id("Login")).click();
    
    Thread.sleep(3000);
    driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
    
    driver.findElement(By.xpath("(//button[@class='slds-button'])[2]")).click();
    
    driver.findElement(By.xpath("//p[text()='Sales']")).click();
    
    WebElement accounts = driver.findElement(By.xpath("(//span[text()='Accounts'])[1]"));
    driver.executeScript("arguments[0].click();",accounts);
    
    driver.findElement(By.xpath("//div[text()='New']")).click();
	
    Thread.sleep(3000);
	WebElement accountNameField = driver.findElement(By.xpath("(//input[@class='slds-input'])[5]"));
	accountNameField.sendKeys("Mathi");
	
    Thread.sleep(3000);
	WebElement dropdownButton = driver.findElement(By.xpath("(//span[text()='--None--'])[3]"));
    driver.executeScript("arguments[0].click();", dropdownButton);
    
    Thread.sleep(2000);
    WebElement publicOption =driver.findElement(By.xpath("//span[text()='Public']"));
    driver.executeScript("arguments[0].click();", publicOption);
    
    driver.findElement(By.xpath("(//button[text()='Save'])[2]")).click();
    
    String name = driver.findElement(By.xpath("//lightning-formatted-text[text()='Mathi']")).getText();
    System.out.println("Account name for sales : "  + name);
    
    if(name.equals("Mathi")) {
    	System.out.println("Account is verified");
    }
    else {
    	System.out.println("Account is not verified");
    }
	}
}
