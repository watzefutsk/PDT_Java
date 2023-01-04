package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactModificationTest extends TestBase{
    @Test
    public void testContactModification() {
        if (!app.getContactHelper().isThereAContact()) {
            app.getContactHelper().createContact(new ContactData("Andy",
                    "Smith",
                    "Saint-Petersburg",
                    "83522476125",
                    "89536547898",
                    "test@yandex.ru",
                    "test1@gmail.com", "test1"), true);
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
