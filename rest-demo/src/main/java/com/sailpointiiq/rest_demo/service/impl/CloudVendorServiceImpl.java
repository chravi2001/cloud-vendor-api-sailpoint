package com.sailpointiiq.rest_demo.service.impl;

import com.sailpointiiq.rest_demo.model.CloudVendor;
import com.sailpointiiq.rest_demo.repository.CloudVendorRepository;
import com.sailpointiiq.rest_demo.service.CloudVendorService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CloudVendorServiceImpl implements CloudVendorService {

    CloudVendorRepository CloudVendorRepository;

    public CloudVendorServiceImpl(CloudVendorRepository cloudVendorRepository) {
        CloudVendorRepository = cloudVendorRepository;
    }


    @Override
    public String createCloudVendor(CloudVendor cloudVendor) {
        CloudVendorRepository.save(cloudVendor);
        return "Success";
    }

    @Override
    public String updateCloudVendor(CloudVendor cloudVendor) {
        CloudVendorRepository.save(cloudVendor);
        return "Success";
    }

    @Override
    public String disableCloudVendor(CloudVendor cloudVendor) {
        CloudVendorRepository.save(cloudVendor);
        return "Success";
    }

    @Override
    public String deleteCloudVendor(String cloudVendorId) {
        CloudVendorRepository.deleteById(cloudVendorId);
        return "";
    }

    @Override
    public CloudVendor getCloudVendor(String cloudVendorId) {
        return CloudVendorRepository.findById(cloudVendorId).get();
    }

    @Override
    public List<CloudVendor> getAllCloudVendors() {
        return CloudVendorRepository.findAll();
    }
}
