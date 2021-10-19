package Fsoft.MockProject.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecurityTestController {
    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/boss")
    public String boss(){
        return "boss";
    }

    @GetMapping("/dev")
    public String dev(){
        return "dev";
    }
}
