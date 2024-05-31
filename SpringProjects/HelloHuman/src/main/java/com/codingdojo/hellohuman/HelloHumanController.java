package com.codingdojo.hellohuman;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class HelloHumanController {
    @RequestMapping("/")
    public String index(@RequestParam(value="q", required = false) String firstName, @RequestParam(value="last_name", required = false) String last_name) {
        if (firstName == null || firstName.trim().isEmpty()) {
            firstName = "Human";
        }

        if (last_name == null || last_name.trim().isEmpty()) {
            return "Hello " + firstName + "!";
        } else {
            return "Hello " + firstName + " " + last_name + "!";
        }
    }
}
