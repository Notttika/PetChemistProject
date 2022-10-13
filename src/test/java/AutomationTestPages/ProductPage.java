package AutomationTestPages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class ProductPage {
    private WebDriver driver;

    public ProductPage (WebDriver driver) {
        this.driver = driver;
    }

    By buttonSizeProduct = By.xpath("//div[@class='form-field rca-product-variant-options']/descendant::label[2]");
    By buttonPackProduct = By.xpath("//label[@class='form-option' and @for='attribute_rectangle_1907']");
    By buttonAddToCart = By.id("form-action-addToCart");
    By buttonViewOrEditYourCart= By.cssSelector("a[class='button'][ href='/cart.php']");

    @Step("Select size a product")
    public ProductPage clickButtonSizeProduct(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(10000L));
        wait.until(ExpectedConditions.visibilityOfElementLocated(buttonSizeProduct));
        WebElement element = driver.findElement(buttonSizeProduct);
        element.click();
        return this;
    }
    @Step("Select quantity a product")
    public ProductPage clickButtonPackProduct(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(5000L));
        wait.until(ExpectedConditions.visibilityOfElementLocated(buttonPackProduct));
        WebElement element = driver.findElement(buttonPackProduct);
        element.click();
        return this;
    }
    @Step ("Add to cart")
    public ProductPage clickButtonAddToCart(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(5000L));
        wait.until(ExpectedConditions.visibilityOfElementLocated(buttonAddToCart));
        WebElement element = driver.findElement(buttonAddToCart);
        element.click();
        return this;
    }
    @Step ("Transition to cart")
    public ProductPage clickButtonViewOrEditYourCart(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(5000L));
        wait.until(ExpectedConditions.visibilityOfElementLocated(buttonViewOrEditYourCart));
        WebElement element = driver.findElement(buttonViewOrEditYourCart);
        element.click();
        return this;
    }
}
