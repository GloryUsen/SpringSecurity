package com.mbakara.servicelmpl;

import com.mbakara.dto.LoginRequest;
import com.mbakara.dto.Request;
import com.mbakara.dto.Response;
import com.mbakara.model.User;
import com.mbakara.repository.UserRepository;
import com.mbakara.service.UserService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {


    private UserRepository userRepository;
    private ModelMapper modelMapper;

    @Override
    public ResponseEntity<Response> signUp(Request request) {
        // If the user exists, return error
        if (userRepository.findByEmail(request.getEmail()).isPresent()) {
            return ResponseEntity.badRequest().body(
                    Response.builder()
                            .statusCode(400)
                            .responseMessage("Attempt to save duplicate user record")
                            .build());
        }

             User user = User.builder()
                .email(request.getEmail())
                .password(request.getPassword())
                .firstname(request.getFirstname())
                .lastname(request.getLastname())
                .build();


        User savedUser = userRepository.save(user);
        return ResponseEntity.ok(Response.builder()
                        .statusCode(200)
                        .responseMessage("SUCCESSFUL")
                        .userInfo(modelMapper.map(savedUser, Request.class))
                        .build()
        );
    }

    @Override
    public ResponseEntity<Response> login(LoginRequest request) {
        return null;
    }

    @Override
    public Response sendOtp() {
        return null;
    }

    @Override
    public Response validateOtp() {
        return null;
    }

    @Override
    public Response resetPassword() {
        return null;
    }

    @Override
    public Response changePassword() {
        return null;
    }
}
