package steps;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinition {
	
	public ChromeDriver driver;
	
	@Given("launch the Browser and launch the url")
	public void launch_the_browser_and_launch_the_url() {

		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.get("https://login.salesforce.com");
	}

	@When("Enter the Username as dilip@testleaf.com")
	public void enter_the_username_as_dilip_testleaf_com() {
		driver.findElement(By.id("username")).sendKeys("dilip@testleaf.com");
	}

	@When("Enter the Password as testleaf@{int}")
	public void enter_the_password_as_testleaf(Integer int1) {
		 driver.findElement(By.id("password")).sendKeys("testleaf@2024");
	}
    
	@When("Click on LoginButton")
	public void click_on_login_button() {
		driver.findElement(By.id("Login")).click();
	}
	
	@When("Click on toggle menu button from the left corner")
	public void click_on_toggle_menu_button_from_the_left_corner() throws InterruptedException {
		 Thread.sleep(3000);
		  driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
	}

	@When("Click view All")
	public void click_view_all() {
		driver.findElement(By.xpath("(//button[@class='slds-button'])[2]")).click();
	}

	@When("click Sales from App Launcher")
	public void click_sales_from_app_launcher() {
		 driver.findElement(By.xpath("//p[text()='Sales']")).click();
	}

	@When("Click on Accounts tab")
	public void click_on_accounts_tab() {
		  WebElement accounts = driver.findElement(By.xpath("(//span[text()='Accounts'])[1]"));
		  driver.executeScript("arguments[0].click();",accounts);
	}

	@When("Click on New button")
	public void click_on_new_button() {
		 driver.findElement(By.xpath("//div[text()='New']")).click();
	}

	@When("Enter {string} as account name")
	public void enter_as_account_name(String string) {
		WebElement accountNameField = driver.findElement(By.xpath("(//input[@class='slds-input'])[5]"));
		accountNameField.sendKeys("Mathi");
	}

	@When("Select Ownership as Public")
	public void select_ownership_as_public() throws InterruptedException {
		  Thread.sleep(3000);
			WebElement dropdownButton = driver.findElement(By.xpath("(//span[text()='--None--'])[3]"));
		    driver.executeScript("arguments[0].click();", dropdownButton);
		    
		    Thread.sleep(2000);
		    WebElement publicOption =driver.findElement(By.xpath("//span[text()='Public']"));
		    driver.executeScript("arguments[0].click();", publicOption);
	}

	@When("Click save")
	public void click_save() {
		driver.findElement(By.xpath("(//button[text()='Save'])[2]")).click();
	}

	@Then("verify Account name")
	public void verify_account_name() {
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
