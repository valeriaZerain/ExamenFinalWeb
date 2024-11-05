package testSuite;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import session.Session;

public class ChangeEmailTest extends BaseTestTodoLy{
    @Test
    public void changeEmailTest() throws InterruptedException {
        //Create a user
        mainPage.signInButton.click();
        signUpSection.email.setText("Hola@1.com");
        signUpSection.fullName.setText("Hola");
        signUpSection.password.setText("password");
        signUpSection.checkBoxTerms.click();
        signUpSection.signUp.click();

        //Change email
        menuSection.settingsButton.click();
        settingsSection.emailTextBox.clearSetText("Hola@2.com");
        settingsSection.okButton.click();

        Session.getInstance().getBrowser().get("https://todo.ly/");
    }
}
