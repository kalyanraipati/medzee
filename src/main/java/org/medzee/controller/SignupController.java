package org.medzee.controller;

import org.medzee.exception.NotFoundException;
import org.medzee.model.input.SignupInputModel;
import org.medzee.model.output.EIDModelOut;
import org.medzee.service.EidService;
import org.medzee.service.SignupService;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/users")
public class SignupController {

    private SignupService signupService;

    public SignupController(SignupService signupService) {
        this.signupService = signupService;
    }

    @PostMapping("/signup")
    public void signup(@RequestBody SignupInputModel input) {
         signupService.signup(input);
    }
}
