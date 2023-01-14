package ru.stqa.pft.addressbook.model;

import java.util.Objects;

public class ContactData {
    private int id;
    private final String firstname;
    private final String lastname;
    private final String address;
    private final String homenumber;
    private final String mobilenumber;
    private final String firstemail;
    private final String secondemail;
    private String group;

    public ContactData(int id, String firstname, String lastname, String address, String homenumber, String mobilenumber, String firstemail, String secondemail, String group) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.address = address;
        this.homenumber = homenumber;
        this.mobilenumber = mobilenumber;
        this.firstemail = firstemail;
        this.secondemail = secondemail;
        this.group = group;
    }

    public ContactData(String firstname, String lastname, String address, String homenumber, String mobilenumber, String firstemail, String secondemail, String group) {
        this.id = Integer.MAX_VALUE;
        this.firstname = firstname;
        this.lastname = lastname;
        this.address = address;
        this.homenumber = homenumber;
        this.mobilenumber = mobilenumber;
        this.firstemail = firstemail;
        this.secondemail = secondemail;
        this.group = group;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

        if (!Objects.equals(firstname, that.firstname)) return false;
        return Objects.equals(lastname, that.lastname);
    }

    @Override
    public int hashCode() {
        int result = firstname != null ? firstname.hashCode() : 0;
        result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
        return result;
    }
}
