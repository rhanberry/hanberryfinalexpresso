package com.rickhanberryfinal.webservices;

import com.rickhanberryfinal.entities.DrinkRecipe;
import com.rickhanberryfinal.services.DrinkRecipeService;
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
public class DrinkRecipeWebService {


    @Autowired
    private DrinkRecipeService drinkRecipeService;

    /**
     * POST  /drinkRecipes -> Create a new drinkRecipe.
     */
    @RequestMapping(value = "/drinkRecipes",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DrinkRecipe> createDrinkRecipe(@Valid @RequestBody DrinkRecipe drinkRecipe) throws URISyntaxException {
        if (drinkRecipe.getId() != null) {
            return ResponseEntity.badRequest().body(null);
        }
        DrinkRecipe result = drinkRecipeService.save(drinkRecipe);
        return ResponseEntity.created(new URI("/api/drinkRecipes/" + result.getId()))
                .body(result);
    }

    /**
     * PUT  /drinkRecipes -> Updates an existing drinkRecipe.
     */
    @RequestMapping(value = "/drinkRecipes",
            method = RequestMethod.PUT,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DrinkRecipe> updateDrinkRecipe(@Valid @RequestBody DrinkRecipe drinkRecipe) throws URISyntaxException {
        if (drinkRecipe.getId() == null) {
            return createDrinkRecipe(drinkRecipe);
        }
        DrinkRecipe result = drinkRecipeService.save(drinkRecipe);
        return ResponseEntity.ok()
                .body(result);
    }

    /**
     * GET  /drinkRecipes -> get all the drinkRecipes.
     */
    @RequestMapping(value = "/drinkRecipes",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List<DrinkRecipe> getAllDrinkRecipes() {
        return drinkRecipeService.findAll();
    }

    /**
     * GET  /drinkRecipes/:id -> get the "id" drinkRecipe.
     */
    @RequestMapping(value = "/drinkRecipes/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DrinkRecipe> getDrinkRecipe(@PathVariable Long id) {
        DrinkRecipe drinkRecipe = drinkRecipeService.findOne(id);
        return Optional.ofNullable(drinkRecipe)
                .map(result -> new ResponseEntity<>(
                        result,
                        HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    /**
     * DELETE  /drinkRecipes/:id -> delete the "id" drinkRecipe.
     */
    @RequestMapping(value = "/drinkRecipes/{id}",
            method = RequestMethod.DELETE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> deleteDrinkRecipe(@PathVariable Long id) {
        drinkRecipeService.delete(id);
        return ResponseEntity.ok().build();
    }
}
