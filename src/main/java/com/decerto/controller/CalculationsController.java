package com.decerto.controller;

import com.decerto.service.NumberService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.naming.ServiceUnavailableException;

@RestController
public class CalculationsController {

    private final NumberService numberService;

    public CalculationsController(NumberService numberService) {
        this.numberService = numberService;
    }

    @GetMapping("/add")
    public ResponseEntity<Integer> addTwoIntegers() throws ServiceUnavailableException {
       return new ResponseEntity(numberService.addTwoRandomIntegers(), HttpStatus.OK);
    }
}
