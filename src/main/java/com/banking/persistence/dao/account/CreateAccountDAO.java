package com.banking.persistence.dao.account;

import com.banking.model.client.Client;
import com.banking.persistence.dao.GenericDaoOperations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

@Repository("createAccountDAO")
public class CreateAccountDAO extends GenericDaoOperations<Client> {

    private Logger logger = LoggerFactory.getLogger(CreateAccountDAO.class);

    public int createAccount(Client client) {
        logger.info("Getting Request to create account");
        client.getAccountInfos().setAccountStartDate(new java.util.Date());
        save(client);
        return client.getClientId();
    }

}
