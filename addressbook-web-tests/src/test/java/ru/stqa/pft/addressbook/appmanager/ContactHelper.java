package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.util.List;

public class ContactHelper extends HelperBase {
    public ContactHelper(WebDriver wd) {
        super(wd);
    }
    public void returnToHomePage() {
        //временное решение, пока не пойму как обращаться к методу homePage класса NavigationHelper
      //click(By.linkText("home page"));
      click(By.linkText("home"));
    }

    public void submitContactCreation() {
      click(By.xpath("//div[@id='content']/form/input[21]"));
    }

    public void fillContactCreationPage(ContactData contactData, boolean creation) {
      type(By.name("firstname"), contactData.getFirstname());
      type(By.name("lastname"), contactData.getLastname());
      type(By.name("address"), contactData.getAddress());
      type(By.name("home"), contactData.getHomeNumber());
      type(By.name("mobile"), contactData.getMobileNumber());
      type(By.name("email"), contactData.getFirstEmail());
      type(By.name("email2"), contactData.getSecondEmail());
      
      if (creation) {
          new Select(wd.findElement(By.name("new_group"))).selectByIndex(1);
      } else {
          Assert.assertFalse(isElementPresent(By.name("new_group")));
      }
    }

    public void initContactModificationById(int id) {
        wd.findElement(By.xpath("//a[@href='edit.php?id=" + id + "']")).click();
    }

    public void submitContactModification() {
        click(By.xpath("//input[22]"));
    }


    public void selectContactById(int id) {
        wd.findElement(By.cssSelector("input[id='" + id + "']")).click();
    }

    public void deleteSelectedContact() {
        click(By.xpath("//input[@value='Delete']"));
    }

    public void create(ContactData contact) {
        goToContactCreationPage();
        fillContactCreationPage(contact, true);
        submitContactCreation();
        contactCache = null;
        returnToHomePage();
    }

    public void modify(ContactData contact) {
        selectContactById(contact.getId());
        initContactModificationById(contact.getId());
        fillContactCreationPage(contact, false);
        submitContactModification();
        contactCache = null;
        returnToHomePage();
    }

    public void delete(ContactData contact) {
        selectContactById(contact.getId());
        deleteSelectedContact();
        isAlertPresent();
        //не понятно как обратиться к методу homePage из NavigationHelper
        //homePage();
        contactCache = null;
        returnToHomePage();
    }
    public void goToContactCreationPage() {
        wd.findElement(By.linkText("add new")).click();
    }

    private Contacts contactCache = null;

    public Contacts all() {
        if (contactCache != null) {
            return new Contacts(contactCache);
        }
        contactCache = new Contacts();
        List<WebElement> elements = wd.findElements(By.cssSelector("[name='entry']"));
        for (WebElement element: elements
        ) {
            String firstName = element.findElement(By.cssSelector("td:nth-child(3)")).getText();
            String lastName = element.findElement(By.cssSelector("td:nth-child(2)")).getText();
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
            ContactData contact = new ContactData().withId(id).withFirstName(firstName).withLastName(lastName);
            contactCache.add(contact);
        }
        return new Contacts(contactCache);
    }
}
