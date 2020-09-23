package com.decerto.controller;

import com.decerto.service.NumberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.naming.ServiceUnavailableException;

@RestController
@RequiredArgsConstructor
public class CalculationsController {

    private final NumberService numberService;


    @GetMapping("/sum")
    public ResponseEntity<Integer> getSum() throws ServiceUnavailableException {
       return new ResponseEntity(numberService.addition(), HttpStatus.OK);
    }
}
