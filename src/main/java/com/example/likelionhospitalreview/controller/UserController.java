package com.example.likelionhospitalreview.controller;

import com.example.likelionhospitalreview.domain.dto.UserRequest;
import com.example.likelionhospitalreview.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/")
public class UserController {

    private final UserService userService;

    @PostMapping("/join")
    public String join (@RequestBody UserRequest userRequest){
        String message = userService.join(userRequest);
        return message;
    }
}
