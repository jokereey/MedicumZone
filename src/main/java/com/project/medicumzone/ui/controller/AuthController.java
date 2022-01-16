package com.project.medicumzone.controller;
import java.security.Principal;
import com.project.medicumzone.config.JWTTokenHelper;
import com.project.medicumzone.model.enitity.AppUser;
import com.project.medicumzone.request.AuthRequest;
import com.project.medicumzone.responses.LoginResponse;
import com.project.medicumzone.responses.UserInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;


import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

@RestController
@RequestMapping("/api")
@CrossOrigin
@Slf4j
public class AuthController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JWTTokenHelper jwtTokenHelper;

    @Autowired
    private UserDetailsService userDetailsService;

    @PostMapping("/auth/login")
    public ResponseEntity<?> login(@RequestBody AuthRequest request) throws InvalidKeySpecException, NoSuchAlgorithmException {
        log.info("request passed");
        log.info("Username: "+request.getUsername() + " Password: " + request.getPassword());
        final Authentication authentication = authenticationManager.authenticate(
        new UsernamePasswordAuthenticationToken(request.getUsername(),request.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        AppUser appUser = (AppUser) authentication.getPrincipal();
        String jwtToken = jwtTokenHelper.generateToken(appUser.getEmail());
        LoginResponse response = new LoginResponse();
        response.setToken(jwtToken);
        
        return ResponseEntity.ok(response);
    }
    @GetMapping("/auth/userinfo")
    public ResponseEntity<?> getUserInfo(Principal user){
        AppUser userObj=(AppUser) userDetailsService.loadUserByUsername(user.getName());

        UserInfo userInfo=new UserInfo();
        userInfo.setFirstName(userObj.getName());
        userInfo.setLastName(userObj.getEmail());
        userInfo.setRoles(userObj.getAuthorities().toArray());
        return ResponseEntity.ok(userInfo);

    }

}
