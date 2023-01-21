package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.List;
import java.util.Set;


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

    Set<ContactData> before = app.contact().all();
    ContactData contact = new ContactData()
            .withFirstName("Dima")
            .withLastName("Smith")
            .withAddress("Saint-Petersburg")
            .withHomeNumber("83522476125")
            .withMobileNumber("89536547898")
            .withFirstEmail("test@yandex.ru")
            .withSecondEmail("test1@gmail.com");
    app.contact().create(contact);
    Set<ContactData> after = app.contact().all();
    Assert.assertEquals(after.size(), before.size() + 1);

    contact.withId(after.stream().mapToInt((c) -> (c.getId())).max().getAsInt());
    before.add(contact);
    Assert.assertEquals(after, before);
  }
}
