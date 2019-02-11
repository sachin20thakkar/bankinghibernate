package com.banking.model.beneficiary;


import javax.persistence.*;

@Entity
@Table(name = "beneficiary_info")
@NamedQueries({
        @NamedQuery(name = "BENEFICIARY.SELECT_CLIENTID",
                query = "select b from BeneficiaryInfo b where b.clientId = :clientId")
})
public class BeneficiaryInfo {

    @Id
    @GeneratedValue
    @Column(name = "BENEFICIARY_ID")
    private int beneficiaryId;
    @Column(name = "BENEFICIARY_TYPE")
    private int beneficiaryType;
    @Column(name = "BENEFICIARY_ACCOUNT_NUMBER")
    private String beneficiaryAccountNumber;
    @Column(name = "BENEFICIARY_ACCOUNT_TYPE")
    private int beneficiaryAccountType;
    @Column(name = "BENEFICIARY_NAME")
    private String beneficiaryName;
    @Column(name = "EMAIL_ID")
    private String emailId;
    @Column(name = "CLIENT_ID")
    private long clientId;
    @Column(name = "IFSCCODE")
    private String ifscCode;

    public int getBeneficiaryId() {
        return beneficiaryId;
    }

    public void setBeneficiaryId(int beneficiaryId) {
        this.beneficiaryId = beneficiaryId;
    }

    public int getBeneficiaryType() {
        return beneficiaryType;
    }

    public void setBeneficiaryType(int beneficiaryType) {
        this.beneficiaryType = beneficiaryType;
    }

    public String getBeneficiaryAccountNumber() {
        return beneficiaryAccountNumber;
    }

    public void setBeneficiaryAccountNumber(String beneficiaryAccountNumber) {
        this.beneficiaryAccountNumber = beneficiaryAccountNumber;
    }

    public int getBeneficiaryAccountType() {
        return beneficiaryAccountType;
    }

    public void setBeneficiaryAccountType(int beneficiaryAccountType) {
        this.beneficiaryAccountType = beneficiaryAccountType;
    }

    public String getBeneficiaryName() {
        return beneficiaryName;
    }

    public void setBeneficiaryName(String beneficiaryName) {
        this.beneficiaryName = beneficiaryName;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public long getClientId() {
        return clientId;
    }

    public void setClientId(long clientId) {
        this.clientId = clientId;
    }

    public String getIfscCode() {
        return ifscCode;
    }

    public void setIfscCode(String ifscCode) {
        this.ifscCode = ifscCode;
    }

    @Override
    public String toString() {
        return "BeneficiaryInfo{" +
                "beneficiaryType=" + beneficiaryType +
                ", beneficiaryAccountNumber='" + beneficiaryAccountNumber + '\'' +
                ", beneficiaryAccountType=" + beneficiaryAccountType +
                ", beneficiaryName='" + beneficiaryName + '\'' +
                ", emailId='" + emailId + '\'' +
                ", clientId=" + clientId +
                ", ifscCode='" + ifscCode + '\'' +
                '}';
    }
}
