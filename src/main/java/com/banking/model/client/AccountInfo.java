package com.banking.model.client;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.util.Date;


@Embeddable
public class AccountInfo {

    @Column(name = "FIRSTNAME")
    private String firstName;
    @Column(name = "LASTNAME")
    private String lastName;
    @Column(name = "ACCOUNT_TYPE")
    private int accountType;
    @Column(name = "ACCOUNT_BALANCE")
    private long accountBalance;
    @Column(name = "ACCOUNT_START_DATE")
    private Date accountStartDate;
    @Column(name = "PANNUMBER")
    private String panNumber;
    @Column(name = "ADHAR_ID")
    private String adharId;

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

    public int getAccountType() {
        return accountType;
    }

    public void setAccountType(int accountType) {
        this.accountType = accountType;
    }

    public long getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(long accountBalance) {
        this.accountBalance = accountBalance;
    }

    public Date getAccountStartDate() {
        return accountStartDate;
    }

    public void setAccountStartDate(Date accountStartDate) {
        this.accountStartDate = accountStartDate;
    }

    public String getPanNumber() {
        return panNumber;
    }

    public void setPanNumber(String panNumber) {
        this.panNumber = panNumber;
    }

    public String getAdharId() {
        return adharId;
    }

    public void setAdharId(String adharId) {
        this.adharId = adharId;
    }

    @Override
    public String toString() {
        return "AccountInfo{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", accountType=" + accountType +
                ", accountBalance=" + accountBalance +
                ", accountStartDate=" + accountStartDate +
                ", panNumber='" + panNumber + '\'' +
                ", adharId='" + adharId + '\'' +
                '}';
    }
}
