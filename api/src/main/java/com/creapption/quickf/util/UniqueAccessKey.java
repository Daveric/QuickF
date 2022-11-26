package com.creapption.quickf.util;

import java.util.Random;

public class UniqueAccessKey {
    // #region Constants
    static final int weightedCheckFactor = 2;
    // starts in 2 from the last digit and increases till 7, then starts again in 2
    static final int limitWeightedCheckFactor = 7;
    // starts in 2 from the last digit and increases till 7, then starts again in 2
    static final int modul11 = 11; // the number for the module digit calculation
    static final int digitsForIssueDate = 8;
    static final int digitsForBillingType = 2;
    static final int digitsForRuc = 13;
    static final int digitsForEnvType = 1;
    static final int digitsForSerie = 6;
    static final int digitsForBillingNumber = 9;
    static final int digitsForIssueType = 1;
    static final int digitsForUniqueCode = 8;
    static final String INCORRECT_LENGTH_STRING = "The property has not the correct digit length";
    // #endregion

    protected String issueDate;
    protected String billingType;
    protected String ruc;
    protected String enviromentType;
    protected String serie;
    protected String billingSequential;
    protected String issueType;

    public UniqueAccessKey() {
        super();
    }

    /**
     * Generates the unique access key for the cotributor given all the needed
     * params
     *
     * @return
     */
    public String generateKey() {
        var codeDigits = generateCodeNumber();
        String accessKey = String.format("%s%s%s%s%s%s%s%s", issueDate, billingType, ruc, enviromentType, serie,
                billingSequential,
                codeDigits, issueType);
        return setVerifierDigit(accessKey);
    }

    /**
     * Generates a unique secure 8 digits code for the contributor
     *
     * @return
     */
    private String generateCodeNumber() {
        return String.valueOf(digitsForUniqueCode < 1 ? 0 : new Random()
                .nextInt((9 * (int) Math.pow(10, digitsForUniqueCode - 1)) - 1)
                + (int) Math.pow(10, digitsForUniqueCode - 1));
    }

    /**
     * Sets the last Verifier digit for the unique access key.
     * 
     * @return
     */
    private static String setVerifierDigit(String accessKey) {
        int sum = 0, factor = weightedCheckFactor;
        var key = accessKey.toCharArray();
        // we start the calculation from the end
        for (var i = key.length - 1; i > -1; i--) {
            var c = key[i];
            sum = sum + Integer.parseInt(String.valueOf(c)) * factor;
            // the limit value is 7 according to spec
            if (factor == limitWeightedCheckFactor) {
                factor = weightedCheckFactor;
            }
            factor += 1;
        }
        var result = modul11 - (sum % modul11);
        // we calculate a different digit result for 11 and 10
        if (result == 11) {
            result = 0;
        } else if (result == 10) {
            result = 1;
        }
        return accessKey + result;
    }

    // #regionProperties

    /**
     * Gets the issue date for the bill
     *
     * @return
     */
    public String getIssueDate() {
        return issueDate;
    }

    /**
     * Sets the issue date for the bill (8 digits)
     *
     * @param issueDate
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
     * @return
     */
    public String getBillingType() {
        return billingType;
    }

    /**
     * Sets the billing type (2 digits)
     *
     * @param billingType
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
     * @return
     */
    public String getRuc() {
        return ruc;
    }

    /**
     * Sets the RUC for the contributor (13 digits)
     *
     * @param ruc
     */
    public void setRuc(String ruc) {
        if (ruc.length() != digitsForRuc) {
            throw new IllegalArgumentException(INCORRECT_LENGTH_STRING);
        }
        this.ruc = ruc;
    }

    /**
     * Gets the enviroment type
     *
     * @return
     */
    public String getEnviromentType() {
        return enviromentType;
    }

    /**
     * Sets the enviroment type (production or testing) (1 digit)
     *
     * @param enviromentType
     */
    public void setEnviromentType(String enviromentType) {
        if (enviromentType.length() != digitsForEnvType) {
            throw new IllegalArgumentException(INCORRECT_LENGTH_STRING);
        }
        this.enviromentType = enviromentType;
    }

    /**
     * Gets the serie for the bill
     *
     * @return
     */
    public String getSerie() {
        return serie;
    }

    /**
     * Sets the serie for the bill (6 digits)
     * branch of the stab
     *
     * @param serie
     */
    public void setSerie(String serie) {
        if (serie.length() != digitsForSerie) {
            throw new IllegalArgumentException(INCORRECT_LENGTH_STRING);
        }
        this.serie = serie;
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
     * @param billingSequential
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
     * @return
     */
    public String getIssueType() {
        return issueType;
    }

    /**
     * Sets the type of emission for the bill (1 digit)
     *
     * @param issueType
     */
    public void setIssueType(String issueType) {
        if (issueType.length() != digitsForIssueType) {
            throw new IllegalArgumentException(INCORRECT_LENGTH_STRING);
        }
        this.issueType = issueType;
    }
    // #endregion
}
