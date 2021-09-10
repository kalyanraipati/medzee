package org.medzee.controller;

import org.medzee.exception.NotFoundException;
import org.medzee.model.output.EIDModelOut;
import org.medzee.service.EidService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1")
public class EmiratesIdController extends  BaseController{

    EidService eidService;

    public EmiratesIdController(EidService eidService) {
        this.eidService = eidService;
    }

    @GetMapping("/eid/{id}")
    public Mono<EIDModelOut> getEmployeeById(@PathVariable String id) {
        return eidService.getEidById(id).switchIfEmpty(Mono.error(new NotFoundException("EID")));
    }
}
