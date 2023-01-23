package ru.stqa.pft.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class GroupModificationTest extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().groupPage();
        if (app.group().all().size() == 0) {
            app.group().create(new GroupData().withName("test1"));
        }
    }

    @Test (enabled = true)
    public void testGroupModification() {
        Groups before = app.group().all();
        GroupData modifiedGroup = before.stream().iterator().next();
        GroupData group = new GroupData().withId(modifiedGroup.getId()).withName("test1").withHeader("test1").withFooter("test2");
        app.group().modify(group);
        assertThat(app.group().count(), CoreMatchers.equalTo(before.size()));
        Groups after = app.group().all();
        assertThat(after, equalTo(before.without(modifiedGroup).withAdded(group)));
    }
}
