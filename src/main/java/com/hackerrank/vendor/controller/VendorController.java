package com.hackerrank.vendor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.hackerrank.vendor.service.VendorServiceImpl;
import com.hackerrank.vendor.model.*;

@RestController
//@RequestMapping("/tcs/hack/v1")
public class VendorController {

	@Autowired
	private VendorServiceImpl service;

	@RequestMapping(value = "/vendor", method = RequestMethod.GET)
	public ResponseEntity<List<Vendor>> getAllVendors() {
		List<Vendor> list = service.getAllVendors();
		if (list == null) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(list, HttpStatus.OK);

	}

	@RequestMapping(value = "/vendor/{id}", method = RequestMethod.GET)
	public ResponseEntity<Vendor> getVendor(@PathVariable("id") Long vendorId) {
		Vendor c = service.getVendorById(vendorId);
		if (c == null) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(c, HttpStatus.OK);

	}

	@RequestMapping(value = "/vendor", method = RequestMethod.POST)
	public ResponseEntity<Vendor> createVendor(@RequestBody Vendor vendor) {

		return new ResponseEntity(service.createVendor(vendor), HttpStatus.CREATED);
	}

	@RequestMapping(value = "/vendor", method = RequestMethod.PUT)
	public ResponseEntity<Vendor> updateVendor(@PathVariable("id") Long vendorId,@RequestBody Vendor vendor) {

		Vendor c = service.updateVendor(vendorId,vendor);
		if (c == null) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(c, HttpStatus.OK);

	}

	@RequestMapping(value = "/vendor/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteVendor(@PathVariable("id") Long id) {
		Boolean b = service.deleteVendorById(id);
		if (b) {
			return new ResponseEntity("Vendor Deleted", HttpStatus.OK);
		}

		return new ResponseEntity("Vendor Not Found", HttpStatus.NOT_FOUND);
	}

	@RequestMapping(value = "/vendor", method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteAllVendor() {
		service.deleteAllVendors();
		return new ResponseEntity("Vendors Deleted", HttpStatus.OK);
	}

}
