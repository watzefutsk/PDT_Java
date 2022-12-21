package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactHelper {
    EdgeDriver wd;
    public ContactHelper(EdgeDriver wd) {
        this.wd = wd;
    }
    public void returnToHomePage() {
      wd.findElement(By.linkText("home page")).click();
    }

    public void submitContactCreation() {
      wd.findElement(By.xpath("//div[@id='content']/form/input[21]")).click();
    }

    public void fillContactCreationPage(ContactData contactData) {
      wd.findElement(By.name("firstname")).sendKeys(contactData.getFirstname());
      wd.findElement(By.name("lastname")).sendKeys(contactData.getLastname());
      wd.findElement(By.name("address")).sendKeys(contactData.getAddress());
      wd.findElement(By.name("home")).sendKeys(contactData.getHomenumber());
      wd.findElement(By.name("mobile")).sendKeys(contactData.getMobilenumber());
      wd.findElement(By.name("email")).sendKeys(contactData.getFirstemail());
      wd.findElement(By.name("email2")).sendKeys(contactData.getSecondemail());
    }
}
