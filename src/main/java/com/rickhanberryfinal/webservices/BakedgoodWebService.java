package com.rickhanberryfinal.webservices;

import com.rickhanberryfinal.entities.Bakedgood;
import com.rickhanberryfinal.services.BakedgoodService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

/**
 * Created by rhanberry on 2/23/2016.
 *
 * REST Controller for the baked good entity
 */

@RestController
@RequestMapping("/api")
public class BakedgoodWebService {


    @Inject
    private BakedgoodService bakedgoodService;

    /**
     * POST  /bakedgoods -> Create a new bakedgood.
     */
    @RequestMapping(value = "/bakedgoods",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Bakedgood> createBakedgood(@Valid @RequestBody Bakedgood bakedgood) throws URISyntaxException {
        if (bakedgood.getId() != null) {
            return ResponseEntity.badRequest().body(null);
        }
        Bakedgood result = bakedgoodService.save(bakedgood);
        return ResponseEntity.created(new URI("/api/bakedgoods/" + result.getId()))
                .body(result);
    }

    /**
     * PUT  /bakedgoods -> Updates an existing bakedgood.
     */
    @RequestMapping(value = "/bakedgoods",
            method = RequestMethod.PUT,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Bakedgood> updateBakedgood(@Valid @RequestBody Bakedgood bakedgood) throws URISyntaxException {
        if (bakedgood.getId() == null) {
            return createBakedgood(bakedgood);
        }
        Bakedgood result = bakedgoodService.save(bakedgood);
        return ResponseEntity.ok()
                .body(result);
    }

    /**
     * GET  /bakedgoods -> get all the bakedgoods.
     */
    @RequestMapping(value = "/bakedgoods",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Bakedgood> getAllBakedgoods() {
        return bakedgoodService.findAll();
    }

    /**
     * GET  /bakedgoods/:id -> get the "id" bakedgood.
     */
    @RequestMapping(value = "/bakedgoods/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Bakedgood> getBakedgood(@PathVariable Long id) {
        Bakedgood bakedgood = bakedgoodService.findOne(id);
        return Optional.ofNullable(bakedgood)
                .map(result -> new ResponseEntity<>(
                        result,
                        HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    /**
     * DELETE  /bakedgoods/:id -> delete the "id" bakedgood.
     */
    @RequestMapping(value = "/bakedgoods/{id}",
            method = RequestMethod.DELETE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> deleteBakedgood(@PathVariable Long id) {
        bakedgoodService.delete(id);
        return ResponseEntity.ok().build();
    }
}
