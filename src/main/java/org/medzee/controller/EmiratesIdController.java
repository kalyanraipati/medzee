package org.medzee.controller;

import org.medzee.entity.EIDEntity;
import org.medzee.exception.NotFoundException;
import org.medzee.model.input.EIDAInputModel;
import org.medzee.model.output.EIDModelOut;
import org.medzee.service.EidService;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/users")
public class EmiratesIdController extends BaseController {

    EidService eidService;

    public EmiratesIdController(EidService eidService) {
        this.eidService = eidService;
    }

    @GetMapping("/{id}/eida-info")
    public Mono<EIDModelOut> getEidaInfo(@PathVariable String id) {
        return eidService.getEidById(id).switchIfEmpty(Mono.error(new NotFoundException("Emirates Id details not found")));
    }

    @PostMapping("/eida-info")
    public void postEidaInfo(@RequestBody EIDAInputModel eidaInputModel) {
        eidService.postEIDA(eidaInputModel);
    }
}
