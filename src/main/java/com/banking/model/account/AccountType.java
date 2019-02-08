package com.banking.model.account;

import javax.persistence.*;

@Entity
@Table(name = "account_type")
@NamedQueries({
        @NamedQuery(name = "ACCOUNT_TYPE.SELECT", query = "Select a from AccountType a")
})
public class AccountType {

    @Id
    @Column(name = "TRANSACTION_ID")
    private int transactionId;
    @Column(name = "ACCOUNT_TYPE")
    private int accountType;
    @Column(name = "ACCOUNT_TYPE_NAME")
    private String accountTypeName;

    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public int getAccountType() {
        return accountType;
    }

    public void setAccountType(int accountType) {
        this.accountType = accountType;
    }

    public String getAccountTypeName() {
        return accountTypeName;
    }

    public void setAccountTypeName(String accountTypeName) {
        this.accountTypeName = accountTypeName;
    }
}
