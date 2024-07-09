package com.mbakara.service;

import com.mbakara.dto.LoginRequest;
import com.mbakara.dto.Request;
import com.mbakara.dto.Response;
import org.springframework.http.ResponseEntity;


public interface UserService {
    ResponseEntity<Response> signUp(Request request);

    ResponseEntity<Response> login(LoginRequest request);
    Response sendOtp();
    Response validateOtp();
    Response resetPassword();
    Response changePassword();

}
