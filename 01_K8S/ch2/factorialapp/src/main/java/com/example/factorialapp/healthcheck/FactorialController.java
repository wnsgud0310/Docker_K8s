package com.example.factorialapp.healthcheck;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class FactorialController {

    // http://localhost:8080/factorial?n=10
    @GetMapping("/factorial")
    public BigDecimal factorial(@RequestParam("n") int n) {
        if(n<0){
            throw new ArithmeticException("n must be greater than zero");
        }


        BigDecimal factorial = new BigDecimal(n);
        return factorial;
    }
    @GetMapping("/factorial/message")
    public String message()  {
        return "this is a factorial message 통신 된거임";
    }
    
}
