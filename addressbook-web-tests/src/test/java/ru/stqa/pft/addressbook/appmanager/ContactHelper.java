package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactHelper extends HelperBase {
    public ContactHelper(WebDriver wd) {
        super(wd);
    }
    public void returnToHomePage() {
      click(By.linkText("home page"));
    }

    public void submitContactCreation() {
      click(By.xpath("//div[@id='content']/form/input[21]"));
    }

    public void fillContactCreationPage(ContactData contactData, boolean creation) {
      type(By.name("firstname"), contactData.getFirstname());
      type(By.name("lastname"), contactData.getLastname());
      type(By.name("address"), contactData.getAddress());
      type(By.name("home"), contactData.getHomenumber());
      type(By.name("mobile"), contactData.getMobilenumber());
      type(By.name("email"), contactData.getFirstemail());
      type(By.name("email2"), contactData.getSecondemail());
      
      if (creation) {
          new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
          //new Select(wd.findElement(By.name("new_group"))).selectByIndex(1);
      } else {
          Assert.assertFalse(isElementPresent(By.name("new_group")));
      }
    }

    public void initContactModification() {
        click(By.xpath("//img[@alt='Edit']"));
    }

    public void submitContactModification() {
        click(By.xpath("//input[22]"));
    }

    public void selectContact() {
        click(By.name("selected[]"));
    }

    public void deleteSelectedContact() {
        click(By.xpath("//input[@value='Delete']"));
    }

    public void createContact(ContactData contact, boolean creation) {
        goToContactCreationPage();
        fillContactCreationPage(contact, creation);
        submitContactCreation();
        returnToHomePage();
    }

    public void goToContactCreationPage() {
        wd.findElement(By.linkText("add new")).click();
    }

    public boolean isThereAContact() {
        return isElementPresent(By.name("selected[]"));
    }
}
