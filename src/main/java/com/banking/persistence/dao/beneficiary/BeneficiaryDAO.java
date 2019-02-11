package com.banking.persistence.dao.beneficiary;

import com.banking.exception.BankingException;
import com.banking.model.beneficiary.BeneficiaryInfo;

import java.util.List;

public interface BeneficiaryDAO {

    int addBeneficiary(BeneficiaryInfo beneficiaryInfo) throws BankingException;

    List<BeneficiaryInfo> getBeneficiary(int clientId) throws BankingException;

    void updateBeneficiary(BeneficiaryInfo beneficiaryInfo) throws BankingException;


}
