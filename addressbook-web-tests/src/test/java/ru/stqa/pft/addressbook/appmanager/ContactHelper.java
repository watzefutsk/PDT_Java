package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.edge.EdgeDriver;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactHelper extends HelperBase {
    EdgeDriver wd;
    public ContactHelper(EdgeDriver wd) {
        super(wd);
    }
    public void returnToHomePage() {
      click(By.linkText("home page"));
    }

    public void submitContactCreation() {
      click(By.xpath("//div[@id='content']/form/input[21]"));
    }

    public void fillContactCreationPage(ContactData contactData) {
      type(By.name("firstname"), contactData.getFirstname());
      type(By.name("lastname"), contactData.getLastname());
      type(By.name("address"), contactData.getAddress());
      type(By.name("home"), contactData.getHomenumber());
      type(By.name("mobile"), contactData.getMobilenumber());
      type(By.name("email"), contactData.getFirstemail());
      type(By.name("email2"), contactData.getSecondemail());
    }
}
