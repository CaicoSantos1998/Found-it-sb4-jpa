package com.github.CaicoSantos1998.Found.It.resources;

import com.github.CaicoSantos1998.Found.It.entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @GetMapping
    public ResponseEntity<User> findAll() {
        User u = new User(1L, "Maria", "maria@gmail.com", "934839243", "2134");
        return ResponseEntity.ok().body(u);
    }
}
