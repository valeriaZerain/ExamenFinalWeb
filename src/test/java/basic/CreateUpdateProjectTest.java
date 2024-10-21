package basic;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Date;

public class CreateUpdateProjectTest {

    WebDriver chrome;
    @BeforeEach
    public void openBrowser(){
        System.setProperty("webdriver.chrome.driver","src/test/resources/chrome/chromedriver.exe");
        chrome = new ChromeDriver();
        chrome.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        chrome.manage().window().maximize();
        chrome.get("https://todo.ly/");
    }

    @AfterEach
    public void closeBrowser(){
        chrome.quit();
    }



    @Test
    @DisplayName("Verify create update project")
    public void verifyCreateUpdateProject() throws InterruptedException {
        chrome.findElement(By.xpath("//img[@src=\"/Images/design/pagelogin.png\"]")).click();
        chrome.findElement(By.id("ctl00_MainContent_LoginControl1_TextBoxEmail")).sendKeys("selenium123@123.com");
        chrome.findElement(By.id("ctl00_MainContent_LoginControl1_TextBoxPassword")).sendKeys("12345");
        chrome.findElement(By.id("ctl00_MainContent_LoginControl1_ButtonLogin")).click();
        // verification
        Assertions.assertTrue(chrome.findElements(By.id("ctl00_HeaderTopControl1_LinkButtonLogout")).size() ==1,
                "ERROR! nose pudo iniciar sesion");


        // create project
        // click add new project
        String nameProject = "UPB"+new Date().getTime();
        chrome.findElement(By.xpath("//td[text()='Add New Project']")).click();
        // set project name
        chrome.findElement(By.id("NewProjNameInput")).sendKeys(nameProject);
        // click add
        chrome.findElement(By.id("NewProjNameButton")).click();

        // verification
        String expectedResult=nameProject;
        String actualResult=chrome.findElement(By.xpath("//li[last()]//td[text()='"+nameProject+"'] ")).getText();
        Assertions.assertEquals(expectedResult,actualResult,"ERROR the project was not created successfully");

        // update project
        //select project created
        chrome.findElement(By.xpath("//li[last()]//td[text()='"+nameProject+"'] ")).click();
        // click menu icon
        chrome.findElement(By.xpath("//div[@style=\"display: block;\"]/img")).click();
        // click  [edit]
        chrome.findElement(By.xpath("//ul[contains(@style,\"block;\")]//a[text()='Edit']")).click();
        // set new project name
        String nameProjectUpdated = "BOL"+new Date().getTime();
        chrome.findElement(By.xpath("//input[@id='ItemEditTextbox' and @style]")).clear();
        chrome.findElement(By.xpath("//input[@id='ItemEditTextbox' and @style]")).sendKeys(nameProjectUpdated);
        // click  [save] icon
        chrome.findElement(By.xpath("//img[@id=\"ItemEditSubmit\" and @itemid]")).click();

        // verification
        expectedResult=nameProjectUpdated;
        actualResult=chrome.findElement(By.xpath("//li[last()]//td[text()='"+nameProjectUpdated+"'] ")).getText();
        Assertions.assertEquals(expectedResult,actualResult,"ERROR the project was not created successfully");
    }
}
