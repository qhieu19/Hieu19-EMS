package Fsoft.MOOCProject.controller;

import Fsoft.MOOCProject.entities.model.User;
import Fsoft.MOOCProject.services.service_implement.UserServiceIpml;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserServiceIpml userServiceIpml;

    @GetMapping("/list")
    public List<User> list(){
        return userServiceIpml.list();
    }

    @PostMapping("/add")
    public String add(@RequestBody User u){
        return userServiceIpml.add(u);
    }

    @PutMapping("/update")
    public String update(@RequestBody User u, @RequestParam int id){
        return userServiceIpml.update(u, id);
    }

    @DeleteMapping("/delete")
    public String delete(@RequestParam int id){
        return userServiceIpml.delete(id);
    }

    @GetMapping("login")
    public String login(@RequestBody User u){
        return userServiceIpml.login(u);
    }
}
