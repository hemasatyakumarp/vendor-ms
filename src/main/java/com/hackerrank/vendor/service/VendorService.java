package com.hackerrank.vendor.service;

import com.hackerrank.vendor.model.Vendor;
import java.util.List;

public interface VendorService {
    void deleteAllVendors();
    Boolean deleteVendorById(Long vendorId);
    Vendor createVendor(Vendor vendor);
    Vendor getVendorById(Long id);
    List<Vendor> getAllVendors();
	Vendor updateVendor(Long vendorId, Vendor vendor);
}
