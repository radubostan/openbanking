package com.radub.openbanking.model;

public enum TransactionType {
    SAVINGS("Savings"),
    DIRECT_DEPOSIT("DirectDeposit");

	private String value;

    TransactionType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
