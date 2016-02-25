package com.rickhanberryfinal.webservices;

import com.rickhanberryfinal.entities.Allergen;
import com.rickhanberryfinal.services.AllergenService;
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
 * REST Controller for allergen entity
 */

@RestController
@RequestMapping("/api")
public class AllergenWebService {

//autowires service layer.  Before I had it autowire the repository interface, which worked OK, lets see if this works
    @Autowired
    private AllergenService allergenService;

    /**
     * POST  /allergens -> Create a new allergen.
     */
    @RequestMapping(value = "/allergens",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Allergen> createAllergen(@Valid @RequestBody Allergen allergen) throws URISyntaxException {
        if (allergen.getId() != null) {
            return ResponseEntity.badRequest().body(null);
        }
        Allergen result = allergenService.save(allergen);
        return ResponseEntity.created(new URI("/api/allergens/" + result.getId()))
                .body(result);
    }

    /**
     * PUT  /allergens -> Updates an existing allergen.
     */
    @RequestMapping(value = "/allergens",
            method = RequestMethod.PUT,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Allergen> updateAllergen(@Valid @RequestBody Allergen allergen) throws URISyntaxException {
        if (allergen.getId() == null) {
            return createAllergen(allergen);
        }
        Allergen result = allergenService.save(allergen);
        return ResponseEntity.ok()
                .body(result);
    }

    /**
     * GET  /allergens -> get all the allergens.
     */
    @RequestMapping(value = "/allergens",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Allergen> getAllAllergens() {
        return allergenService.findAll();
    }

    /**
     * GET  /allergens/:id -> get the "id" allergen.
     */
    @RequestMapping(value = "/allergens/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Allergen> getAllergen(@PathVariable Long id) {
        Allergen allergen = allergenService.findOne(id);
        return Optional.ofNullable(allergen)
                .map(result -> new ResponseEntity<>(
                        result,
                        HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    /**
     * DELETE  /allergens/:id -> delete the "id" allergen.
     */
    @RequestMapping(value = "/allergens/{id}",
            method = RequestMethod.DELETE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> deleteAllergen(@PathVariable Long id) {
        allergenService.delete(id);
        return ResponseEntity.ok().build();
    }
}