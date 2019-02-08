package com.banking.processor.account;

import com.banking.model.account.AccountType;
import com.banking.model.account.AccountTypeResponse;
import com.banking.persistence.dao.account.AccountTypeServiceDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetAccountTypesProcessor {

    private static Logger Logger = LoggerFactory.getLogger(GetAccountTypesProcessor.class);
    private AccountTypeServiceDAO accountTypeServiceDAO;

    @Autowired
    public GetAccountTypesProcessor(AccountTypeServiceDAO accountTypeServiceDAO) {
        this.accountTypeServiceDAO = accountTypeServiceDAO;
    }

    @Cacheable("accountTypes")
    public AccountTypeResponse getAccountTypes() {

        Logger.info("Request received to process getAccountTypes");
        List<AccountType> accountTypes = accountTypeServiceDAO.getAccountTypes();
        AccountTypeResponse accountTypeResponse = new AccountTypeResponse();
        accountTypeResponse.setAccountTypes(accountTypes);
        accountTypeResponse.setStatus("SUCCESS");

        return accountTypeResponse;
    }


}
