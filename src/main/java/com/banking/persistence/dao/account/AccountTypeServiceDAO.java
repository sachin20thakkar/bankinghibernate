package com.banking.persistence.dao.account;

import com.banking.model.account.AccountType;

import com.banking.persistence.dao.GenericDaoOperations;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class AccountTypeServiceDAO extends GenericDaoOperations<AccountType> {

    public List<AccountType> getAccountTypes() {
        Query query = getCurrentSession().getNamedQuery("ACCOUNT_TYPE.SELECT");
        return query.list();
    }

}
