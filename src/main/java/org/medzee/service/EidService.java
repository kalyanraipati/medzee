package org.medzee.service;

import org.medzee.entity.EIDEntity;
import org.medzee.model.input.EIDAInputModel;
import org.medzee.model.output.EIDModelOut;
import reactor.core.publisher.Mono;

public interface EidService {

    Mono<EIDModelOut> getEidById(String id);

    void postEIDA(EIDAInputModel eidaInputModel);
}
