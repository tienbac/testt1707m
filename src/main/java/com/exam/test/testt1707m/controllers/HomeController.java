package com.exam.test.testt1707m.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/eim")
public class HomeController {
    @RequestMapping(method = RequestMethod.GET)
    public String post(@RequestParam("l") long l,
                       @RequestParam("n") int n,
                       @RequestParam("op2") int op2){
        double r = 0;
        switch (n){
            case 3:
                r = 0.075;
            break;
            case 6:
                r = 0.071;
            break;
            case 12:
                r = 0.068;
            break;
            case 24:
                r = 0.064;
            break;

        }
        return String.valueOf(formula(l, n, r, op2));
    }

    public double formula(long l, int n, double r, int op2){
        r = r/12;

        if (op2 == 0){
            double f = l*((r*(Math.pow((1+r), n)))/(Math.pow((1+r),n) - 1));
            return f;
        }else {
            double f = l*((r*(Math.pow((1+r), n)))/(Math.pow((1+r),n) - 1));
            double h = f*op2*0.2;
            return h;
        }
    }
}
