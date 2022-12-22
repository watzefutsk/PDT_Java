package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactModificationTest extends TestBase{
    @Test
    public void testContactModification() {
        app.getContactHelper().initContactModification();
        app.getContactHelper().fillContactCreationPage(new ContactData(
            "Maria",
            "Ivanova",
            "Ekaterinburg",
            "8352333444",
            "89536111222",
            "test123@yandex.ru",
            "test123@gmail.com"));
        app.getContactHelper().submitContactModification();
        app.getContactHelper().returnToHomePage();
    }
}
