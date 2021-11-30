package com.co.ke.walletservice.moneypal.service;

import com.co.ke.walletservice.moneypal.wrapper.UserRequestPayloadFromRQM;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class RabbitMQListerner {
   // public class RabbitMQListerner implements MessageListener {

    @Autowired
    private WalletService walletService;

//    @Override
//    public void onMessage(Message message) {
//        System.out.println("Message consumed from RQM : "+message);
//        ObjectMapper objectMapper=new ObjectMapper();
//        try {
//            System.out.println("WE ARE HERE, READING MESSAGE BODY");
//            UserRequestPayloadFromRQM user=objectMapper.readValue(message.getBody(),UserRequestPayloadFromRQM.class);
//            System.out.println("user email : "+user.getEmail());
//            System.out.println("CREATE WALLET FOR THE USER");
//            try{
//                walletService.createWallet(user.getEmail());
//            }
//            catch (Exception ex){
//                ex.printStackTrace();
//            }
//
//            System.out.println("WALLET CREATED FOR THE USER  with email : "+user.getEmail());
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
}
