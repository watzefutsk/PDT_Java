package ru.stqa.pft.addressbook.model;

import com.google.gson.annotations.Expose;

import java.io.File;
import java.util.Objects;

public class ContactData {
    private int id = Integer.MAX_VALUE;
    @Expose
    private String firstname;
    @Expose
    private String lastname;
    @Expose
    private String address;
    private String secondaddress;
    @Expose
    private String homenumber;
    @Expose
    private String mobilenumber;
    @Expose
    private String worknumber;
    private String allphones;
    @Expose
    private String firstemail;
    @Expose
    private String secondemail;
    @Expose
    private String thirdemail;
    private String allemails;
    @Expose
    private File photo;

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

    public ContactData withSecondAddress(String secondaddress) {
        this.secondaddress = secondaddress;
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

    public ContactData withWorkNumber(String worknumber) {
        this.worknumber = worknumber;
        return this;
    }

    public ContactData withAllPhones(String allphones) {
        this.allphones = allphones;
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

    public ContactData withThirdEmail(String thirdemail) {
        this.thirdemail = thirdemail;
        return this;
    }

    public ContactData withAllEmails(String allemails) {
        this.allemails = allemails;
        return this;
    }

    public ContactData withPhoto(File photo) {
        this.photo = photo;
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

    public String getSecondAddress() {
        return secondaddress;
    }

    public String getHomeNumber() {
        return homenumber;
    }

    public String getMobileNumber() {
        return mobilenumber;
    }

    public String getWorkNumber() {
        return worknumber;
    }

    public String getAllPhones() {
        return allphones;
    }

    public String getFirstEmail() {
        return firstemail;
    }

    public String getSecondEmail() {
        return secondemail;
    }

    public String getThirdEmail() {
        return thirdemail;
    }

    public String getAllEmails() {
        return allemails;
    }

    public File getPhoto() {
        return photo;
    }

    /*public File getPhoto() {
        if (photo != null) {
            return new File(photo);
        } else {
            return null;
        }
    }*/


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


