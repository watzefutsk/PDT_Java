package ru.stqa.pft.addressbook.tests;

import java.time.Duration;

import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.*;
import org.openqa.selenium.*;
import ru.stqa.pft.addressbook.model.ContactData;


public class ContactCreationTest {
  private WebDriver wd;

  @BeforeMethod(alwaysRun = true)
  public void setUp() throws Exception {
    wd = new EdgeDriver();
    wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    wd.get("http://localhost/addressbook/");
    login("admin", "secret");
  }

  private void login(String username, String password) {
    wd.findElement(By.name("user")).click();
    wd.findElement(By.name("user")).clear();
    wd.findElement(By.name("user")).sendKeys(username);
    wd.findElement(By.name("pass")).clear();
    wd.findElement(By.name("pass")).sendKeys(password);
    wd.findElement(By.xpath("//input[@value='Login']")).click();
  }

  @Test
  public void testContactCreation() throws Exception {
    goToContactCreationPage();
    fillContactCreationPage(new ContactData("Andy",
                                            "Smith",
                                            "Saint-Petersburg",
                                            "83522476125",
                                            "89536547898",
                                            "test@yandex.ru",
                                            "test1@gmail.com"));
    submitContactCreation();
    returnToHomePage();
  }

  private void returnToHomePage() {
    wd.findElement(By.linkText("home page")).click();
  }

  private void submitContactCreation() {
    wd.findElement(By.xpath("//div[@id='content']/form/input[21]")).click();
  }

  private void fillContactCreationPage(ContactData contactData) {
    wd.findElement(By.name("firstname")).sendKeys(contactData.getFirstname());
    wd.findElement(By.name("lastname")).sendKeys(contactData.getLastname());
    wd.findElement(By.name("address")).sendKeys(contactData.getAddress());
    wd.findElement(By.name("home")).sendKeys(contactData.getHomenumber());
    wd.findElement(By.name("mobile")).sendKeys(contactData.getMobilenumber());
    wd.findElement(By.name("email")).sendKeys(contactData.getFirstemail());
    wd.findElement(By.name("email2")).sendKeys(contactData.getSecondemail());
  }

  private void goToContactCreationPage() {
    wd.findElement(By.linkText("add new")).click();
  }

  @AfterMethod(alwaysRun = true)
  public void tearDown() throws Exception {
    logout();
    wd.quit();
  }

  private void logout() {
    wd.findElement(By.linkText("Logout")).click();
  }

  private boolean isElementPresent(By by) {
    try {
      wd.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      wd.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }
}