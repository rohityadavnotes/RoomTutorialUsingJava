package com.room.tutorial.using.java.local.entity;

import androidx.room.ColumnInfo;

public class Address {

    @ColumnInfo(name = "street")
    public String street;

    @ColumnInfo(name = "state")
    public String state;

    @ColumnInfo(name = "city")
    public String city;

    @ColumnInfo(name = "post_code")
    public int postCode;

    public Address(String street, String state, String city, int postCode) {
        this.street = street;
        this.state = state;
        this.city = city;
        this.postCode = postCode;
    }

    @Override
    public String toString() {
        return "Address{" +
                "street='" + street + '\'' +
                ", state='" + state + '\'' +
                ", city='" + city + '\'' +
                ", postCode=" + postCode +
                '}';
    }
}