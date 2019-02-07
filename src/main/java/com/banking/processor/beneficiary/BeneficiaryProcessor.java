package com.banking.processor.beneficiary;

import com.banking.exception.BankingException;
import com.banking.model.beneficiary.BeneficiaryInfo;
import com.banking.model.beneficiary.BeneficiaryReponse;
import com.banking.persistence.dao.beneficiary.BeneficiaryDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("beneficiaryProcessor")
public class BeneficiaryProcessor {

    private Logger logger = LoggerFactory.getLogger(BeneficiaryProcessor.class);
    private BeneficiaryDAO beneficiaryDAO;

    @Autowired
    public BeneficiaryProcessor(BeneficiaryDAO beneficiaryDAO) {
        this.beneficiaryDAO = beneficiaryDAO;
    }

    public BeneficiaryReponse processRequest(BeneficiaryInfo beneficiaryInfo) {
        BeneficiaryReponse beneficiaryReponse = new BeneficiaryReponse();
        try {
            logger.info("Request processing for addition of beneficiary info {} ", beneficiaryInfo);
            int confirmationNumber = beneficiaryDAO.addBeneficiary(beneficiaryInfo);
            beneficiaryReponse.setStatus("SUCCESS");
            beneficiaryReponse.setConfirmationNumber(confirmationNumber);


        }catch (BankingException e) {
            logger.error(e.getMessage(), e);
            beneficiaryReponse = new BeneficiaryReponse();
            beneficiaryReponse.setStatus("FAILURE");
            beneficiaryReponse.setMessage("Beneficiary addition failed. Please contact service desk");
        }

        return beneficiaryReponse;

    }


    public BeneficiaryReponse getBeneficiaryInfo(long clientId) {

        BeneficiaryReponse beneficiaryReponse = new BeneficiaryReponse();
        try {
            logger.info("Request processing to get beneficiary info for client {}" , clientId);
            List<BeneficiaryInfo> beneficiaryInfoList = beneficiaryDAO.getBeneficiary(clientId);
            beneficiaryReponse.setStatus("SUCCESS");
            beneficiaryReponse.setBeneficiaryInfoList(beneficiaryInfoList);


        }catch (BankingException e) {
            logger.error(e.getMessage(), e);
            beneficiaryReponse = new BeneficiaryReponse();
            beneficiaryReponse.setStatus("FAILURE");
            beneficiaryReponse.setMessage("Beneficiary retrieval failed. Please contact service desk");
        }

        return beneficiaryReponse;

    }

    public BeneficiaryReponse updateBeneficiaryInfo(BeneficiaryInfo beneficiaryInfo) {

        BeneficiaryReponse beneficiaryReponse = new BeneficiaryReponse();
        try {
            logger.info("Request processing to update beneficiary info {}" , beneficiaryInfo);
            beneficiaryDAO.updateBeneficiary(beneficiaryInfo);
            beneficiaryReponse.setStatus("SUCCESS");

        }catch (BankingException e) {
            logger.error(e.getMessage(), e);
            beneficiaryReponse = new BeneficiaryReponse();
            beneficiaryReponse.setStatus("FAILURE");
            beneficiaryReponse.setMessage("Beneficiary retrieval failed. Please contact service desk");
        }

        return beneficiaryReponse;

    }



}
