package com.thinkconstructive.rest_demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="cloud_vendor_info")
public class CloudVendor {
    @Id
    private String vendorId;
    private String vendorName;
    private String vendorAddress;
    private String vendorPhoneNumber;
    private String isDisabled;

    public CloudVendor() {
    }


    public CloudVendor(String vendorId, String vendorPhoneNumber, String vendorAddress, String vendorName, String isDisabled) {
        this.vendorId = vendorId;
        this.vendorPhoneNumber = vendorPhoneNumber;
        this.vendorAddress = vendorAddress;
        this.vendorName = vendorName;
        this.isDisabled= isDisabled;
    }

    public void setVendorId(String vendorId) {
        this.vendorId = vendorId;
    }

    public void setVendorPhoneNumber(String vendorPhoneNumber) {
        this.vendorPhoneNumber = vendorPhoneNumber;
    }

    public void setVendorAddress(String vendorAddress) {
        this.vendorAddress = vendorAddress;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

    public void setIsDisabled(String isDisabled) {
        this.isDisabled = isDisabled;
    }

    public String getIsDisabled() {
        return isDisabled;
    }

    public String getVendorPhoneNumber() {
        return vendorPhoneNumber;
    }

    public String getVendorAddress() {
        return vendorAddress;
    }

    public String getVendorName() {
        return vendorName;
    }

    public String getVendorId() {
        return vendorId;
    }





}
