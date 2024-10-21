package testSuiteTodoist;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LoginTest extends BaseTestTodoist{
    @Test
    public void verifyLogin(){
        mainPageTodoist.loginButton.click();
        loginPageTodoist.emailTextBox.setText("valeria.zerain@gmail.com");
        loginPageTodoist.passwordTextBox.setText("Pruebas123");
        loginPageTodoist.loginButton.click();
        Assertions.assertTrue(menuSectionTodoist.profileButton.isControlDislayed());
    }
}
