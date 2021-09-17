package org.medzee.controller;

import org.medzee.entity.PartnerInfoEntity;
import org.medzee.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1")
public class BaseController {

    @Autowired
    private UserService userService;

    @GetMapping("/partner-info")
    public Flux<PartnerInfoEntity> getPartnerInfo() {
        return userService.getPartnerDetails();
    }
}
