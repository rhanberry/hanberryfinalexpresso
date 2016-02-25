package com.rickhanberryfinal.webservices;

import com.rickhanberryfinal.entities.Unitofmeasure;
import com.rickhanberryfinal.services.UnitofmeasureService;
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
 * REST controller for managing Unitofmeasure.
 */

@RestController
@RequestMapping("/api")
public class UnitofmeasureWebService {

    @Autowired
    private UnitofmeasureService unitofmeasureService;

    /**
     * POST  /unitofmeasures -> Create a new unitofmeasure.
     */
    @RequestMapping(value = "/unitofmeasures",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Unitofmeasure> createUnitofmeasure(@Valid @RequestBody Unitofmeasure unitofmeasure) throws URISyntaxException {
        if (unitofmeasure.getId() != null) {
            return ResponseEntity.badRequest().body(null);
        }
        Unitofmeasure result = unitofmeasureService.save(unitofmeasure);
        return ResponseEntity.created(new URI("/api/unitofmeasures/" + result.getId()))
                .body(result);
    }

    /**
     * PUT  /unitofmeasures -> Updates an existing unitofmeasure.
     */
    @RequestMapping(value = "/unitofmeasures",
            method = RequestMethod.PUT,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Unitofmeasure> updateUnitofmeasure(@Valid @RequestBody Unitofmeasure unitofmeasure) throws URISyntaxException {
        if (unitofmeasure.getId() == null) {
            return createUnitofmeasure(unitofmeasure);
        }
        Unitofmeasure result = unitofmeasureService.save(unitofmeasure);
        return ResponseEntity.ok()
                .body(result);
    }

    /**
     * GET  /unitofmeasures -> get all the unitofmeasures.
     */
    @RequestMapping(value = "/unitofmeasures",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Unitofmeasure> getAllUnitofmeasures() {
        return unitofmeasureService.findAll();
    }

    /**
     * GET  /unitofmeasures/:id -> get the "id" unitofmeasure.
     */
    @RequestMapping(value = "/unitofmeasures/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Unitofmeasure> getUnitofmeasure(@PathVariable Long id) {
        Unitofmeasure unitofmeasure = unitofmeasureService.findOne(id);
        return Optional.ofNullable(unitofmeasure)
                .map(result -> new ResponseEntity<>(
                        result,
                        HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    /**
     * DELETE  /unitofmeasures/:id -> delete the "id" unitofmeasure.
     */
    @RequestMapping(value = "/unitofmeasures/{id}",
            method = RequestMethod.DELETE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> deleteUnitofmeasure(@PathVariable Long id) {
        unitofmeasureService.delete(id);
        return ResponseEntity.ok().build();
    }

}
