package com.banking.factory.account;



import com.banking.model.client.Client;
import com.banking.persistence.dao.account.CreateAccountDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("savingAccount")
public class SavingAccount implements IAccountType {

    private Logger logger = LoggerFactory.getLogger(SavingAccount.class);
    private CreateAccountDAO createAccountDAO;


    @Autowired
    public SavingAccount(CreateAccountDAO createAccountDAO) {
        this.createAccountDAO = createAccountDAO;
    }

    @Override
    public long createAccount(Client client) {
        logger.info("Saving Account is created");
        return createAccountDAO.createAccount(client);

    }

    @Override
    public boolean deleteAccount(long accountNumber) {
        logger.info("Saving Account is deleted");
        return true;
    }
}
