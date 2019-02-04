package com.banking.model.client;

import javax.persistence.*;

@Entity
@Table(name = "client")
public class Client {

    @Id
    @GeneratedValue
    @Column(name = "CLIENT_ID")
    private int clientId;
    private AccountInfo accountInfos;

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public AccountInfo getAccountInfos() {
        return accountInfos;
    }

    public void setAccountInfos(AccountInfo accountInfos) {
        this.accountInfos = accountInfos;
    }

    @Override
    public String toString() {
        return "Client{" +
                "clientId=" + clientId +
                ", accountInfos=" + accountInfos +
                '}';
    }
}
