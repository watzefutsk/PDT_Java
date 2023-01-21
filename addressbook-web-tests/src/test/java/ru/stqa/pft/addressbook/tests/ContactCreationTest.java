package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class ContactCreationTest extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().groupPage();
    if (app.group().all().size() == 0) {
      app.group().create(new GroupData().withName("test1"));
    }
    app.goTo().homePage();
  }
  @Test (enabled = false)
  public void testContactCreation() throws Exception {

    Contacts before = app.contact().all();
    ContactData contact = new ContactData()
            .withFirstName("Dima")
            .withLastName("Smith")
            .withAddress("Saint-Petersburg")
            .withHomeNumber("83522476125")
            .withMobileNumber("89536547898")
            .withFirstEmail("test@yandex.ru")
            .withSecondEmail("test1@gmail.com");
    app.contact().create(contact);
    assertThat(app.contact().count(), equalTo(before.size() + 1));
    Contacts after = app.contact().all();
    assertThat(after, equalTo(before.withAdded(contact.withId(after.stream().mapToInt((c) -> (c.getId())).max().getAsInt()))));
  }

  @Test (enabled = true)
  public void testBadContactCreation() throws Exception {

    Contacts before = app.contact().all();
    ContactData contact = new ContactData()
            .withFirstName("Dima'")
            .withLastName("Smith")
            .withAddress("Saint-Petersburg")
            .withHomeNumber("83522476125")
            .withMobileNumber("89536547898")
            .withFirstEmail("test@yandex.ru")
            .withSecondEmail("test1@gmail.com");
    app.contact().create(contact);
    assertThat(app.contact().count(), equalTo(before.size()));
    Contacts after = app.contact().all();
    assertThat(after, equalTo(before));
  }
}
