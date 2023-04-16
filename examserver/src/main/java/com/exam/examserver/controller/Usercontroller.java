package com.exam.examserver.controller;

import com.exam.examserver.service.UserService;
import com.exam.examserver.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/user")
public class Usercontroller {
    @Autowired
    private UserService userService;

    @GetMapping("/hello")
    public String gethello(){
        return "hello";
    }
    @GetMapping("/getAll")
    public List<User> getalluser(){
        return this.userService.findallusers();
    }
    @GetMapping("/{email}")
    public User getuser(@PathVariable("email") String email) throws Exception {
        return this.userService.finduserbyemail(email);
    }
    @PostMapping("/")
    public User createUser(@RequestBody User user) throws Exception {
        return this.userService.createUser(user);
    }

    @DeleteMapping("/{email}")
    public String deleteuser(@PathVariable("email") String email) throws Exception{
        return this.userService.deleteuserbyemail(email);
    }

}
