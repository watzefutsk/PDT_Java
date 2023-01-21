package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.List;

public class ContactDeletionTest extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().groupPage();
        if (app.group().all().size() == 0) {
            app.group().create(new GroupData().withName("test1"));
        }
        app.goTo().homePage();
        if (app.contact().all().size() == 0) {
            app.contact().create(new ContactData("Andy",
                    "Smith",
                    "Saint-Petersburg",
                    "83522476125",
                    "89536547898",
                    "test@yandex.ru",
                    "test1@gmail.com", null));
        }
    }
    @Test (enabled = true)
    public void testContactDeletion() {

        List<ContactData> before = app.contact().all();
        int index = before.size() - 1;
        app.contact().delete(index);
        List<ContactData> after = app.contact().all();
        Assert.assertEquals(after.size(), before.size() - 1);

        before.remove(index);
        Assert.assertEquals(after, before);
    }
}
