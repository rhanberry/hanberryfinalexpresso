package com.rickhanberryfinal.webservices;

import com.rickhanberryfinal.entities.BakeryCategory;
import com.rickhanberryfinal.services.BakeryCategoryService;
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
 * REST controller for the bakeryCategory entity, provides CRUD web service layer for categories
 */

@RestController
@RequestMapping("/api")
public class BakeryCategoryWebService {


    @Autowired
    private BakeryCategoryService bakeryCategoryService;

    /**
     * POST  /bakeryCategorys -> Create a new bakeryCategory.
     */
    @RequestMapping(value = "/bakeryCategorys",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BakeryCategory> createBakeryCategory(@Valid @RequestBody BakeryCategory bakeryCategory) throws URISyntaxException {
        if (bakeryCategory.getId() != null) {
            return ResponseEntity.badRequest().body(null);
        }
        BakeryCategory result = bakeryCategoryService.save(bakeryCategory);
        return ResponseEntity.created(new URI("/api/bakeryCategorys/" + result.getId()))
                .body(result);
    }

    /**
     * PUT  /bakeryCategorys -> Updates an existing bakeryCategory.
     */
    @RequestMapping(value = "/bakeryCategorys",
            method = RequestMethod.PUT,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BakeryCategory> updateBakeryCategory(@Valid @RequestBody BakeryCategory bakeryCategory) throws URISyntaxException {
        if (bakeryCategory.getId() == null) {
            return createBakeryCategory(bakeryCategory);
        }
        BakeryCategory result = bakeryCategoryService.save(bakeryCategory);
        return ResponseEntity.ok()
                .body(result);
    }

    /**
     * GET  /bakeryCategorys -> get all the bakeryCategorys.
     */
    @RequestMapping(value = "/bakeryCategorys",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List<BakeryCategory> getAllBakeryCategorys() {
        return bakeryCategoryService.findAll();
    }

    /**
     * GET  /bakeryCategorys/:id -> get the "id" bakeryCategory.
     */
    @RequestMapping(value = "/bakeryCategorys/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BakeryCategory> getBakeryCategory(@PathVariable Long id) {
        BakeryCategory bakeryCategory = bakeryCategoryService.findOne(id);
        return Optional.ofNullable(bakeryCategory)
                .map(result -> new ResponseEntity<>(
                        result,
                        HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    /**
     * DELETE  /bakeryCategorys/:id -> delete the "id" bakeryCategory.
     */
    @RequestMapping(value = "/bakeryCategorys/{id}",
            method = RequestMethod.DELETE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> deleteBakeryCategory(@PathVariable Long id) {
        bakeryCategoryService.delete(id);
        return ResponseEntity.ok().build();
    }
}
