package com.example.libraryservicemanager.web;

import com.example.libraryservicemanager.domain.Response;
import com.example.libraryservicemanager.dto.UserRequest;
import com.example.libraryservicemanager.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;
import java.net.URI;
import static com.example.libraryservicemanager.utils.RequestUtils.getResponse;
import static java.util.Collections.emptyMap;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/user")
@CrossOrigin("http://localhost:3000")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final AuthenticationManager authenticationManager;

    @PostMapping("/register")
    public ResponseEntity<Response> saveUser(@RequestBody UserRequest user, HttpServletRequest request){
        userService.createUser(user.getFirstName(), user.getLastName(), user.getEmail(), user.getPassword());
        return ResponseEntity.created(getUrl()).body(getResponse(request,emptyMap(),"Account created, Check your email to enable your account",CREATED));
    }

    @GetMapping("/verify/account")
    public ResponseEntity<Response> verifyAccount(@RequestParam("key") String key, HttpServletRequest request){
        userService.verifyAccount(key);
        return ResponseEntity.ok().body(getResponse(request,emptyMap(),"Account verified",OK));
    }
//
//    @PostMapping("/login")
//    public ResponseEntity<Response> test(@RequestBody UserRequest user){
//        authenticationManager.authenticate(UsernamePasswordAuthenticationToken.unauthenticated(user.getEmail(),user.getPassword()));
//        return ResponseEntity.ok().build();
//    }
    private URI getUrl() {
        return URI.create("");
    }


}
