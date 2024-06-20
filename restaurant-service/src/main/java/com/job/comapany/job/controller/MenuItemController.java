package com.job.comapany.job.controller;

import com.job.comapany.job.domain.MenuItem;
import com.job.comapany.job.service.MenuItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/menu")
@RequiredArgsConstructor
public class MenuItemController {
    @Autowired
    private final MenuItemService service;

    @PostMapping
    public ResponseEntity<String>addMenuItems(@RequestBody MenuItem menuItem){
        service.addMenuItems(menuItem);
        return new ResponseEntity<>("menu items added successfully", HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List> getAllMenuItems(){
        return new ResponseEntity<>(service.fetchMenu(), HttpStatus.OK);
    }
}
