package com.banking.controller.account;

import com.banking.model.account.AccountTypeResponse;
import com.banking.model.beneficiary.BeneficiaryReponse;
import com.banking.processor.account.GetAccountTypesProcessor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/banking")
public class GetAccountTypesController {
    private static Logger Logger = LoggerFactory.getLogger(GetAccountTypesController.class);
    private GetAccountTypesProcessor getAccountTypesProcessor;

    @Autowired
    public GetAccountTypesController(GetAccountTypesProcessor getAccountTypesProcessor) {
        this.getAccountTypesProcessor = getAccountTypesProcessor;
    }

    @RequestMapping(value = "/getAccountTypes", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public ResponseEntity<AccountTypeResponse> getAccountTypes() {
        Logger.info("Getting Request to get accountTypes");
        AccountTypeResponse accountTypeResponse = getAccountTypesProcessor.getAccountTypes();
        return new ResponseEntity<>(accountTypeResponse, HttpStatus.OK);
    }

}
