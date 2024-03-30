package com.springbootapp.Microservices.Controller;

import com.springbootapp.Microservices.Model.User;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class controller {

    @RequestMapping("/")
    public String sayHello(){
        return "Hello this is your default API endpoint";
    }

    @RequestMapping("/user")
    public User user(){
        User user = new User();
        user.setId("1");
        user.setName("John Doe");
        user.setEmail("doejohn@gmail.com");

        return user;
    }

    @GetMapping("/user/{id}")
    public String pathVariableTest(@PathVariable Optional<Integer> id){
        if(id.isPresent()){
            return "This is the path variable id: " + id;
        }
        else{
            return "Invalid path variable id";
        }
    }

    @GetMapping("/requestParam")
    public String requestParam(@RequestParam String name,
                               @RequestParam(name="email", required = false, defaultValue = "") String emailId){
        return "This is your name: " + name + " and this is your email: " + emailId;
    }
}
