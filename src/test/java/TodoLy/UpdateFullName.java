package TodoLy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.todoly.MenuSection;
import pages.todoly.SettingsSection;
import testSuite.BaseTestTodoLy;

public class UpdateFullName extends BaseTestTodoLy {

    MenuSection menuSection = new MenuSection();
    SettingsSection settingsSection = new SettingsSection();

    @Test
    public void verifyUpdateFullName() throws InterruptedException {
        mainPage.loginButton.click();
        loginSection.login("valeria.zerain@gmail.com","Pruebas123");
        String name = "Valeria Zerain Rivera";
        menuSection.settingsButton.click();
        settingsSection.fullNameTextbox.clearSetText(name);
        settingsSection.okButton.click();
        Thread.sleep(10000);
        menuSection.settingsButton.click();
        Thread.sleep(5000);
        String actualResult = settingsSection.fullNameTextbox.getText();
        Assertions.assertEquals(name,actualResult,
                "ERROR the Full Name was not updated");
    }
}
