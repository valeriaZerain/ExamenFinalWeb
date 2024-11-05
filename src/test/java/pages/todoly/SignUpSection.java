package pages.todoly;

import controls.Button;
import controls.TextBox;
import org.openqa.selenium.By;

public class SignUpSection {
    public TextBox fullName = new TextBox(By.id("ctl00_MainContent_SignupControl1_TextBoxFullName"));
    public TextBox email = new TextBox(By.id("ctl00_MainContent_SignupControl1_TextBoxEmail"));
    public TextBox password = new TextBox(By.id("ctl00_MainContent_SignupControl1_TextBoxPassword"));
    public Button checkBoxTerms = new Button(By.id("ctl00_MainContent_SignupControl1_CheckBoxTerms"));
    public Button signUp = new Button(By.id("ctl00_MainContent_SignupControl1_ButtonSignup"));
}
