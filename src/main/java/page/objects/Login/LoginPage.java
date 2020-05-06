package page.objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends AbstractPageObject {

    @FindBy(className = "logo")
    private WebElement pLogo;

    @FindBy(className = "first-caption")
    private WebElement titleLabel;

    @FindBy(linkText = "Sign in with Google")
    private WebElement googleSignButton;

    @FindBy(xpath = "//input[@type='email']")
    private WebElement email;

    @FindBy(xpath = "//input[@type='password]")
    private WebElement password;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement continueButton;

    @FindBy(linkText = "Forgot your password?")
    private WebElement forgotPassword;

    @FindBy(css = "p.contains('Don't have an account?')")
    private WebElement noAccountLabel;

    @FindBy(linkText = "Sign up")
    private WebElement singUp;

    public LoginPage verifyAllElementsAreDisplaying() {
        this.pLogo.isDisplayed();
        this.titleLabel.isDisplayed();
        this.googleSignButton.isDisplayed();
        this.email.isDisplayed();
        this.password.isDisplayed();
        this.continueButton.isDisplayed();
        this.forgotPassword.isDisplayed();
        this.noAccountLabel.isDisplayed();
        this.singUp.isDisplayed();
        return this;
    }

    public LoginPage fillEmail (String userEmail) {
        this.email.sendKeys(userEmail);
        return this;
    }

    public LoginPage fillPassword (String userPassword) {
        this.password.sendKeys(userPassword);
        return this;
    }

    public LoginPage login () {
        this.continueButton.click();
        return this;
    }
}
