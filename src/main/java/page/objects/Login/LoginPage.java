/*
 * created by bkaratepe at 20/05/04
 */

package page.objects.Login;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import page.objects.AbstractPageObject;

public class LoginPage extends AbstractPageObject {

    @FindBy(className = "logo")
    private WebElement pLogo;

    @FindBy(className = "first-caption")
    private WebElement titleLabel;

    @FindBy(linkText = "Sign in with Google")
    private WebElement googleSignButton;

    @FindBy(xpath = "//input[@type='email']")
    private WebElement email;

    @FindBy(xpath = "//input[@type='password']")
    private WebElement password;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement continueButton;

    @FindBy(linkText = "Forgot your password?")
    private WebElement forgotPassword;

    @FindBy(xpath = "//p[contains(text(),'have an account?')]")
    private WebElement noAccountLabel;

    @FindBy(linkText = "Sign up")
    private WebElement singUp;

    public boolean verifyAllElementsAreDisplaying() {
        if (email.isDisplayed()
        || password.isDisplayed()
        || continueButton.isDisplayed())
            return true;
        return false;
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
