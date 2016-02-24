package com.rickhanberryfinal.webservices;

import com.rickhanberryfinal.entities.Vendor;
import com.rickhanberryfinal.repository.VendorRepository;
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
    private VendorRepository vendorRepository;

    /**
     * POST  /vendors -> Create a new vendor.
     */
    @RequestMapping(value = "/vendors", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Vendor> createVendor(@Valid @RequestBody Vendor vendor) throws URISyntaxException {

        //checks for valid vendor id, returns bad request if invalid. This prevents injection of non id type field
        if (vendor.getId() != null){
            return ResponseEntity.badRequest().body(null);
        }
        Vendor result = vendorRepository.save(vendor);
        return ResponseEntity.created(new URI("/api/vendors/" + result.getId())).body(result);
    }

    /**
     * PUT  /vendors -> Updates vendor.
     */
    @RequestMapping(value = "/vendors", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Vendor> updateVendor(@Valid @RequestBody Vendor vendor) throws URISyntaxException {

        //checks for valid vendor id, returns bad request if invalid. This prevents injection of non id type field
        if (vendor.getId() != null){
            return ResponseEntity.badRequest().body(null);
        }

        Vendor result = vendorRepository.save(vendor);
        return ResponseEntity.created(new URI("/api/vendors/" + result.getId())).body(result);
    }

    /**
     * GET  /vendors -> get all the vendors. Should be self explanatory.
     */
    @RequestMapping(value = "/vendors", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Vendor> getAllVendors() {
        return vendorRepository.findAll();
    }

    /**
     * GET  /vendors/:id -> get a specific vendor by its ID.
     */
    @RequestMapping(value = "/vendors/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Vendor> getVendor(@PathVariable Long id) {
        Vendor vendor = vendorRepository.findOne(id);
        return Optional.ofNullable(vendor)
                .map(result -> new ResponseEntity<>(
                        result,
                        HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    /**
     * DELETE  /vendors/:id -> delete vendor by its specific id.
     */
    @RequestMapping(value = "/vendors/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> deleteVendor(@PathVariable Long id) {
        vendorRepository.delete(id);
        return ResponseEntity.ok().build();
    }
}
