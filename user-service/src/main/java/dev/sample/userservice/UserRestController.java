package dev.sample.userservice;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/users")
public class UserRestController {
    @GetMapping("/get-all")
    public String getAllUsers(){
        return "Get all Users from the user-service ! ";
    }
}