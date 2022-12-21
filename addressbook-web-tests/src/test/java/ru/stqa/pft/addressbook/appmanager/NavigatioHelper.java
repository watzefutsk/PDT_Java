package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class NavigatioHelper extends HelperBase {

    public NavigatioHelper(WebDriver wd) {
        super(wd);
    }
    public void goToGroupPage() {
        click(By.linkText("groups"));
    }

    public void goToContactCreationPage() {
      wd.findElement(By.linkText("add new")).click();
    }
}
