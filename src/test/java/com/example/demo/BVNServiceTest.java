package com.example.demo;

import com.mashape.unirest.http.exceptions.UnirestException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class BVNServiceTest {

    BVNService bvnService;
    BVNDTO bvndto;

    @BeforeEach
    void setUp() {
        bvnService = new BVNService();

    }

    @Test
    @DisplayName("Valid BVN in request payload")
    public void validBVN() throws UnirestException {
        bvndto = new BVNDTO("Name", "22446461412");
        assertEquals(bvndto, bvnService.saveBVN(bvndto, "22446461412"));
    }
}