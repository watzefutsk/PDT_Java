package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;

public class ApplicationManager {

    EdgeDriver wd;
    private ContactHelper contactHelper;
    private SessionHelper sessionHelper;
    private NavigatioHelper navigatioHelper;
    private GroupHelper groupHelper;

    public void init() {
        wd = new EdgeDriver();
        wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        wd.get("http://localhost/addressbook/");
        groupHelper = new GroupHelper(wd);
        navigatioHelper = new NavigatioHelper(wd);
        sessionHelper = new SessionHelper(wd);
        sessionHelper.login("admin", "secret");
        contactHelper = new ContactHelper(wd);
    }



    public void logout() {
      wd.findElement(By.linkText("Logout")).click();
    }

    public void stop() {
        logout();
        wd.quit();
    }

    public GroupHelper getGroupHelper() {
        return groupHelper;
    }

    public NavigatioHelper getNavigatioHelper() {
        return navigatioHelper;
    }

    public void goToContactCreationPage() {
      wd.findElement(By.linkText("add new")).click();
    }

    public ContactHelper getContactHelper() {
        return contactHelper;
    }
}
