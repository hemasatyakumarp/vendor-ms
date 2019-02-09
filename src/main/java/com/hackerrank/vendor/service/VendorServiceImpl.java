package com.hackerrank.vendor.service;

import com.hackerrank.vendor.exception.BadResourceRequestException;
import com.hackerrank.vendor.exception.NoSuchResourceFoundException;
import com.hackerrank.vendor.model.Vendor;
import com.hackerrank.vendor.repository.VendorRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("vendorService")
public class VendorServiceImpl implements VendorService {
    @Autowired
    private VendorRepository vendorRepository;

    @Override
    public void deleteAllVendors() {
        vendorRepository.deleteAllInBatch();
    }

    @Override
    public Boolean deleteVendorById(Long id) {
    	 Vendor Vendor = vendorRepository.findOne(id);

         if (Vendor == null) {
             return null;
         }
         
        vendorRepository.deleteById(id);
        return true;
    }

    @Override
    public Vendor createVendor(Vendor vendor) {
        Vendor existingVendor = vendorRepository.findOne(vendor.getId());

        if (existingVendor != null) {
            throw new BadResourceRequestException("Vendor with same id exists.");
        }

        vendorRepository.save(vendor);
        return existingVendor;
    }
    
    @Override
    public Vendor updateVendor(Long vendorId, Vendor vendor) {
        
        Vendor tempVendor = vendorRepository.findOne(vendorId);

        if (tempVendor == null) {
            return null;
        }
       
        vendorRepository.save(vendor);
        return vendorRepository.findOne(vendorId);
        
    }

    @Override
    public Vendor getVendorById(Long id) {
        Vendor Vendor = vendorRepository.findOne(id);

        if (Vendor == null) {
            throw new NoSuchResourceFoundException("No Vendor with given id found.");
        }

        return Vendor;
    }

    @Override
    public List<Vendor> getAllVendors() {
        return vendorRepository.findAll();
    }
}
