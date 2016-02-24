package com.rickhanberryfinal.webservices;

import com.rickhanberryfinal.entities.Drinkrecipe;
import com.rickhanberryfinal.services.DrinkrecipeService;
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
 * REST Controller for the Drink Recipe entity
 */

@RestController
@RequestMapping("/api")
public class DrinkrecipeWebService {


    @Autowired
    private DrinkrecipeService drinkrecipeService;

    /**
     * POST  /drinkrecipes -> Create a new drinkrecipe.
     */
    @RequestMapping(value = "/drinkrecipes",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Drinkrecipe> createDrinkrecipe(@Valid @RequestBody Drinkrecipe drinkrecipe) throws URISyntaxException {
        if (drinkrecipe.getId() != null) {
            return ResponseEntity.badRequest().body(null);
        }
        Drinkrecipe result = drinkrecipeService.save(drinkrecipe);
        return ResponseEntity.created(new URI("/api/drinkrecipes/" + result.getId()))
                .body(result);
    }

    /**
     * PUT  /drinkrecipes -> Updates an existing drinkrecipe.
     */
    @RequestMapping(value = "/drinkrecipes",
            method = RequestMethod.PUT,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Drinkrecipe> updateDrinkrecipe(@Valid @RequestBody Drinkrecipe drinkrecipe) throws URISyntaxException {
        if (drinkrecipe.getId() == null) {
            return createDrinkrecipe(drinkrecipe);
        }
        Drinkrecipe result = drinkrecipeService.save(drinkrecipe);
        return ResponseEntity.ok()
                .body(result);
    }

    /**
     * GET  /drinkrecipes -> get all the drinkrecipes.
     */
    @RequestMapping(value = "/drinkrecipes",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Drinkrecipe> getAllDrinkrecipes() {
        return drinkrecipeService.findAll();
    }

    /**
     * GET  /drinkrecipes/:id -> get the "id" drinkrecipe.
     */
    @RequestMapping(value = "/drinkrecipes/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Drinkrecipe> getDrinkrecipe(@PathVariable Long id) {
        Drinkrecipe drinkrecipe = drinkrecipeService.findOne(id);
        return Optional.ofNullable(drinkrecipe)
                .map(result -> new ResponseEntity<>(
                        result,
                        HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    /**
     * DELETE  /drinkrecipes/:id -> delete the "id" drinkrecipe.
     */
    @RequestMapping(value = "/drinkrecipes/{id}",
            method = RequestMethod.DELETE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> deleteDrinkrecipe(@PathVariable Long id) {
        drinkrecipeService.delete(id);
        return ResponseEntity.ok().build();
    }
}
