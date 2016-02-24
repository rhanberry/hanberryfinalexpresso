package com.rickhanberryfinal.webservices;

import com.rickhanberryfinal.entities.Allergens;
import com.rickhanberryfinal.repository.AllergensRepository;
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
public class AllergensWebService {

    @Autowired
    private AllergensRepository allergensRepository;

    /**
     * POST  /allergenss -> Create a new allergens.
     */
    @RequestMapping(value = "/allergenss", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Allergens> createAllergens(@Valid @RequestBody Allergens allergens) throws URISyntaxException {
        if (allergens.getId() != null) {
            return ResponseEntity.badRequest().body(null);
        }
        Allergens result = allergensRepository.save(allergens);
        return ResponseEntity.created(new URI("/api/allergenss/" + result.getId()))
                .body(result);
    }

    /**
     * PUT  /allergenss -> Updates an existing allergens.
     */
    @RequestMapping(value = "/allergenss", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Allergens> updateAllergens(@Valid @RequestBody Allergens allergens) throws URISyntaxException {
        if (allergens.getId() == null) {
            return createAllergens(allergens);
        }
        Allergens result = allergensRepository.save(allergens);
        return ResponseEntity.ok().body(result);
    }

    /**
     * GET  /allergenss -> get all the allergenss.
     */
    @RequestMapping(value = "/allergenss", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Allergens> getAllAllergenss() {
        return allergensRepository.findAll();
    }

    /**
     * GET  /allergenss/:id -> get the "id" allergens.
     */
    @RequestMapping(value = "/allergenss/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Allergens> getAllergens(@PathVariable Long id) {
        Allergens allergens = allergensRepository.findOne(id);
        return Optional.ofNullable(allergens)
                .map(result -> new ResponseEntity<>(
                        result,
                        HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    /**
     * DELETE  /allergenss/:id -> delete the "id" allergens.
     */
    @RequestMapping(value = "/allergenss/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> deleteAllergens(@PathVariable Long id) {
        allergensRepository.delete(id);
        return ResponseEntity.ok().build();
    }

}
