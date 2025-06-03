package dev.sample.userservice;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/users")
public class UserRestController {
    @GetMapping("/get-all")
    public ResponseEntity<?> getAllUsers(){
        List<UserResponse> response = new ArrayList<>();
        response.add(
                UserResponse.builder()
                        .userId(UUID.randomUUID())
                        .email("usersample@example.com")
                        .fullName("Testing User ")
                        .username("testinguser")
                        .gender("Male")
                        .build()
        );
        return ResponseEntity.ok(response);
    }
}