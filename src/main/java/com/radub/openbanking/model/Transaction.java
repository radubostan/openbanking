package com.radub.openbanking.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Transaction {
    private TransactionType type;
    private Date date;
    private String accountNumber;
    private Currency currency;
    private BigDecimal amount;
    private String merchantName;
    private byte[] merchantLogo;
}
