package com.co.ke.walletservice.moneypal.wrapper;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;

@Data
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@id", scope = PaymentRequestPayloadFromRQM.class)
public class PaymentRequestPayloadFromRQM {
    private Long id;
    private double payment_amount;
    private boolean status=false;
    private String userEmail_paidBy;
    private String userEmail_paidTo;
}
