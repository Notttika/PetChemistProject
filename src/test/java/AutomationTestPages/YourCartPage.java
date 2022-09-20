package AutomationTestPages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class YourCartPage {
    private WebDriver driver;

    public YourCartPage (WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(css = "a[class=\'button button--primary rca-checkout-button\']")
    private WebElement buttonCheckOut;
    //@FindBy(css = "a[class=\"no-thanks\"]")
    //@FindBy(how = How.XPATH,using = "//a[contains(.,'No Thanks')]")
    @FindBy(how = How.XPATH,using = "//div[@class=\'actions-container\'] /descendant::a[1]")
    private WebElement buttonNoThanks;
    //By buttonNoThanks = By.xpath("//a[contains(.,'No Thanks')]");
    @FindBy(css = "div[class=\"upsell-content\"]")
    private WebElement banner;
    @Step("Choose payment type")
    public YourCartPage clickButtonCheckOut(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(5000L));
        wait.until(ExpectedConditions.elementToBeClickable(buttonCheckOut)).click();

        return this;
    }
    @Step("Open action banner")
    public YourCartPage openBanner()  {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(100000L));
        wait.until(ExpectedConditions.elementToBeClickable(banner)).isDisplayed();
        Actions actions = new Actions(driver);
        actions.moveToElement(banner).click().perform();
        return this;
    }
    @Step("Skip action banner")
    public YourCartPage clickButtonNoThanks()  {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(1000L));
        wait.until(ExpectedConditions.elementToBeClickable(buttonNoThanks)).click();
        return this;
    }

}
