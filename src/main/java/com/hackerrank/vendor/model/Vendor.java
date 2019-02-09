package com.hackerrank.vendor.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;

@Entity
public class Vendor implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue
    private Long id;
    private String vendorName;
    private Long vendorContactNo;
    private String vendorEmail;
    private String vendorAddress;

    public Vendor() {
    }

	public Long getId() {
		return id;
	}

	public void setId(Long vendorId) {
		this.id = vendorId;
	}

	public String getVendorName() {
		return vendorName;
	}

	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}

	public Long getVendorContactNo() {
		return vendorContactNo;
	}

	public void setVendorContactNo(Long vendorContactNo) {
		this.vendorContactNo = vendorContactNo;
	}

	public String getVendorEmail() {
		return vendorEmail;
	}

	public void setVendorEmail(String vendorEmail) {
		this.vendorEmail = vendorEmail;
	}

	public String getVendorAddress() {
		return vendorAddress;
	}

	public void setVendorAddress(String vendorAddress) {
		this.vendorAddress = vendorAddress;
	}

    

    
}
