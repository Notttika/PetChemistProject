package AutomationTestPages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductPage {
    private WebDriver driver;

    public ProductPage (WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(how = How.XPATH,using ="//div[@class=\'form-field rca-product-variant-options\']/descendant::label[2]")
    private WebElement buttonSizeProduct;
    @FindBy(id="form-action-addToCart")
    private WebElement buttonAddToCart;
    @FindBy(css = "a[class=\'button\'][ href=\'/cart.php\']")
    private WebElement buttonViewOrEditYourCart;

    @Step("Select size a product")
    public ProductPage clickButtonSizeProduct(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(1000L));
        wait.until(ExpectedConditions.elementToBeClickable(buttonSizeProduct)).click();
        return this;
    }

    @Step ("Add to cart")
    public ProductPage clickButtonAddToCart(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(1000L));
        wait.until(ExpectedConditions.elementToBeClickable(buttonAddToCart)).click();
        return this;
    }
    @Step ("Transition to cart")
    public ProductPage clickButtonViewOrEditYourCart(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(1000L));
        wait.until(ExpectedConditions.elementToBeClickable(buttonViewOrEditYourCart)).click();
        return this;
    }
}
