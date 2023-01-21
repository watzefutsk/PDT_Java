package ru.stqa.pft.addressbook.model;

import java.util.Objects;

public class ContactData {
    private int id = Integer.MAX_VALUE;
    private String firstname;
    private String lastname;
    private String address;
    private String homenumber;
    private String mobilenumber;
    private String firstemail;
    private String secondemail;

    public ContactData withId(int id) {
        this.id = id;
        return this;
    }

    public ContactData withFirstName(String firstname) {
        this.firstname = firstname;
        return this;
    }

    public ContactData withLastName(String lastname) {
        this.lastname = lastname;
        return this;
    }

    public ContactData withAddress(String address) {
        this.address = address;
        return this;
    }

    public ContactData withHomeNumber(String homenumber) {
        this.homenumber = homenumber;
        return this;
    }

    public ContactData withMobileNumber(String mobilenumber) {
        this.mobilenumber = mobilenumber;
        return this;
    }

    public ContactData withFirstEmail(String firstemail) {
        this.firstemail = firstemail;
        return this;
    }

    public ContactData withSecondEmail(String secondemail) {
        this.secondemail = secondemail;
        return this;
    }

    private String group;

    public int getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getAddress() {
        return address;
    }

    public String getHomeNumber() {
        return homenumber;
    }

    public String getMobileNumber() {
        return mobilenumber;
    }

    public String getFirstEmail() {
        return firstemail;
    }

    public String getSecondEmail() {
        return secondemail;
    }



    @Override
    public String toString() {
        return "ContactData{" +
                "id='" + id + '\'' +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContactData that = (ContactData) o;

        if (id != that.id) return false;
        if (!Objects.equals(firstname, that.firstname)) return false;
        return Objects.equals(lastname, that.lastname);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (firstname != null ? firstname.hashCode() : 0);
        result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
        return result;
    }
}
