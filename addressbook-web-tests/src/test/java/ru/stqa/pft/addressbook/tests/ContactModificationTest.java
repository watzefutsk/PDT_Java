package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.List;

public class ContactModificationTest extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().groupPage();
        if (app.group().all().size() == 0) {
            app.group().create(new GroupData().withName("test1"));
        }
        app.goTo().goToHomePage();
        if (!app.getContactHelper().isThereAContact()) {
            app.getContactHelper().createContact(new ContactData("Andy",
                    "Smith",
                    "Saint-Petersburg",
                    "83522476125",
                    "89536547898",
                    "test@yandex.ru",
                    "test1@gmail.com", null));
        }
    }

    @Test (enabled = true)
    public void testContactModification() {
        List<ContactData> before = app.getContactHelper().getContactList();
        int index = before.size() - 1;
        ContactData contact = new ContactData(before.get(index).getId(), "Maria",
                "Ivanova",
                "Ekaterinburg",
                "8352333444",
                "89536111222",
                "test123@yandex.ru",
                "test123@gmail.com",
                null);
        app.getContactHelper().modifyContact(index, contact);
        List<ContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size());

        before.remove(index);
        before.add(contact);
        Comparator<? super ContactData> byId = (c1,c2) -> Integer.compare(c1.getId(), c2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(after, before);
    }
}
