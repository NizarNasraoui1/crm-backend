package com.crm.Crm.generic;

import com.crm.Crm.dto.SearchFields;
import com.crm.Crm.enumeration.SortDirection;
import com.crm.Crm.generic.wrapper.FilteredPageWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;

public abstract class GenericController<T extends GenericEntity,D> {

    @Autowired
    private GenericService<T> service;
    @Autowired
    private GenericMapper<T,D> mapper;

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody D entityDto) {
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

    @PostMapping("/filter")
    public ResponseEntity<FilteredPageWrapper<T>>filter(@RequestParam(value = "page",required = false,defaultValue = "0") int page,
    @RequestParam(value="pageSize",required = false,defaultValue = "10") int pageSize,
    @RequestParam(value = "sortDirection",required = false,defaultValue = "ASC") SortDirection sortDirection,
    @RequestParam(value = "sortField",required = false)String sortField,
    @RequestParam(value = "searchWord",required = false,defaultValue = "")String searchWord, @RequestBody SearchFields searchFields){
        return new ResponseEntity<>(service.getFilteredPage(searchWord,searchFields,page, pageSize, SortDirection.ASC),HttpStatus.OK);

    }
}