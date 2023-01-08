package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

public class ContactModificationTest extends TestBase{
    @Test
    public void testContactModification() {
        app.getNavigatioHelper().goToGroupPage();
        if (!app.getGroupHelper().isThereAGroup()) {
            app.getGroupHelper().createGroup(new GroupData("test1", null, null));
        }
        app.getNavigatioHelper().goToHomePage();
        if (!app.getContactHelper().isThereAContact()) {
            app.getContactHelper().createContact(new ContactData("Andy",
                    "Smith",
                    "Saint-Petersburg",
                    "83522476125",
                    "89536547898",
                    "test@yandex.ru",
                    "test1@gmail.com", null));
        }
        app.getContactHelper().initContactModification();
        app.getContactHelper().fillContactCreationPage(new ContactData(
            "Maria",
            "Ivanova",
            "Ekaterinburg",
            "8352333444",
            "89536111222",
            "test123@yandex.ru",
            "test123@gmail.com",
                null), false);

        app.getContactHelper().submitContactModification();
        app.getContactHelper().returnToHomePage();
    }
}
