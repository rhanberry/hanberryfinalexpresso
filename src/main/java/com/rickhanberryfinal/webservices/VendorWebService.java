package com.rickhanberryfinal.webservices;

import com.rickhanberryfinal.entities.Vendor;
import com.rickhanberryfinal.services.VendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;


/**
 * Created by rhanberry on 2/23/2016.
 *
 * This is the REST controller for the Vendor entity
 */

@RestController
@RequestMapping("/api")
public class VendorWebService {


    @Autowired
    private VendorService vendorService;

    /**
     * POST  /vendors -> Create a new vendor.
     */
    @RequestMapping(value = "/vendors",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Vendor> createVendor(@Valid @RequestBody Vendor vendor) throws URISyntaxException {
        if (vendor.getId() != null) {
            return ResponseEntity.badRequest().body(null);
        }
        Vendor result = vendorService.save(vendor);
        return ResponseEntity.created(new URI("/api/vendors/" + result.getId()))
                .body(result);
    }

    /**
     * PUT  /vendors -> Updates an existing vendor.
     */
    @RequestMapping(value = "/vendors",
            method = RequestMethod.PUT,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Vendor> updateVendor(@Valid @RequestBody Vendor vendor) throws URISyntaxException {
        if (vendor.getId() == null) {
            return createVendor(vendor);
        }
        Vendor result = vendorService.save(vendor);
        return ResponseEntity.ok()
                .body(result);
    }

    /**
     * GET  /vendors -> get all the vendors.
     */
    @RequestMapping(value = "/vendors",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Vendor> getAllVendors() {
        return vendorService.findAll();
    }

    /**
     * GET  /vendors/:id -> get the "id" vendor.
     */
    @RequestMapping(value = "/vendors/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Vendor> getVendor(@PathVariable Long id) {
        Vendor vendor = vendorService.findOne(id);
        return Optional.ofNullable(vendor)
                .map(result -> new ResponseEntity<>(
                        result,
                        HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    /**
     * DELETE  /vendors/:id -> delete the "id" vendor.
     */
    @RequestMapping(value = "/vendors/{id}",
            method = RequestMethod.DELETE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> deleteVendor(@PathVariable Long id) {
        vendorService.delete(id);
        return ResponseEntity.ok().build();
    }
}
