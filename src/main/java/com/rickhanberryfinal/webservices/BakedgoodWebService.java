package com.rickhanberryfinal.webservices;

import com.rickhanberryfinal.entities.BakedGood;
import com.rickhanberryfinal.services.BakedGoodService;
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
 * REST Controller for the baked good entity
 */

@RestController
@RequestMapping("/api")
public class BakedGoodWebService {


    @Autowired
    private BakedGoodService bakedGoodService;

    /**
     * POST  /bakedGoods -> Create a new bakedGood.
     */
    @RequestMapping(value = "/bakedGoods",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BakedGood> createBakedGood(@Valid @RequestBody BakedGood bakedGood) throws URISyntaxException {
        if (bakedGood.getId() != null) {
            return ResponseEntity.badRequest().body(null);
        }
        BakedGood result = bakedGoodService.save(bakedGood);
        return ResponseEntity.created(new URI("/api/bakedGoods/" + result.getId()))
                .body(result);
    }

    /**
     * PUT  /bakedGoods -> Updates an existing bakedGood.
     */
    @RequestMapping(value = "/bakedGoods",
            method = RequestMethod.PUT,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BakedGood> updateBakedGood(@Valid @RequestBody BakedGood bakedGood) throws URISyntaxException {
        if (bakedGood.getId() == null) {
            return createBakedGood(bakedGood);
        }
        BakedGood result = bakedGoodService.save(bakedGood);
        return ResponseEntity.ok()
                .body(result);
    }

    /**
     * GET  /bakedGoods -> get all the bakedGoods.
     */
    @RequestMapping(value = "/bakedGoods",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List<BakedGood> getAllBakedGoods() {
        return bakedGoodService.findAll();
    }

    /**
     * GET  /bakedGoods/:id -> get the "id" bakedGood.
     */
    @RequestMapping(value = "/bakedGoods/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BakedGood> getBakedGood(@PathVariable Long id) {
        BakedGood bakedGood = bakedGoodService.findOne(id);
        return Optional.ofNullable(bakedGood)
                .map(result -> new ResponseEntity<>(
                        result,
                        HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    /**
     * DELETE  /bakedGoods/:id -> delete the "id" bakedGood.
     */
    @RequestMapping(value = "/bakedGoods/{id}",
            method = RequestMethod.DELETE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> deleteBakedGood(@PathVariable Long id) {
        bakedGoodService.delete(id);
        return ResponseEntity.ok().build();
    }
}

