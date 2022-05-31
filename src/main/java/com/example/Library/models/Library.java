package com.example.Library.models;

import org.apache.logging.log4j.core.util.UuidUtil;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Document
public class Library {

    @Id
    private UUID libraryId;
    private String libraryName;
    private Address libraryAddress;
    private Mobile mobileNumber;

    public Library() {
        this.libraryId= UuidUtil.getTimeBasedUuid();
    }

    public UUID getLibraryId() {
        return libraryId;
    }

    public void setLibraryId(UUID libraryId) {
        this.libraryId = libraryId;
    }

    public Address getLibraryAddress() {
        return libraryAddress;
    }

    public void setLibraryAddress(Address libraryAddress) {
        this.libraryAddress = libraryAddress;
    }

    public String getLibraryName() {
        return libraryName;
    }

    public void setLibraryName(String libraryName) {
        this.libraryName = libraryName;
    }

    public Mobile getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(Mobile mobileNumber) {
        this.mobileNumber = mobileNumber;
    }



}
