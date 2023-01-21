package ru.stqa.pft.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactModificationTest extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().groupPage();
        if (app.group().all().size() == 0) {
            app.group().create(new GroupData().withName("test1"));
        }
        app.goTo().homePage();
        if (app.contact().all().size() == 0) {
            app.contact().create(new ContactData()
                    .withFirstName("Dima")
                    .withLastName("Smith")
                    .withAddress("Saint-Petersburg")
                    .withHomeNumber("83522476125")
                    .withMobileNumber("89536547898")
                    .withFirstEmail("test@yandex.ru")
                    .withSecondEmail("test1@gmail.com"));
        }
    }

    @Test (enabled = true)
    public void testContactModification() {
        Contacts before = app.contact().all();
        ContactData modifiedContact = before.iterator().next();
        ContactData contact = new ContactData()
                .withId(modifiedContact.getId())
                .withFirstName("Maria")
                .withLastName("Zhukova")
                .withAddress("Saint-Petersburg")
                .withHomeNumber("83522476333")
                .withMobileNumber("89112875364")
                .withFirstEmail("yandex@yandex.ru")
                .withSecondEmail("gmail@gmail.com");
        app.contact().modify(contact);
        Contacts after = app.contact().all();
        assertThat(after.size(), equalTo(before.size()));

        assertThat(after, equalTo(before.without(modifiedContact).withAdded(contact)));
    }
}
