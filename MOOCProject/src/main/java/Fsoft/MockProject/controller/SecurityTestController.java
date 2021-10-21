package Fsoft.MockProject.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecurityTestController {
    @RequestMapping("/hello")
    public String index(){
        return "<h1>Hello world</h1>";
    }
}
