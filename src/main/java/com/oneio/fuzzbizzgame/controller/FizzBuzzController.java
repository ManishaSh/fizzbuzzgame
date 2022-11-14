package com.oneio.fuzzbizzgame.controller;

import com.oneio.fuzzbizzgame.service.FizzBuzzService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FizzBuzzController {

    private final FizzBuzzService fizzBuzzService;

    public FizzBuzzController(FizzBuzzService fizzBuzzService) {
        this.fizzBuzzService = fizzBuzzService;
    }

    @CrossOrigin
    @GetMapping(path = "/fizz-buzz", produces = "application/json")
    public ResponseEntity<String> playFizzBuzz(@RequestParam Integer number) {
        if (number == null || number < 1)
            return new ResponseEntity<>("Please enter valid number greater than 0", HttpStatus.BAD_REQUEST);
        else
            return new ResponseEntity<>(fizzBuzzService.getFuzzBizzOutput(number), HttpStatus.OK);
    }

}
