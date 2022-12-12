package com.example.likelionhospitalreview.service;

import com.example.likelionhospitalreview.domain.User;
import com.example.likelionhospitalreview.domain.dto.UserRequest;
import com.example.likelionhospitalreview.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public String join(UserRequest userRequest) {

        Optional<User> user = userRepository.findByUserName(userRequest.getUserName());
        if (user.isPresent()) throw new RuntimeException("해당 이름이 존재합니다.");

        User users = User.builder()
                .userName(userRequest.getUserName())
                .password(userRequest.getPassword())
                .build();

        userRepository.save(users);

        String message = "회원가입이 완료되었습니다.";
        return message;
    }
}