package stepDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.And;
import cucumber.api.junit.Cucumber;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


public class first {

	WebDriver driver;
    @Given("^user is on homepage$")
    public void user_is_on_homepage() throws Throwable {
    	System.setProperty("webdriver.chrome.driver", "C:\\Users\\848652\\workspace\\ANZCucumber\\src\\test\\java\\Driver\\chromedriver.exe");
		driver= new ChromeDriver();
		driver.get("https://www.anz.com.au/personal/home-loans/calculators-tools/much-borrow/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
    }
    
    @Then("^user verify title of the homepage$")
    public void user_verify_title_of_the_homepage() {
    	String actualTitle= driver.getTitle();
	    String expectedTitle= "Home loan borrowing power calculator | ANZ";
	    Assert.assertEquals(expectedTitle, actualTitle);
    }

    @Then("^user fills application type as single$")
    public void user_fills_application_type_as_single() throws Throwable {
    	WebElement single= driver.findElement(By.xpath("//label[@for='application_type_single']"));
	    single.click();
	    System.out.println("Single is selected");
	    
    }

    @Then("^user fills no of dependents as zero$")
    public void user_fills_no_of_dependents_as_zero() throws Throwable {
    WebElement dependents = driver.findElement(By.xpath("//select[@title='Number of dependants']"));
	    
	    Select sel= new Select(dependents);
	    sel.selectByVisibleText("0");
	    try
	    	{
	    		Thread.sleep(3000);
	    	}
	    	catch(InterruptedException e)
	    	{
	    		e.printStackTrace();
	    	}
	    System.out.println("Entered dependents as 0");
    }

    @Then("^user fills property you want to buy$")
    public void user_fills_property_you_want_to_buy() throws Throwable {
    	WebElement h= driver.findElement(By.xpath("//label[@for='borrow_type_home']"));
 	    h.click();
 	    System.out.println("Hi,home to live in is clicked");
    }
    

    @Then("^user fills your income$")
    public void user_fills_your_income() throws Throwable {
    	WebElement i1= driver.findElement(By.xpath("//input[@aria-labelledby='q2q1']"));
	    i1.sendKeys("80000");
	    System.out.println("80000 enetred in your income box");
    }

    @Then("^user fills your other income$")
    public void user_fills_your_other_income() throws Throwable {
    	WebElement i2= driver.findElement(By.xpath("//input[@aria-labelledby='q2q2']"));
 	   i2.sendKeys("10000");
 	   System.out.println("10000 entered in other income box");
    }

    @Then("^user fills living expenses$")
    public void user_fills_living_expenses() throws Throwable {
    	WebElement i3= driver.findElement(By.xpath("//input[@id='expenses']"));
		i3.sendKeys("500");
		System.out.println("500 entered in living expenses box");
    }

    @Then("^user fills current home loan repayments$")
    public void user_fills_current_home_loan_repayments() throws Throwable {
    	WebElement i4= driver.findElement(By.xpath("//input[@id='homeloans']"));
	    i4.sendKeys("0");
	    System.out.println("0 entered in current home loan repayments box");
    }

    @Then("^user fills other loan repayments$")
    public void user_fills_other_loan_repayments() throws Throwable {
    	WebElement i5= driver.findElement(By.xpath("//input[@id='otherloans']"));
	    i5.sendKeys("100");
	    System.out.println("100 entered in other loan repayments box");
    }

    @Then("^user fills other commitments$")
    public void user_fills_other_commitments() throws Throwable {
    	WebElement i6= driver.findElement(By.xpath("//input[@aria-labelledby='q3q4']"));
	    i6.sendKeys("0");
	    System.out.println("0 entered in other commitments box");
    }

    @Then("^user fills credit card limits$")
    public void user_fills_credit_card_limits() throws Throwable {
    	WebElement i7= driver.findElement(By.xpath("//input[@aria-labelledby='q3q5']"));
	    i7.sendKeys("10000");
	    System.out.println("10000 entered in credit card limitsbox");
    }

    @And("^user clicks on work out how much i could borrow button$")
    public void user_clicks_on_work_out_how_much_i_could_borrow_button() throws Throwable {
    	WebElement btn= driver.findElement(By.xpath("//button[@id='btnBorrowCalculater']"));
	    btn.click();
	    System.out.println("Work out how much i can borrow button clicked");
	    //int actual=479000;
	    //WebElement get= driver.findElement(By.xpath("//span[@id='borrowResultTextAmount']"));
	    //String x= get.getText();  //have doubt in this
	    //int expected = Integer.parseInt(x);
	    //Assert.assertEquals(expected, actual);
    }

    @Then("^user clicks on start over button$")
    public void user_clicks_on_start_over_button() throws Throwable {
	 WebElement s= driver.findElement(By.xpath("//button[@class='start-over' and @role='button']"));
	 s.click();
	 System.out.println("Form is cleared");
    }
    @Then("^user enters living expenses and leaves everything blank$")
    public void user_enters_living_expenses_and_leaves_everything_blank() throws Throwable 
	{
		WebElement living= driver.findElement(By.xpath("//input[@id='expenses']"));
		living.sendKeys("1");
		Thread.sleep(2000);
		System.out.println("1 entered in living expenses box");
		
		
		WebElement btn2= driver.findElement(By.id("btnBorrowCalculater"));
		JavascriptExecutor jse2 = (JavascriptExecutor)driver;
		jse2.executeScript("arguments[0].scrollIntoView()", btn2);
		jse2.executeScript("arguments[0].click();", btn2); 
		//btn2.click();
		 
		 System.out.println("Work out how much i can borrow button clicked");
    }
	 @And("^display message on the screen$")
	    public void display_message_on_the_screen() throws Throwable {
		 String actual= "Based on the details you've entered, we're unable to give you an estimate of your borrowing power with this calculator. For questions, call us on 1800 035 500.";
		   
		   WebElement mess= driver.findElement(By.xpath("//span[@class='borrow__error__text' and @aria-live='assertive']"));
		   String expected= mess.getText();
		   Assert.assertEquals(expected, actual);
	 }
}