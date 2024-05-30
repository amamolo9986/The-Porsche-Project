package com.ThePorscheProject.security;

import com.ThePorscheProject.dao.request.SignInRequest;
import com.ThePorscheProject.dao.request.SignUpRequest;
import com.ThePorscheProject.dao.response.JwtAuthenticationResponse;

public interface AuthenticationService {
    JwtAuthenticationResponse signup(SignUpRequest request);
    JwtAuthenticationResponse signin(SignInRequest request);
}