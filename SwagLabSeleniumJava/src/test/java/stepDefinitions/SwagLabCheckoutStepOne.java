package stepDefinitions;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.en.*;

public class SwagLabCheckoutStepOne {
    WebDriver driver = null;

    @Given("User opens the browser")
    public void user_opens_the_browser() {
        System.setProperty("webdriver.chrome.driver", "D:\\QA\\eclipse-project\\Batch1DemoSelenium\\src\\test\\resources\\Drivers\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
        driver.manage().window().maximize();
    }

    @Given("User navigates to the Swag Labs URL")
    public void user_navigates_to_the_swag_labs_url() {
        driver.get("https://www.saucedemo.com/");
    }

    @When("^User enters valid (.*) and (.*)$")
    public void user_enters_valid_username_and_password(String username, String password) {
        driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/form[1]/div[1]/input[1]")).sendKeys(username);
        driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/form[1]/div[2]/input[1]")).sendKeys(password);
    }

    @When("User clicks the login button")
    public void user_clicks_the_login_button() {
        driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/form[1]/input[1]")).click();
    }

    @When("User clicks the Add to Cart button on the inventory page")
    public void user_clicks_the_add_to_cart_button_on_the_inventory_page() {
        driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/button[1]")).click();
    }

    @Then("User should see the added product in the cart page with the corresponding details")
    public void user_should_see_the_added_product_in_the_cart_page_with_the_corresponding_details() {
        WebElement addedProductRedDotResult1 = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/a[1]/span[1]"));

        String addedProductRedDotACtualResult1 = addedProductRedDotResult1.getText();

        Assert.assertEquals("Expected product name", "1", addedProductRedDotACtualResult1);
    }

    @When("User clicks the cart icon on the inventory page")
    public void user_clicks_the_cart_icon_on_the_inventory_page() {
        driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/a[1]")).click();
    }

    @Then("User will be redirected to the cart page")
    public void user_will_be_redirected_to_the_cart_page() {
        String currentUrl = driver.getCurrentUrl();
        String expectedUrl = "https://www.saucedemo.com/cart.html";

        Assert.assertEquals(expectedUrl, currentUrl);
    }

    @Then("User should see the details of the previously added product, including the product name, product description, and product price")
    public void user_should_see_the_details_of_the_previously_added_product_including_the_product_name_product_description_and_product_price() {
        WebElement productName1 = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[3]/div[2]/a[1]/div[1]"));
        WebElement productDescription1 = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[3]/div[2]/div[1]"));
        WebElement productPrice1 = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[3]/div[2]/div[2]/div[1]"));

        String productNameResult1 = productName1.getText();
        String productDescriptionResult1 = productDescription1.getText();
        String productPriceResult1 = productPrice1.getText();

        Assert.assertEquals("Expected product name", "Sauce Labs Backpack", productNameResult1);
        Assert.assertEquals("Expected product name", "carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection.", productDescriptionResult1);
        Assert.assertEquals("Expected product name", "$29.99", productPriceResult1);
    }

    @When("User clicks on the checkout button")
    public void user_clicks_on_the_checkout_button() {
        driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/button[2]")).click();
    }

    @Then("User should be redirected to the checkout page")
    public void user_should_be_redirected_to_the_checkout_page() {
        String currentUrl = driver.getCurrentUrl();
        String expectedUrl = "https://www.saucedemo.com/checkout-step-one.html";

        Assert.assertEquals(expectedUrl, currentUrl);
    }

    @Then("User fills the first name form")
    public void user_fills_the_first_name_form() {
        String firstName = "Arman";
        Assert.assertFalse("Invalid first name format", firstName.matches("\\d+"));
        Assert.assertFalse("First name is empty", firstName.isEmpty());
        driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/div[1]/div[1]/input[1]")).sendKeys(firstName);
    }

    @Then("User fills the last name form")
    public void user_fills_the_last_name_form() {
        String lastName = "Hakim";
        Assert.assertFalse("Invalid last name format", lastName.matches("\\d+"));
        Assert.assertFalse("Last name is empty", lastName.isEmpty());
        driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/div[1]/div[2]/input[1]")).sendKeys(lastName);
    }

    @Then("User fills the postal code form")
    public void user_fills_the_postal_code_form() {
        String postalCode = "1234";
        Assert.assertTrue("Invalid postal code format", postalCode.matches("\\d+"));
        Assert.assertFalse("Postal code is empty", postalCode.isEmpty());
        driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/div[1]/div[3]/input[1]")).sendKeys(postalCode);
    }

    @Then("User clicks continue button")
    public void user_clicks_continue_button() {
        driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/div[2]/input[1]")).click();
    }

    @Then("User will be redirected to the checkout overview page")
    public void user_will_be_redirected_to_the_checkout_overview_page() {
        String currentUrl = driver.getCurrentUrl();
        String expectedUrl = "https://www.saucedemo.com/checkout-step-two.html";

        Assert.assertEquals(expectedUrl, currentUrl);

        driver.close();
        driver.quit();
    }
}
