package com.banking.persistence.dao.beneficiary;

import com.banking.exception.BankingException;
import com.banking.model.beneficiary.BeneficiaryInfo;
import com.banking.persistence.dao.GenericDaoOperations;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;

@Repository("beneficiaryImplDAO")
public class BeneficiaryImplDAO extends GenericDaoOperations<BeneficiaryInfo> implements BeneficiaryDAO {

    private Logger logger = LoggerFactory.getLogger(BeneficiaryImplDAO.class);

    @Override
    public int addBeneficiary(BeneficiaryInfo beneficiaryInfo) throws BankingException {
        logger.info("DAO: Getting Request to add beneficiary {} ",beneficiaryInfo);
        save(beneficiaryInfo);
        return beneficiaryInfo.getBeneficiaryId();
    }


    @Override
    public List<BeneficiaryInfo> getBeneficiary(long clientId) throws BankingException {
        //TODO: Implement getBeneficiary
        return new ArrayList<>();
    }


    @Override
    public void updateBeneficiary(BeneficiaryInfo beneficiaryInfo) throws BankingException {
        //TODO: Implement updateBeneficiary
    }

}
