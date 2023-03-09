package com.creapption.quickf.util;

import java.util.Random;
import com.creapption.quickf.pojo.Factura;

public class UniqueAccessKey {
    // #region Constants
    static final int digitsForIssueDate = 8;
    static final int digitsForBillingType = 2;
    static final int digitsForRuc = 13;
    static final int digitsForEnvType = 1;
    static final int digitsForSequence = 6;
    static final int digitsForBillingNumber = 9;
    static final int digitsForIssueType = 1;
    static final int digitsForUniqueCode = 8;
    static final String INCORRECT_LENGTH_STRING = "The property has not the correct digit length!";
    // #endregion

    protected String issueDate;
    protected String billingType;
    protected String ruc;
    protected String environmentType;
    protected String sequence;
    protected String billingSequential;
    protected String issueType;

    /**
     * Constructor for UniqueAccessKey
     * 
     * @param bill Factura class
     */
    public UniqueAccessKey(Factura bill) {
        super();

        // fixing date format in issueDate for key generation
        String issueDate = bill.getInfoFactura().getFechaEmision().replace("/", "");

        // init all the required properties
        setIssueDate(issueDate);
        setBillingType(bill.getInfoTributaria().getCodDoc());
        setRuc(bill.getInfoTributaria().getRuc());
        setEnvironmentType(bill.getInfoTributaria().getAmbiente());
        setSequence(bill.getInfoTributaria().getEstab() + bill.getInfoTributaria().getPtoEmi());
        setBillingSequential(bill.getInfoTributaria().getSecuencial());
    }

    /**
     * Generates the unique access key for the contributor given all the needed
     * params
     *
     * @return String
     */
    public String generateKey() {        
        //calculating the unique codeNumber for bills (radom number of 8 digits)
        var codeNumberForBill = generateCodeNumber();
        String accessKey = String.format("%s%s%s%s%s%s%s%s", issueDate, billingType, ruc, environmentType, sequence,
                billingSequential, codeNumberForBill, issueType);
        return setVerifierDigit(accessKey);
    }

    /**
     * Generates a unique secure 8 digits code for the contributor
     *
     * @return String
     */
    private String generateCodeNumber() {
        return String.valueOf(new Random()
                .nextInt((9 * (int) Math.pow(10, digitsForUniqueCode - 1)) - 1)
                + (int) Math.pow(10, digitsForUniqueCode - 1));
    }

    /**
     * Sets the last Verifier digit for the unique access key.
     * 
     * @return String
     */
    private static String setVerifierDigit(String accessKey) {
        var module11 = Common.getModule11(accessKey);
        return accessKey + module11;
    }

    // #regionProperties

    /**
     * Gets the issue date for the bill
     *
     * @return String
     */
    public String getIssueDate() {
        return issueDate;
    }

    /**
     * Sets the issue date for the bill (8 digits)
     *
     * @param issueDate String
     */
    public void setIssueDate(String issueDate) {
        if (issueDate.length() != digitsForIssueDate) {
            throw new IllegalArgumentException(INCORRECT_LENGTH_STRING);
        }
        this.issueDate = issueDate;
    }

    /**
     * Gets the billing type
     *
     * @return String
     */
    public String getBillingType() {
        return billingType;
    }

    /**
     * Sets the billing type (2 digits)
     *
     * @param billingType String
     */
    public void setBillingType(String billingType) {
        if (billingType.length() != digitsForBillingType) {
            throw new IllegalArgumentException(INCORRECT_LENGTH_STRING);
        }
        this.billingType = billingType;
    }

    /**
     * Gets the RUC for the contributor
     *
     * @return String
     */
    public String getRuc() {
        return ruc;
    }

    /**
     * Sets the RUC for the contributor (13 digits)
     *
     * @param ruc String
     */
    public void setRuc(String ruc) {
        if (ruc.length() != digitsForRuc) {
            throw new IllegalArgumentException(INCORRECT_LENGTH_STRING);
        }
        this.ruc = ruc;
    }

    /**
     * Gets the environment type
     *
     * @return String
     */
    public String getEnvironmentType() {
        return environmentType;
    }

    /**
     * Sets the enviroment type (production or testing) (1 digit)
     *
     * @param environmentType String
     */
    public void setEnvironmentType(String environmentType) {
        if (environmentType.length() != digitsForEnvType) {
            throw new IllegalArgumentException(INCORRECT_LENGTH_STRING);
        }
        this.environmentType = environmentType;
    }

    /**
     * Gets the sequence for the bill
     *
     * @return String
     */
    public String getSequence() {
        return sequence;
    }

    /**
     * Sets the sequence for the bill (6 digits)
     *
     * @param sequence String
     */
    public void setSequence(String sequence) {
        if (sequence.length() != digitsForSequence) {
            throw new IllegalArgumentException(INCORRECT_LENGTH_STRING);
        }
        this.sequence = sequence;
    }

    /**
     * Gets the billing number
     */
    public String getBillingSequential() {
        return billingSequential;
    }

    /**
     * Sets the billing number (9 digits)
     *
     * @param billingSequential String
     */
    public void setBillingSequential(String billingSequential) {
        if (billingSequential.length() != digitsForBillingNumber) {
            throw new IllegalArgumentException(INCORRECT_LENGTH_STRING);
        }
        this.billingSequential = billingSequential;
    }

    /**
     * Gets the type of emission for the bill
     *
     * @return String
     */
    public String getIssueType() {
        return issueType;
    }

    /**
     * Sets the type of emission for the bill (1 digit)
     *
     * @param issueType String
     */
    public void setIssueType(String issueType) {
        if (issueType.length() != digitsForIssueType) {
            throw new IllegalArgumentException(INCORRECT_LENGTH_STRING);
        }
        this.issueType = issueType;
    }
    // #endregion
}
