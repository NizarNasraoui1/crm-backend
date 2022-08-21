package com.crm.Crm.controller.generic;

import com.crm.Crm.Repository.Generic.GenericRepository;
import com.crm.Crm.entity.baseEntity.BaseEntity;
import com.crm.Crm.mapper.generic.GenericMapper;
import com.crm.Crm.service.generic.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;

public abstract class GenericController<T extends BaseEntity,D> {

    @Autowired
    private GenericService<T> service;
    @Autowired
    private GenericMapper<T,D> mapper;

    @PostMapping
    public ResponseEntity<Object> save(D entityDto) {
        try {
            return new ResponseEntity(service.save(mapper.toBo(entityDto)), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity("save error!", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<D>findById(@PathVariable Long id){
        return new ResponseEntity<>(mapper.toDto(service.findById(id).orElseThrow(()->new EntityNotFoundException("not found"))),HttpStatus.FOUND);
    }

    @GetMapping("all")
    public ResponseEntity<List<D>> findAll() {
        try {
            return new ResponseEntity(mapper.toDtos(service.findAll()), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity("find all error!", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id) {
        try {
            service.delete(id);
            return new ResponseEntity("delete successfully", HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity("delete error!", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}