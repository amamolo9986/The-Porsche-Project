package com.ThePorscheProject.web;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.ThePorscheProject.dao.request.RefreshTokenRequest;
import com.ThePorscheProject.dao.request.SignInRequest;
import com.ThePorscheProject.dao.response.JwtAuthenticationResponse;
import com.ThePorscheProject.dao.response.TokenRefreshResponse;
import com.ThePorscheProject.domain.RefreshToken;
import com.ThePorscheProject.domain.User;
import com.ThePorscheProject.security.AuthenticationServiceImpl;
import com.ThePorscheProject.security.JwtService;
import com.ThePorscheProject.service.RefreshTokenService;
import com.ThePorscheProject.service.UserServiceImpl;

//@RestController
//@RequestMapping("/api/v1/auth") 
@Controller
public class AuthenticationController {
    private final AuthenticationServiceImpl authenticationService;
    private final RefreshTokenService refreshTokenService;
    private final JwtService jwtService;
    private final UserServiceImpl userService;
    
    public AuthenticationController(AuthenticationServiceImpl authenticationService,
			RefreshTokenService refreshTokenService, JwtService jwtService, UserServiceImpl userService) {
		super();
		this.authenticationService = authenticationService;
		this.refreshTokenService = refreshTokenService;
		this.jwtService = jwtService;
		this.userService = userService;
	}
    

    @GetMapping("/signin")
	public String getLogin (@ModelAttribute("user") User user) {
		return "login";
	}
    
    @GetMapping("/login-error")
    public String loginError (Model model) {
    	model.addAttribute("loginError", true);
    	return "login";
    }
    

    @PostMapping("/signin")
    public ResponseEntity<JwtAuthenticationResponse> signin(@RequestBody SignInRequest request, @RequestBody User user) {
    	Optional<User> existingUser = userService.findUserByEmail(user.getEmail());

    	String accessToken = jwtService.generateToken(user);
    	
        return ResponseEntity.ok(authenticationService.signin(request));

    }

    
	/*
	 * This code is from Trevor's original implementation which might be helpful for those who are not using server rendering templates
	 * 
	 * @PostMapping("/signin") public String authenticateLogin
	 * (@ModelAttribute("user") User user, SignInRequest request) { 
	 * Optional<User> existingUser = userService.findUserByEmail(user.getEmail()); 
	 * User loggedUser = ((User) userService).loadUserByUsername(user.getUsername()); 
	 * String accessToken = jwtService.generateToken(user);
	 * 
	 * return ResponseEntity.ok(authenticationService.signin(request)); }
	 */
    
    
    @PostMapping("/refreshtoken")
    public ResponseEntity<?> refreshtoken(@RequestBody RefreshTokenRequest request) {
      String requestRefreshToken = request.refreshToken();

      return refreshTokenService.findByToken(requestRefreshToken)
          .map(refreshTokenService::verifyExpiration)
          .map(RefreshToken::getUser)
          .map(user -> {
            String token = jwtService.generateToken(user);
            return ResponseEntity.ok(new TokenRefreshResponse(token, requestRefreshToken));
          })
          .orElseThrow(() -> new IllegalStateException(
              "Refresh token " + requestRefreshToken + " is not in database!"));
    }
}