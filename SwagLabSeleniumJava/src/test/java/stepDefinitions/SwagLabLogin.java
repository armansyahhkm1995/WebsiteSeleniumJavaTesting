package stepDefinitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.*;

public class SwagLabLogin {
	 WebDriver driver = null;

	    @Given("User has opened Swag Labs on the browser login functionality")
	    public void user_has_opened_swag_labs_on_the_browser_login_functionality() {
	        System.setProperty("webdriver.chrome.driver","D:\\QA\\eclipse-project\\Batch1DemoSelenium\\src\\test\\resources\\Drivers\\chromedriver.exe");
	        ChromeOptions options = new ChromeOptions();
	        options.addArguments("--remote-allow-origins=*");
	        driver = new ChromeDriver(options);
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
	        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
	        driver.manage().window().maximize();
	    }
	    
	    @Given("User has navigated to Swag Labs URL login functionality")
	    public void user_has_navigated_to_swag_labs_url_login_functionality() {
	        driver.get("https://www.saucedemo.com/");
	    }
  //TCID001

    @When("^User enter valid (.*) and (.*) login functionality$")
    public void user_enter_valid_username_and_password_login_functionality(String username, String password) {
    	driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/form[1]/div[1]/input[1]")).sendKeys(username);
		driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/form[1]/div[2]/input[1]")).sendKeys(password);
    }

    @When("User click the login button on valid case login functionality")
    public void user_click_the_login_button_on_valid_case_login_functionality() {
    	driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/form[1]/input[1]")).click();
    }

    @Then("Showing Swag Labs title at the top of the page login functionality")
    public void showing_swag_labs_title_at_the_top_of_the_page_login_functionality() throws InterruptedException {
    	 try {
    	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]")));

    	        System.out.println("Element is displayed: true");
    	    } catch (Exception e) {
    	        System.out.println("Element is not displayed: false");
    	    }
    	driver.close();
    	driver.quit();
    }
    
  //TCID002

    @When("^User enter invalid (.*) and (.*) login functionality$")
    public void user_enter_invalid_username_and_password_login_functionality(String username, String password) {
    	driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/form[1]/div[1]/input[1]")).sendKeys(username);
		driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/form[1]/div[2]/input[1]")).sendKeys(password);
    }

    @When("User click the login button on invalid case login functionality")
    public void user_click_the_login_button_on_invalid_case_login_functionality() {
    	driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/form[1]/input[1]")).click();
    }

    @Then("Showing Epic sadface: Sorry, this user has been locked out login functionality")
    public void showing_epic_sadface_sorry_this_user_has_been_locked_out_login_functionality() throws InterruptedException {
    	try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[contains(text(),'Epic sadface: Sorry, this user has been locked out')]")));

            System.out.println("Element is displayed: true");
        } catch (Exception e) {
            System.out.println("Element is not displayed: false");
        }
		driver.close();
		driver.quit();
    }
    
  //TCID003

    @When("^User enter problem (.*) and (.*) login functionality$")
    public void user_enter_problem_username_and_password_login_functionality(String username, String password) {
    	driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/form[1]/div[1]/input[1]")).sendKeys(username);
		driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/form[1]/div[2]/input[1]")).sendKeys(password);
    }

    @When("User click the login button on problem case login functionality")
    public void user_click_the_login_button_on_problem_case_login_functionality() {
    	driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/form[1]/input[1]")).click();
    }

    @Then("The image is not show-up login functionality")
    public void the_image_is_not_show_up_login_functionality() throws InterruptedException {
    	 try {
    	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    	        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/a[1]/img[1]")));

    	        System.out.println("Image is not displayed: true");
    	    } catch (Exception e) {
    	        System.out.println("Image is displayed: false");
    	    }
        driver.close();
        driver.quit();
    }
}
