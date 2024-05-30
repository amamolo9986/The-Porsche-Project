package com.ThePorscheProject.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.ThePorscheProject.domain.User;

import java.util.List;

public interface UserService {
    UserDetailsService userDetailsService();
    List<User> findAll();
}