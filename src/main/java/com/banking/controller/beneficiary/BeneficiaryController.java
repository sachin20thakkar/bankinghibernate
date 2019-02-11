package com.banking.controller.beneficiary;


import com.banking.model.beneficiary.BeneficiaryInfo;
import com.banking.model.beneficiary.BeneficiaryReponse;
import com.banking.processor.beneficiary.BeneficiaryProcessor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController("beneficiaryController")
@RequestMapping(value = "/banking")
public class BeneficiaryController {

    private Logger logger = LoggerFactory.getLogger(BeneficiaryController.class);
    private BeneficiaryProcessor beneficiaryProcessor;

    @Autowired
    public BeneficiaryController(BeneficiaryProcessor beneficiaryProcessor) {
        this.beneficiaryProcessor = beneficiaryProcessor;
    }

    @RequestMapping(value = "/addBeneficiary", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public ResponseEntity<BeneficiaryReponse> addBeneficiary(@RequestBody BeneficiaryInfo beneficiaryInfo) {
        logger.info("Getting Request for beneficiary addition: {} ", beneficiaryInfo);
        BeneficiaryReponse beneficiaryReponse  = beneficiaryProcessor.processRequest(beneficiaryInfo);
        return new ResponseEntity<>(beneficiaryReponse, HttpStatus.OK);
    }

    @RequestMapping(value = "/getBeneficiary/{clientId}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public ResponseEntity<BeneficiaryReponse> getBeneficiary(@PathVariable(value = "clientId") int clientId) {
            logger.info("Getting Request to get beneficiary info for client : {} ", clientId);
            BeneficiaryReponse beneficiaryReponse  = beneficiaryProcessor.getBeneficiaryInfo(clientId);
            return new ResponseEntity<>(beneficiaryReponse, HttpStatus.OK);
    }

    @RequestMapping(value = "/updateBeneficiary", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public ResponseEntity<BeneficiaryReponse> updateBeneficiary(@RequestBody BeneficiaryInfo beneficiaryInfo) {
        logger.info("Getting Request for beneficiary update: {} ", beneficiaryInfo);
        BeneficiaryReponse beneficiaryReponse  = beneficiaryProcessor.updateBeneficiaryInfo(beneficiaryInfo);
        return new ResponseEntity<>(beneficiaryReponse, HttpStatus.OK);
    }

}
