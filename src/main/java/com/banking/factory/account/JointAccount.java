package com.banking.factory.account;


import com.banking.model.client.Client;
import com.banking.persistence.dao.account.CreateAccountDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("jointAccount")
public class JointAccount implements IAccountType {
    private Logger logger = LoggerFactory.getLogger(JointAccount.class);
    private CreateAccountDAO createAccountDAO;

    @Autowired
    public JointAccount(CreateAccountDAO createAccountDAO) {
        this.createAccountDAO = createAccountDAO;
    }

    @Override
    public long createAccount(Client client) {
        logger.info("Joint account is created");
        return createAccountDAO.createAccount(client);

    }

    @Override
    public boolean deleteAccount(long accountNumber) {
        logger.info("Joint account is deleted");
        return true;
    }
}
