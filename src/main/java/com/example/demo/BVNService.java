package com.example.demo;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import lombok.Builder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BVNService {

    BankVerificationNumber number;

    BVNRepo repo;


    public BVNDTO saveBVN(BVNDTO bvndto, String bvn) throws UnirestException {

        if (bvn.length() != 11){      String token = "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2MDM1MzJmOWI3MjdjNjA5NjJjNzJmNTYiLCJpYXQiOjE2MTQwOTkxOTN9.hpnEHBNGlY4AKoB2eM3ChqwaXmG0Ec_OWKYqzy24P_k";

            HttpResponse<String> response = Unirest.post("https://api.okra.ng/v2/products/kyc/bvn-verify")
                    .header("Accept", "application/x-www-form-urlencoded")
                    .header("Content-Type", "application/x-www-form-urlencoded")
                    .header("Authorization", token)
                    .body(bvn)
                    .asString();
        }
            BankVerificationNumber verificationNumber = new BankVerificationNumber();
            verificationNumber.setName(bvndto.getName());
            verificationNumber.setNumber(bvndto.getNumber());

            repo.save(verificationNumber);

        //  hide variables
        return buildResponse(verificationNumber);
    }

    private BVNDTO buildResponse(BankVerificationNumber number){
        return BVNDTO.builder()
                .name(number.getName())
                .number(number.getNumber())
                .build();
    }


}
