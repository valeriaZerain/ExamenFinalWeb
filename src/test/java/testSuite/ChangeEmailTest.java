package testSuite;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ChangeEmailTest extends BaseTestTodoLy{
    @Test
    public void changeEmailTest() throws InterruptedException {
        //Create a user
        mainPage.signInButton.click();
        signUpSection.email.setText("Hola@123.com");
        signUpSection.fullName.setText("Hola");
        signUpSection.password.setText("password");
        signUpSection.checkBoxTerms.click();
        signUpSection.signUp.click();
        Thread.sleep(3000);
        Assertions.assertTrue(menuSection.logoutButton.isControlDislayed(), "ERROR! the signup was failed");
    }
}
