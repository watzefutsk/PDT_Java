package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.List;


public class ContactCreationTest extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().groupPage();
    if (app.group().all().size() == 0) {
      app.group().create(new GroupData().withName("test1"));
    }
    app.goTo().homePage();
  }
  @Test (enabled = true)
  public void testContactCreation() throws Exception {

    List<ContactData> before = app.contact().all();
    ContactData contact = new ContactData(
            "Dima",
            "Smith",
            "Saint-Petersburg",
            "83522476125",
            "89536547898",
            "test@yandex.ru",
            "test1@gmail.com",
            null);
    app.contact().create(contact);
    List<ContactData> after = app.contact().all();
    Assert.assertEquals(after.size(), before.size() + 1);

    before.add(contact);
    Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(after, before);
  }
}
