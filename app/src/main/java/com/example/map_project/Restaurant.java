package com.example.map_project;

import java.io.Serializable;

public class Restaurant implements Serializable {
    private String storeName;
    private String address;
    private String businessHours;
    private String holiday;
    private String otherDetails;

    // 생성자
    public Restaurant(String storeName, String address, String businessHours, String holiday, String otherDetails) {
        this.storeName = storeName;
        this.address = address;
        this.businessHours = businessHours;
        this.holiday = holiday;
        this.otherDetails = otherDetails;
    }

    // Getter와 Setter
    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBusinessHours() {
        return businessHours;
    }

    public void setBusinessHours(String businessHours) {
        this.businessHours = businessHours;
    }

    public String getHoliday() {
        return holiday;
    }

    public void setHoliday(String holiday) {
        this.holiday = holiday;
    }

    public String getOtherDetails() {
        return otherDetails;
    }

    public void setOtherDetails(String otherDetails) {
        this.otherDetails = otherDetails;
    }
}
