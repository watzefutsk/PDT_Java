package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

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
        Set<ContactData> before = app.contact().all();
        ContactData modifiedContact = before.iterator().next();
        int index = before.size() - 1;
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
        Set<ContactData> after = app.contact().all();
        Assert.assertEquals(after.size(), before.size());

        before.remove(modifiedContact);
        before.add(contact);
        contact.withId(after.stream().mapToInt((c) -> (c.getId())).max().getAsInt());
        Assert.assertEquals(after, before);
    }
}
