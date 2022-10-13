package AutomationTestPages;

import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class CheckOutPage {
        private WebDriver driver;

    public CheckOutPage (WebDriver driver) {
        this.driver = driver;
    }
        By radioButtonShippingMethod = By.xpath("//ul[@class=\"form-checklist optimizedCheckout-form-checklist\"] /descendant::li[1]");
        By buttonContinuum = By.cssSelector("button[id='checkout-shipping-continue'][type='submit']");
       // @FindBy(id = "credit-card-number")
       // private WebElement creditCardNumberInput;
        By creditCardNumberInput = By.id("credit-card-number");
       // @FindBy(id = "braintree-hosted-field-number")
        @FindBy(css = "iframe[id='braintree-hosted-field-number'][name='braintree-hosted-field-number']")
        private WebElement iframeCreditCardNumber;
        @FindBy(id = "braintree-hosted-field-expirationDate")
        private WebElement iframeExpiration;
        @FindBy(id = "braintree-hosted-field-cvv")
        private WebElement iframeCVV;
        @FindBy(id = "expiration")
        private WebElement expirationInput;
        @FindBy(how = How.XPATH,using = "//div[@id=\"braintree-ccName\"]/input")
        private WebElement nameOnCardInput;
        @FindBy(id = "cvv")
        private WebElement cvvCardInput;
        @FindBy(id = "terms")
        private WebElement checkBoxTermAndCondition;
        @FindBy(id = "checkout-payment-continue")
        private WebElement ButtonPlaceOrder;


    @Step("Choice a shipping method")
    public void  clickRadioButtonShippingMethod() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(100000L));
        wait.until(ExpectedConditions.visibilityOfElementLocated(radioButtonShippingMethod));
        WebElement element = driver.findElement(radioButtonShippingMethod);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().perform();
    }
    @Step("Confirmation of order information")
    public CheckOutPage clickButtonContinuum() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(100000L));
        wait.until(ExpectedConditions.visibilityOfElementLocated(buttonContinuum));
        WebElement element = driver.findElement(buttonContinuum);
        element.submit();
       return this;
    }

    @Step ("Set credit card number in field ‘Credit card number’")
    public CheckOutPage setCreditCardNumber(String Text){


        // driver.switchTo().frame(iframeCreditCardNumber);
       // WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(10000L));
       // wait.until(ExpectedConditions.visibilityOfElementLocated(creditCardNumberInput));
       // WebElement element = driver.findElement(creditCardNumberInput);
       // element.sendKeys(Text);
       // driver.switchTo().defaultContent();

        //driver.switchTo().frame(iframeCreditCardNumber);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(10000L));
        wait.until(ExpectedConditions.elementToBeClickable(creditCardNumberInput)).sendKeys(Text);
        driver.switchTo().defaultContent();
        return this;
    }
    @Step("Set expiration credit card  in the field ‘Expiration’")
    public CheckOutPage setExpiration (String Text){
        driver.switchTo().frame(iframeExpiration);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(5000L));
        wait.until(ExpectedConditions.elementToBeClickable(expirationInput)).sendKeys(Text);
        driver.switchTo().defaultContent();
        return this;
    }
    @Step("Set name on card in the field ‘Name on card’")
    public CheckOutPage setNameOnCard (String Text){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(5000L));
        wait.until(ExpectedConditions.elementToBeClickable(nameOnCardInput)).sendKeys(Text);
        return this;
    }
    @Step ("Set CVV card in the field ‘CVV’")
    public CheckOutPage setCvvCard (String Text){
        driver.switchTo().frame(iframeCVV);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(5000L));
        wait.until(ExpectedConditions.elementToBeClickable(cvvCardInput)).sendKeys(Text);
        driver.switchTo().defaultContent();
        return this;
    }
    @Step ("Choice term and condition")
    public CheckOutPage clickCheckBoxTermAndCondition (){
        ((JavascriptExecutor) driver).executeScript("arguments[0].checked = true;",checkBoxTermAndCondition);
        //WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(5000L));
        //wait.until(ExpectedConditions.elementToBeClickable(checkBoxTermAndCondition)).submit();
        return this;
    }
    @Step ("Confirmation of an order")
    public CheckOutPage clickButtonPlaceOrder (){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(5000L));
        wait.until(ExpectedConditions.elementToBeClickable(ButtonPlaceOrder)).click();
        return this;
    }

}
