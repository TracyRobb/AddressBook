package com.android.trobb.addressbook.domain;

/**
 * Created by trobb on 2014/08/19.
 */
public class Contact {

    private int id;
    private String firstName;
    private String lastName;
    private String emailAddress;
    private String cellNumber;
    private String homeNumber;

    public Contact(){

    }

    public Contact( String firstName, String lastName, String emailAddress, String cellNumber, String homeNumber){

        //this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
        this.cellNumber = cellNumber;
        this.homeNumber = homeNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getCellNumber() {
        return cellNumber;
    }

    public void setCellNumber(String cellNumber) {
        this.cellNumber = cellNumber;
    }

    public String getHomeNumber() {
        return homeNumber;
    }

    public void setHomeNumber(String homeNumber) {
        this.homeNumber = homeNumber;
    }
}
