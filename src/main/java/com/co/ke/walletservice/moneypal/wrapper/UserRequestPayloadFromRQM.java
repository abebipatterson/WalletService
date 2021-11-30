package com.co.ke.walletservice.moneypal.wrapper;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;

import java.util.UUID;

@Data
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@id", scope = UserRequestPayloadFromRQM.class)
public class UserRequestPayloadFromRQM {
    private UUID id;
    private String firstName;
    private String lastName;
    private String email;
    private String userName;
    private String password;
}
