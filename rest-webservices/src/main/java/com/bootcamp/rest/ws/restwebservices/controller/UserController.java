package com.bootcamp.rest.ws.restwebservices.controller;

import com.bootcamp.rest.ws.restwebservices.bean.User;
import com.bootcamp.rest.ws.restwebservices.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("users/")
    public List<User> retrieveAllUsers() {
        return userService.retrieveAllUser();
    }

    @GetMapping("users/{id}")
    public ResponseEntity<Object> findUserByUserId(@PathVariable String id) {
        User usr = userService.findUserById(Integer.valueOf(id));
        if (usr != null) {
            return ResponseEntity.status(HttpStatus.FOUND).body(usr);
        }
        return ResponseEntity.notFound().header(HttpHeaders.CONTENT_LOCATION).build();
    }

    @PostMapping("users/")
    public ResponseEntity<Object> saveUser(@Valid @RequestBody User user) {
        User savedUser = userService.saveUser(user);
        if (savedUser != null) {
            EntityModel<User> res = EntityModel.of(savedUser);
            WebMvcLinkBuilder mvcLinkBuilder = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).retrieveAllUsers());
            res.add(Link.of(mvcLinkBuilder.slash(savedUser.getId()).toUri().toString()));
            res.add(Link.of(mvcLinkBuilder.toUri().toString(), "all-users"));
            URI locationRes = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId()).toUri();
            return ResponseEntity.created(locationRes).body(res);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
}
