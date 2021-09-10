package org.medzee.service;

import org.medzee.model.output.EIDModelOut;
import reactor.core.publisher.Mono;

public interface EidService {

    Mono<EIDModelOut> getEidById(String id);

}
