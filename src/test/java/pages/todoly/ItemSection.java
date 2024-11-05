package pages.todoly;

import controls.Button;
import controls.Label;
import controls.TextBox;
import org.openqa.selenium.By;

public class ItemSection {
    public TextBox createItemTextBox = new TextBox(By.id("NewItemContentInput"));
    public Button createItemButton = new Button(By.id("NewItemAddButton"));

    public Label getItemLabel(String name){
        Label itemLabel = new Label(By.xpath("//ul[@id='mainItemList']/li[last()]/td[contains(@class, 'ItemContent')]//div[text()='" + name + "']"));
        return itemLabel;
    }
}
