package com.co.ke.walletservice.moneypal.service;

import com.co.ke.walletservice.moneypal.wrapper.PaymentRequestPayloadFromRQM;
import com.co.ke.walletservice.moneypal.wrapper.UserRequestPayloadFromRQM;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQNew {

    @Autowired
    private WalletService walletService;


    @RabbitListener(queues = "${queueNameUser}")
    public void recievedMessage(UserRequestPayloadFromRQM userRequestPayloadFromRQM) {
        System.out.println("Recieved Message From RabbitMQ: " + userRequestPayloadFromRQM);
        System.out.println("ID"+userRequestPayloadFromRQM.getId());
        System.out.println("EMAIL"+userRequestPayloadFromRQM.getEmail());

        //create wallet
        walletService.createWallet(userRequestPayloadFromRQM.getEmail());

        System.out.println("WALLET CREATED");

    }

    @RabbitListener(queues = "paymentservice.queue")
    public void recievedMessage1(PaymentRequestPayloadFromRQM paymentRequestPayloadFromRQM) {
        System.out.println("Recieved Message From RabbitMQ: " + paymentRequestPayloadFromRQM);
        System.out.println("ID : "+paymentRequestPayloadFromRQM.getId());
        System.out.println("EMAIL : "+paymentRequestPayloadFromRQM.getUserEmail_paidBy());

        // top up the wallet
        walletService.fundWallet(paymentRequestPayloadFromRQM.getUserEmail_paidBy(), paymentRequestPayloadFromRQM.getPayment_amount());

        System.out.println("WALLET TOP UP SUCCESSFUL");

    }


    @RabbitListener(queues = "paymentservicebilling.queue")
    public void recievedMessageForBilling(PaymentRequestPayloadFromRQM paymentRequestPayloadFromRQM) {
        System.out.println("Recieved Message From RabbitMQ: " + paymentRequestPayloadFromRQM);
        System.out.println("ID : "+paymentRequestPayloadFromRQM.getId());
        System.out.println("PAID BY : "+paymentRequestPayloadFromRQM.getUserEmail_paidBy());
        System.out.println("PAID TO : "+paymentRequestPayloadFromRQM.getUserEmail_paidTo());

        // wallet Billing here
        walletService.billingTotheWallet(paymentRequestPayloadFromRQM.getUserEmail_paidBy(),paymentRequestPayloadFromRQM.getUserEmail_paidTo(), (float) paymentRequestPayloadFromRQM.getPayment_amount());

        System.out.println("WALLET BILLING DONE SUCCESSFUL");




    }
}
