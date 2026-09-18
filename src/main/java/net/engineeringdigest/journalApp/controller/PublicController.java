package net.engineeringdigest.journalApp.controller;

import net.engineeringdigest.journalApp.entity.User;
import net.engineeringdigest.journalApp.service.UserDetailsServiceImpl;
import net.engineeringdigest.journalApp.service.UserService;
import net.engineeringdigest.journalApp.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/public")
public class PublicController {

    @Autowired
    private UserService userService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Autowired
    private JwtUtil jwtUtil;

    @GetMapping("/health-check")
    public String heathCheck() {
        return "OK";
    }

    @PostMapping("/singup")
    public void signup(@RequestBody User user) {
        userService.saveNewUser(user);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody User user) {
         try {
             Authentication authentication = authenticationManager.authenticate(
                     new UsernamePasswordAuthenticationToken(user.getUserName(), user.getPassword()));
             UserDetails userDetails = userDetailsService.loadUserByUsername(user.getUserName());
             String jwt = jwtUtil.generateToken(userDetails.getUsername());
             return new ResponseEntity<String>(jwt,HttpStatus.OK);
         } catch (Exception e) {
             return new ResponseEntity<String>("Incorrect username or password", HttpStatus.UNAUTHORIZED);
         }
    }

}
