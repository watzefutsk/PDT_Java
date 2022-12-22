package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;


public class ContactCreationTest extends TestBase {

  @Test
  public void testContactCreation() throws Exception {
    app.getNavigatioHelper().goToContactCreationPage();
    app.getContactHelper().fillContactCreationPage(new ContactData("Andy",
                                            "Smith",
                                            "Saint-Petersburg",
                                            "83522476125",
                                            "89536547898",
                                            "test@yandex.ru",
                                            "test1@gmail.com"));
    app.getContactHelper().submitContactCreation();
    app.getContactHelper().returnToHomePage();
  }
}
