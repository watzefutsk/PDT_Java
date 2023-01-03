package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class NavigatioHelper extends HelperBase {

    public NavigatioHelper(WebDriver wd) {
        super(wd);
    }
    public void goToGroupPage() {
        if (isElementPresent(By.tagName("h1")) && wd.findElement(By.tagName("h1")).getText().equals("Groups") && isElementPresent(By.name("new"))) {
            return;
        }
        click(By.linkText("groups"));
    }

    public void goToContactCreationPage() {
        if (isElementPresent(By.tagName("h1")) && wd.findElement(By.tagName("h1")).getText().equals("Edit / add address book entry") && isElementPresent(By.name("submit"))) {
            return;
        }
      wd.findElement(By.linkText("add new")).click();
    }
}
