package com.mbakara.controller;

import com.mbakara.dto.Request;
import com.mbakara.dto.Response;
import com.mbakara.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/auth")

public class UserController {

    private UserService userService;
    @PostMapping("/signup")
    public ResponseEntity<Response> signup(@RequestBody Request request){
        return userService.signUp(request);

    }
}
