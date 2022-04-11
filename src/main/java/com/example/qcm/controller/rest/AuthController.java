package com.example.qcm.controller.rest;

import com.example.qcm.controller.rest.payload.MessageResponse;
import com.example.qcm.controller.rest.payload.SignupRequest;
import com.example.qcm.repository.entity.User;
import com.example.qcm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController("authRestController")
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<?> signUp(@Valid @RequestBody SignupRequest dto) {

        boolean userAlreadyExist = userService.checkUsernameExist(dto.getUsername());

        if (userAlreadyExist) {
            return ResponseEntity
                    .status(HttpStatus.CONFLICT)
                    .body(new MessageResponse("User already exist"));
        }

        User createdUser = userService.signup(dto.getUsername(), dto.getPassword());

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new MessageResponse("User " + createdUser + " registered successfully"));
    }

    @PostMapping("/signin")
    public void authenticate() {
        // TODO :
        //  1) Créer le DTO
        //  2) Authentifier l'utilisateur avec AuthenticationManager
        //  3) Générer un jeton avec la librairie jsontoken
        // 4) Renvoyer une réponse JSON contenant ce jeton

    }


}
