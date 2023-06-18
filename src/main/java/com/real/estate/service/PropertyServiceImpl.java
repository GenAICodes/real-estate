
package com.real.estate.service;

import com.real.estate.entity.Property;
import com.real.estate.repository.PropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PropertyServiceImpl implements PropertyService {

    @Autowired
    private PropertyRepository propertyRepository;

    @Override
    public Property addProperty(Property property) {
        return propertyRepository.save(property);
    }

    @Override
    public Property getPropertyByName(String name) {
        return propertyRepository.findByName(name);
    }

    @Override
    public List<Property> getAllProperties() {
        return propertyRepository.findAll();
    }
}
