package Fsoft.MockProject.controller;

import Fsoft.MockProject.entities.ResponseAPI;
import Fsoft.MockProject.entities.entitiesDTO.request.UserRequest;
import Fsoft.MockProject.entities.entitiesDTO.response.UserResponse;
import Fsoft.MockProject.services.service_interface.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("")
    public String index(){
        return "user";
    }

    @GetMapping("/list")
    public List<UserResponse> list(){
        return userService.list();
    }

    @PostMapping("/add")
    public ResponseAPI add(@RequestBody UserRequest u){
        return userService.add(u);
    }

    @PutMapping("/update/{id}")
    public ResponseAPI update(@RequestBody UserRequest u, @PathVariable int id){
        return userService.update(u, id);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseAPI delete(@PathVariable int id){
        return userService.delete(id);
    }
}
