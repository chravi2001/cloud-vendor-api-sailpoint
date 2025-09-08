package com.sailpointiiq.rest_demo.controller;

import com.sailpointiiq.rest_demo.model.CloudVendor;
import com.sailpointiiq.rest_demo.service.CloudVendorService;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/cloudvendor")
public class CloudVendorController
{
    CloudVendorService CloudVendorService;

    public CloudVendorController(CloudVendorService cloudVendorService) {
        CloudVendorService = cloudVendorService;
    }



    @GetMapping("{vendorId}")
    public CloudVendor getCloudVendorDetails(@PathVariable("vendorId") String vendorId) {

        return CloudVendorService.getCloudVendor(vendorId);
    }

    @GetMapping()
    public Map<String, List<CloudVendor>> getAllCloudVendorDetails() {
        List<CloudVendor> vendors = CloudVendorService.getAllCloudVendors();

        Map<String, List<CloudVendor>> response = new HashMap<>();
        response.put("users", vendors);

        return response;
    }

    @PostMapping
    public String createCloudVendorDetails(@RequestBody CloudVendor cloudVendor) {
        CloudVendorService.createCloudVendor(cloudVendor);
        return "Cloud Vendor Created Successfully!";
    }

    @PutMapping
    public String updateCloudVendorDetails(@RequestBody CloudVendor cloudVendor) {
        CloudVendorService.updateCloudVendor(cloudVendor);
        return "Cloud Vendor Updated Successfully!";
    }

    @PutMapping("/disable")
    public String disableCloudVendorDetails(@RequestBody CloudVendor cloudVendor) {
        CloudVendorService.disableCloudVendor(cloudVendor);
        return "Cloud Vendor disabled Successfully!";
    }

    @DeleteMapping("{vendorId}")
    public String deleteCloudVendorDetails(@PathVariable("vendorId") String vendorId) {
        CloudVendorService.deleteCloudVendor(vendorId);
        return "Cloud Vendor Deleted Successfully!";
    }
}
