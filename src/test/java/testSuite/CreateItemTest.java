package testSuite;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Date;

public class CreateItemTest extends BaseTestTodoLy {
    @Test
    public void createItemSuccessfully(){
        String projectName = "Project"+new Date().getTime();
        mainPage.loginButton.click();
        loginSection.login("valeria.zerain@gmail.com","Pruebas123");
        projectLeftSection.createProject(projectName);

        String itemName = "Item"+new Date().getTime();
        itemSection.createItemTextBox.clearSetText(itemName);
        itemSection.createItemButton.click();
        Assertions.assertEquals(itemName,projectLeftSection.getProjectLabel(itemName).getText(),
                "ERROR the item was not created");
    }
}
