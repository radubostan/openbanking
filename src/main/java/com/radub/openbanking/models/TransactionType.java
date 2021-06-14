package com.radub.openbanking.models;

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
