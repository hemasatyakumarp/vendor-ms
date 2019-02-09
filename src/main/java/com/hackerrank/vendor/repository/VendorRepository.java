package com.hackerrank.vendor.repository;

import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hackerrank.vendor.model.Vendor;


@Repository("vendorRepository")
public interface VendorRepository extends JpaRepository<Vendor, Long> {
    @Transactional
    Long deleteById(Long id);
}
