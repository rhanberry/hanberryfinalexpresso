package com.rickhanberryfinal.webservices;

import com.rickhanberryfinal.entities.Ingredients;
import com.rickhanberryfinal.repository.IngredientsRepository;
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
 * REST Controller for the ingredients entity
 */

@RestController
@RequestMapping("/api")
public class IngredientsWebService {

    @Autowired
    private IngredientsRepository ingredientsRepository;

    /**
     * POST  /ingredientss -> Create a new ingredients.
     */
    @RequestMapping(value = "/ingredientss", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Ingredients> createIngredients(@Valid @RequestBody Ingredients ingredients) throws URISyntaxException {
        if (ingredients.getId() != null) {
            return ResponseEntity.badRequest().body(null);
        }
        Ingredients result = ingredientsRepository.save(ingredients);
        return ResponseEntity.created(new URI("/api/ingredientss/" + result.getId())).body(result);
    }

    /**
     * PUT  /ingredientss -> Updates an existing ingredients.
     */
    @RequestMapping(value = "/ingredientss", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Ingredients> updateIngredients(@Valid @RequestBody Ingredients ingredients) throws URISyntaxException {
        if (ingredients.getId() == null) {
            return createIngredients(ingredients);
        }
        Ingredients result = ingredientsRepository.save(ingredients);
        return ResponseEntity.ok().body(result);
    }

    /**
     * GET  /ingredientss -> get all the ingredientss.
     */
    @RequestMapping(value = "/ingredientss", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Ingredients> getAllIngredientss() {
        return ingredientsRepository.findAll();
    }

    /**
     * GET  /ingredientss/:id -> get the "id" ingredients.
     */
    @RequestMapping(value = "/ingredientss/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Ingredients> getIngredients(@PathVariable Long id) {
        Ingredients ingredients = ingredientsRepository.findOne(id);
        return Optional.ofNullable(ingredients)
                .map(result -> new ResponseEntity<>(
                        result,
                        HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    /**
     * DELETE  /ingredientss/:id -> delete the "id" ingredients.
     */
    @RequestMapping(value = "/ingredientss/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> deleteIngredients(@PathVariable Long id) {
        ingredientsRepository.delete(id);
        return ResponseEntity.ok().build();
    }


}
