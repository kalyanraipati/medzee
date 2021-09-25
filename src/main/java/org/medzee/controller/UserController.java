package org.medzee.controller;

import org.medzee.entity.VisitsInfoEntity;
import org.medzee.model.input.SignupInputModel;
import org.medzee.model.input.UserRoutineInputModel;
import org.medzee.model.output.UserModelOut;
import org.medzee.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PatchMapping("/{id}")
    public void signup(@RequestBody SignupInputModel input) {
    }

    @GetMapping("/{id}")
    public Mono<UserModelOut> getUserInfo(@PathVariable("id") String id) {
        return userService.getUserById(id);
    }

    @PatchMapping("/{id}/info")
    public ResponseEntity saveRoutineInfo(@PathVariable("id") String id,
                                          @RequestBody UserRoutineInputModel userRoutineInputModel) {
        userService.saveRoutineInfo(id, userRoutineInputModel);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/{id}/visits-info")
    public Flux<VisitsInfoEntity> getVisitsInfo(@PathVariable("id") String registrationId) {
        return userService.getVisitsInfo(registrationId);
    }
}
