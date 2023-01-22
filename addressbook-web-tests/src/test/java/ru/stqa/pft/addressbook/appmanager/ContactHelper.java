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
      type(By.name("work"), contactData.getWorkNumber());
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
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
            String firstName = element.findElement(By.cssSelector("td:nth-child(3)")).getText();
            String lastName = element.findElement(By.cssSelector("td:nth-child(2)")).getText();
            String allPhones = element.findElement(By.cssSelector("td:nth-child(6)")).getText();
            String allEmails = element.findElement(By.cssSelector("td:nth-child(5)")).getText();
            String address = element.findElement(By.cssSelector("td:nth-child(4)")).getText();
            ContactData contact = new ContactData()
                    .withId(id).withFirstName(firstName).withLastName(lastName)
                    .withAllPhones(allPhones)
                    .withAllEmails(allEmails)
                    .withAddress(address);

            contactCache.add(contact);
        }
        return new Contacts(contactCache);
    }

    public int count() {
        return wd.findElements(By.name("selected[]")).size();
    }

    public ContactData infoFromEditForm(ContactData contact) {
        initContactModificationById(contact.getId());
        String firstname = wd.findElement(By.name("firstname")).getAttribute("value");
        String lastname = wd.findElement(By.name("lastname")).getAttribute("value");
        String home = wd.findElement(By.name("home")).getAttribute("value");
        String mobile = wd.findElement(By.name("mobile")).getAttribute("value");
        String work = wd.findElement(By.name("work")).getAttribute("value");
        String firstEmail = wd.findElement(By.name("email")).getAttribute("value");
        String secondEmail = wd.findElement(By.name("email2")).getAttribute("value");
        String thirdEmail = wd.findElement(By.name("email3")).getAttribute("value");
        String address = wd.findElement(By.name("address")).getText();
        wd.navigate().back();
        return new ContactData()
                .withId(contact.getId()).withFirstName(firstname).withLastName(lastname)
                .withHomeNumber(home).withMobileNumber(mobile).withWorkNumber(work)
                .withFirstEmail(firstEmail).withSecondEmail(secondEmail).withThirdEmail(thirdEmail)
                .withAddress(address);

    }
}
