package com.rickhanberryfinal.webservices;

import com.rickhanberryfinal.entities.UnitOfMeasure;
import com.rickhanberryfinal.services.UnitOfMeasureService;
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
 * Created by rhanberry on 2/24/2016.
 *
 * REST controller for managing UnitOfMeasure.
 */

@RestController
@RequestMapping("/api")
public class UnitOfMeasureWebService {


    @Autowired
    private UnitOfMeasureService unitOfMeasureService;

    /**
     * POST  /unitOfMeasures -> Create a new unitOfMeasure.
     */
    @RequestMapping(value = "/unitOfMeasures",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UnitOfMeasure> createUnitOfMeasure(@Valid @RequestBody UnitOfMeasure unitOfMeasure) throws URISyntaxException {
        if (unitOfMeasure.getId() != null) {
            return ResponseEntity.badRequest().body(null);
        }
        UnitOfMeasure result = unitOfMeasureService.save(unitOfMeasure);
        return ResponseEntity.created(new URI("/api/unitOfMeasures/" + result.getId()))
                .body(result);
    }

    /**
     * PUT  /unitOfMeasures -> Updates an existing unitOfMeasure.
     */
    @RequestMapping(value = "/unitOfMeasures",
            method = RequestMethod.PUT,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UnitOfMeasure> updateUnitOfMeasure(@Valid @RequestBody UnitOfMeasure unitOfMeasure) throws URISyntaxException {
        if (unitOfMeasure.getId() == null) {
            return createUnitOfMeasure(unitOfMeasure);
        }
        UnitOfMeasure result = unitOfMeasureService.save(unitOfMeasure);
        return ResponseEntity.ok()
                .body(result);
    }

    /**
     * GET  /unitOfMeasures -> get all the unitOfMeasures.
     */
    @RequestMapping(value = "/unitOfMeasures",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List<UnitOfMeasure> getAllUnitOfMeasures() {
        return unitOfMeasureService.findAll();
    }

    /**
     * GET  /unitOfMeasures/:id -> get the "id" unitOfMeasure.
     */
    @RequestMapping(value = "/unitOfMeasures/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UnitOfMeasure> getUnitOfMeasure(@PathVariable Long id) {
        UnitOfMeasure unitOfMeasure = unitOfMeasureService.findOne(id);
        return Optional.ofNullable(unitOfMeasure)
                .map(result -> new ResponseEntity<>(
                        result,
                        HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    /**
     * DELETE  /unitOfMeasures/:id -> delete the "id" unitOfMeasure.
     */
    @RequestMapping(value = "/unitOfMeasures/{id}",
            method = RequestMethod.DELETE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> deleteUnitOfMeasure(@PathVariable Long id) {
        unitOfMeasureService.delete(id);
        return ResponseEntity.ok().build();
    }
}
