package stepDefinitions;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.*;

public class SwagLabAddOneProduct {
    WebDriver driver = null;

    @Given("User has opened Swag Labs on the browser add product functionality")
    public void user_has_opened_swag_labs_on_the_browser_add_product_functionality() {
        System.setProperty("webdriver.chrome.driver","D:\\QA\\eclipse-project\\Batch1DemoSelenium\\src\\test\\resources\\Drivers\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
        driver.manage().window().maximize();
    }

    @Given("User has navigated to Swag Labs URL add product functionality")
    public void user_has_navigated_to_swag_labs_url_add_product_functionality() {
        driver.get("https://www.saucedemo.com/");
    }

    @When("^User enter valid (.*) and (.*) add product functionality$")
    public void user_enter_valid_username_and_password_add_product_functionality(String username, String password) {
        driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/form[1]/div[1]/input[1]")).sendKeys(username);
        driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/form[1]/div[2]/input[1]")).sendKeys(password);
    }

    @When("User click the login button on valid case add product functionality")
    public void user_click_the_login_button_on_valid_case_add_product_functionality() {
        driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/form[1]/input[1]")).click();
    }

    @Then("Showing Swag Labs title at the top of the page add product functionality")
    public void showing_swag_labs_title_at_the_top_of_the_page_add_product_functionality() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]")));

            System.out.println("Element is displayed: true");
        } catch (Exception e) {
            System.out.println("Element is not displayed: false");
        }
    }

    @When("User clicks the Add to Cart button on the inventory page add product functionality")
    public void user_clicks_the_add_to_cart_button_on_the_inventory_page_add_product_functionality() {
        driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/button[1]")).click();
    }

    @Then("User should see the added product in the cart page with the corresponding details add product functionality")
    public void user_should_see_the_added_product_in_the_cart_page_with_the_corresponding_details_add_product_functionality() {
        WebElement addedProductRedDotResult = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/a[1]/span[1]"));
        String addedProductRedDotActualResult = addedProductRedDotResult.getText();
        Assert.assertEquals("Expected product count", "1", addedProductRedDotActualResult);
    }

    @When("User clicks the cart icon on the inventory page add product functionality")
    public void user_clicks_the_cart_icon_on_the_inventory_page_add_product_functionality() {
        driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/a[1]")).click();
    }

    @Then("User will be redirected to the cart page add product functionality")
    public void user_will_be_redirected_to_the_cart_page_add_product_functionality() {
        String currentUrl = driver.getCurrentUrl();
        String expectedUrl = "https://www.saucedemo.com/cart.html";
        Assert.assertEquals(expectedUrl, currentUrl);
    }

    @Then("User should see the details of the previously added product, including the product name, product description, and product price add product functionality")
    public void user_should_see_the_details_of_the_previously_added_product_including_the_product_name_product_description_and_product_price_add_product_functionality() {
        WebElement productName = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[3]/div[2]/a[1]/div[1]"));
        WebElement productDescription = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[3]/div[2]/div[1]"));
        WebElement productPrice = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[3]/div[2]/div[2]/div[1]"));

        String productNameResult = productName.getText();
        String productDescriptionResult = productDescription.getText();
        String productPriceResult = productPrice.getText();

        Assert.assertEquals("Expected product name", "Sauce Labs Backpack", productNameResult);
        Assert.assertEquals("Expected product description", "carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection.", productDescriptionResult);
        Assert.assertEquals("Expected product price", "$29.99", productPriceResult);

        driver.close();
        driver.quit();
    }
}
