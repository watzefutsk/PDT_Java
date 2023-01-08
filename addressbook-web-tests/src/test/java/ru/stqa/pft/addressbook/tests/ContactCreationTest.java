package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;


public class ContactCreationTest extends TestBase {

  @Test
  public void testContactCreation() throws Exception {
    app.getNavigatioHelper().goToGroupPage();
    if (!app.getGroupHelper().isThereAGroup()) {
      app.getGroupHelper().createGroup(new GroupData("test1", null, null));
    }
    app.getNavigatioHelper().goToHomePage();
    app.getContactHelper().createContact(new ContactData("Andy",
                                            "Smith",
                                            "Saint-Petersburg",
                                            "83522476125",
                                            "89536547898",
                                            "test@yandex.ru",
                                            "test1@gmail.com",
                                            null));
  }
}
