package az.stepit.service;

import az.stepit.payload.request.LoginRequest;
import az.stepit.payload.request.SignupRequest;
import az.stepit.payload.request.TokenRefreshRequest;
import az.stepit.payload.response.JwtResponse;
import org.springframework.http.ResponseEntity;


public interface AuthService {

    ResponseEntity<JwtResponse> signIn(LoginRequest loginRequest);

    ResponseEntity<?> refreshToken(TokenRefreshRequest request);

    ResponseEntity<?> signUp(SignupRequest signUpRequest);


     boolean validateAccessToken(String token);
}
