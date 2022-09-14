package AutomationTestPages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
    @FindBy(how = How.XPATH,using = "//div[@class=\'actions-container\'] /descendant::a[1]")
    private WebElement buttonNoThanks;

    @Step("Choose payment type")
    public YourCartPage clickButtonCheckOut(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(1000L));
        wait.until(ExpectedConditions.elementToBeClickable(buttonCheckOut)).click();
        return this;
    }
    @Step("Skip action banner")
    public YourCartPage clickButtonNoThanks(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(2000L));
        wait.until(ExpectedConditions.elementToBeClickable(buttonNoThanks)).click();
        return this;
    }

}
