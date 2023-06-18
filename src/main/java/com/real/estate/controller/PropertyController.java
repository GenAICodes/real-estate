
package com.real.estate.controller;

import com.real.estate.entity.Property;
import com.real.estate.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/properties")
public class PropertyController {

    @Autowired
    private PropertyService propertyService;

    @PostMapping("/add")
    public ResponseEntity<Property> addProperty(@RequestBody Property property) {
        Property addedProperty = propertyService.addProperty(property);
        return new ResponseEntity<>(addedProperty, HttpStatus.CREATED);
    }

    @GetMapping("/{name}")
    public ResponseEntity<Property> getPropertyByName(@PathVariable String name) {
        Property property = propertyService.getPropertyByName(name);
        if (property != null) {
            return new ResponseEntity<>(property, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/all")
    public ResponseEntity<List<Property>> getAllProperties() {
        List<Property> properties = propertyService.getAllProperties();
        return new ResponseEntity<>(properties, HttpStatus.OK);
    }
}
