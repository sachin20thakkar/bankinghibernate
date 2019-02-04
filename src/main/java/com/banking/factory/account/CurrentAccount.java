package com.banking.factory.account;


import com.banking.model.client.Client;
import com.banking.persistence.dao.account.CreateAccountDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service("currentAccount")
public class CurrentAccount implements IAccountType {

    private Logger logger = LoggerFactory.getLogger(CurrentAccount.class);
    private CreateAccountDAO createAccountDAO;

    public CurrentAccount(CreateAccountDAO createAccountDAO) {
        this.createAccountDAO = createAccountDAO;
    }

    @Override
    public long createAccount(Client client) {
        logger.info("Current account is created");
        return createAccountDAO.createAccount(client);

    }

    @Override
    public boolean deleteAccount(long accountNumber) {
        logger.info("Current account is created");
        return true;
    }


}
