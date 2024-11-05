package testSuite;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import pages.todoly.*;
import session.Session;

public class BaseTestTodoLy {

    protected MainPage mainPage = new MainPage();
    protected LoginSection loginSection = new LoginSection();
    protected MenuSection menuSection = new MenuSection();
    protected SettingsSection settingsSection = new SettingsSection();
    protected ProjectLeftSection projectLeftSection = new ProjectLeftSection();
    protected ItemSection itemSection = new ItemSection();
    protected SignUpSection signUpSection = new SignUpSection();

    @BeforeEach
    public void openBrowser(){
        Session.getInstance().getBrowser().get("https://todo.ly/");
    }

    @AfterEach
    public void closeBrowser(){
        Session.getInstance().closeSession();
    }


}
