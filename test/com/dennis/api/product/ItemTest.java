package com.dennis.api.product;

import org.junit.jupiter.api.Assertions;

import static org.junit.jupiter.api.Assertions.*;

class ItemTest {

    @org.junit.jupiter.api.Test
    void systemOut() {
        Item s=new Item();
        String s3=s.systemOut();
        String s2="Hell";
        Assertions.assertEquals(s.systemOut(),s2);
    }

    @org.junit.jupiter.api.Test
    void add() {
    }
}