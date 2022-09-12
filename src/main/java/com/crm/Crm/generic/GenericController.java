package com.crm.Crm.generic;

import com.crm.Crm.dto.SearchFields;
import com.crm.Crm.generic.wrapper.FilteredPageWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;

public abstract class GenericController<T extends GenericEntity,D,M extends GenericMapper<T,D>> {

    @Autowired
    protected GenericService<T,D,M> service;

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody D entityDto) {
        try {
            return new ResponseEntity(service.save(entityDto), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity("save error!", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping
    public ResponseEntity<Object> update(@RequestBody D entityDto) {
        try {
            return new ResponseEntity(service.save(entityDto), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity("save error!", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object>findById(@PathVariable Long id){
        return new ResponseEntity<>(service.findById(id),HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<D>> findAll() {
        try {
            return new ResponseEntity(service.findAll(), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity("find all error!", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id) {
        try {
            service.delete(id);
            return new ResponseEntity( HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity("delete error!", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }




}