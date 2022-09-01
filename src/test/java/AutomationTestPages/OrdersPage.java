package AutomationTestPages;

import io.qameta.allure.Step;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OrdersPage {

    private WebDriver driver;

    public OrdersPage(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(css = "div[class='navUser-action navUser-action--quickSearch'] input[id='search_query']")
    private WebElement textInput;

    @Step("Set a product in search field")
    public OrdersPage setProductSearchField (String Text){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(500L));
        wait.until(ExpectedConditions.elementToBeClickable(textInput)).sendKeys(Text);
        return this;
    }

    @ Step ("Choice a product in the list in search field")
    public OrdersPage clickProduct (){
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        WebElement product = (WebElement) jse.executeScript("return document.querySelector(\"body > div:nth-child(32)\").shadowRoot.querySelector(\"#fast-autocomplete-1234 > div.autocomplete-inner.fs-ac-18tmxq9 > div.fs-product-list.fs-ac-qv7t18 > div > a:nth-child(1)\")");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(500L));
        wait.until(ExpectedConditions.elementToBeClickable(product)).click();
        return this;

    }


}
