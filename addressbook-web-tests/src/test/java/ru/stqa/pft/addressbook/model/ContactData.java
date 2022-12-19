package ru.stqa.pft.addressbook.model;

public class ContactData {
    private final String firstname;
    private final String lastname;
    private final String address;
    private final String homenumber;
    private final String mobilenumber;
    private final String firstemail;
    private final String secondemail;

    public ContactData(String firstname, String lastname, String address, String homenumber, String mobilenumber, String firstemail, String secondemail) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.address = address;
        this.homenumber = homenumber;
        this.mobilenumber = mobilenumber;
        this.firstemail = firstemail;
        this.secondemail = secondemail;
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

    public String getHomenumber() {
        return homenumber;
    }

    public String getMobilenumber() {
        return mobilenumber;
    }

    public String getFirstemail() {
        return firstemail;
    }

    public String getSecondemail() {
        return secondemail;
    }
}
