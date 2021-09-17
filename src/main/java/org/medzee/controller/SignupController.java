package org.medzee.controller;

import org.medzee.model.input.SignupInputModel;
import org.medzee.model.output.SignupResponse;
import org.medzee.service.SignupService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
public class SignupController {

    private SignupService signupService;

    public SignupController(SignupService signupService) {
        this.signupService = signupService;
    }

    @PostMapping("/signup")
    public ResponseEntity<SignupResponse> signup(@RequestBody SignupInputModel input) {
         return new ResponseEntity<SignupResponse>(signupService.signup(input), HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<SignupResponse> authenticate(@RequestBody SignupInputModel inputModel) {
        return new ResponseEntity<SignupResponse>(signupService.authenticate(inputModel), HttpStatus.OK);
    }
}
