package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

public class ContactDeletionTest extends TestBase {
    @Test
    public void testContactDeletion(){
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
                    "test1@gmail.com", "test1"));
        }
        app.getContactHelper().selectContact();
        app.getContactHelper().deleteSelectedContact();
        app.getGroupHelper().isAlertPresent();

    }
}
