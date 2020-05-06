package test;

import org.testng.annotations.Test;
import page.objects.Login.LoginPage;

public class VerifyLoginTest extends BaseWeb {

    @Test(description = "Verfifies Login Page Functionality")
    public void verifyLogin() throws InterruptedException {
        LoginPage loginPage = new LoginPage();
        if (!loginPage.verifyAllElementsAreDisplaying())
            return;
        loginPage.fillEmail("email")
                .fillPassword("***");
        Thread.sleep(1500);
    }
}
