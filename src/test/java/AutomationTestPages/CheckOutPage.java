package AutomationTestPages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

        //@FindBy(how = How.XPATH,using = "//div[@class=\'form-checklist-header form-checklist-header--selected\'] /descendant::span[1]")
        @FindBy(how = How.XPATH,using = "//ul[@class=\"form-checklist optimizedCheckout-form-checklist\"] /descendant::div[1]")
        private WebElement radioButtonShippingMethod;
        @FindBy(css = "button[id=\'checkout-shipping-continue\']")
        private WebElement buttonContinuum;
        @FindBy(id = "\'credit-card-number\'")
        private WebElement creditCardNumberInput;
        @FindBy(id = "\'expiration\']")
        private WebElement expirationInput;
        @FindBy(id = "braintree-ccName")
        private WebElement nameOnCardInput;
        @FindBy(id = "cvv")
        private WebElement cvvCardInput;
        @FindBy(id = "terms")
        private WebElement checkBoxTermAndCondition;
        @FindBy(id = "checkout-payment-continue")
        private WebElement ButtonPlaceOrder;

    @Step("Choice a shipping method")
    public CheckOutPage clickRadioButtonShippingMethod(){
       // ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true)", radioButtonShippingMethod);
        //((JavascriptExecutor) driver).executeScript("arguments[0].click()", radioButtonShippingMethod);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(10000L));
        wait.until(ExpectedConditions.elementToBeClickable(radioButtonShippingMethod)).click();
        return this;
    }
    @Step("Confirmation of order information")
    public CheckOutPage clickButtonContinuum(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(1000L));
        wait.until(ExpectedConditions.elementToBeClickable(buttonContinuum)).click();
        return this;
    }
    @Step ("Set credit card number in field ‘Credit card number’")
    public CheckOutPage setCreditCardNumber(String Text){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(500L));
        wait.until(ExpectedConditions.elementToBeClickable(creditCardNumberInput)).sendKeys(Text);
        return this;
    }
    @Step("Set expiration credit card  in the field ‘Expiration’")
    public CheckOutPage setExpiration (String Text){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(500L));
        wait.until(ExpectedConditions.elementToBeClickable(expirationInput)).sendKeys(Text);
        return this;
    }
    @Step("Set name on card in the field ‘Name on card’")
    public CheckOutPage setNameOnCard (String Text){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(500L));
        wait.until(ExpectedConditions.elementToBeClickable(nameOnCardInput)).sendKeys(Text);
        return this;
    }
    @Step ("Set CVV card in the field ‘CVV’")
    public CheckOutPage setCvvCard (String Text){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(500L));
        wait.until(ExpectedConditions.elementToBeClickable(cvvCardInput)).sendKeys(Text);
        return this;
    }
    @Step ("Choice term and condition")
    public CheckOutPage clickCheckBoxTermAndCondition (){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(1000L));
        wait.until(ExpectedConditions.elementToBeClickable(checkBoxTermAndCondition)).click();
        return this;
    }
    @Step ("Confirmation of an order")
    public CheckOutPage clickButtonPlaceOrder (){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(1000L));
        wait.until(ExpectedConditions.elementToBeClickable(ButtonPlaceOrder)).click();
        return this;
    }

}
