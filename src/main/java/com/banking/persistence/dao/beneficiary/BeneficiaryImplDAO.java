package com.banking.persistence.dao.beneficiary;

import com.banking.exception.BankingException;
import com.banking.model.beneficiary.BeneficiaryInfo;
import com.banking.persistence.dao.GenericDaoOperations;

import org.hibernate.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;

@Repository("beneficiaryImplDAO")
public class BeneficiaryImplDAO extends GenericDaoOperations<BeneficiaryInfo> implements BeneficiaryDAO {

    private static Logger logger = LoggerFactory.getLogger(BeneficiaryImplDAO.class);

    @Override
    public int addBeneficiary(BeneficiaryInfo beneficiaryInfo) throws BankingException {
        logger.info("DAO: Getting Request to add beneficiary {} ",beneficiaryInfo);
        save(beneficiaryInfo);
        return beneficiaryInfo.getBeneficiaryId();
    }


    @Override
    public List<BeneficiaryInfo> getBeneficiary(int clientId) throws BankingException {
        logger.info("DAO: Getting Request to get beneficiary for clientid {} ",clientId);
        Query query = getCurrentSession().getNamedQuery("BENEFICIARY.SELECT_CLIENTID")
                .setInteger("clientId", clientId);
        return query.list();
    }


    @Override
    public void updateBeneficiary(BeneficiaryInfo beneficiaryInfo) throws BankingException {
        //TODO: Implement updateBeneficiary
    }

}
