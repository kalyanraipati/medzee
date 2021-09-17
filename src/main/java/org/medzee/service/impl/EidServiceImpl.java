package org.medzee.service.impl;

import org.medzee.entity.EIDEntity;
import org.medzee.mapper.EidMapper;
import org.medzee.model.input.EIDAInputModel;
import org.medzee.model.output.EIDModelOut;
import org.medzee.repository.EidTpRepository;
import org.medzee.service.EidService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
@Service
public class EidServiceImpl implements EidService {

    private EidTpRepository eidTpRepository;

    public EidServiceImpl(EidTpRepository eidTpRepository) {
        this.eidTpRepository = eidTpRepository;
    }

    public Mono<EIDModelOut> getEidById(String id) {
         return eidTpRepository.findById(id).map(EidMapper::from);
    }

    public void postEIDA(EIDAInputModel eidaInputModel) {
        eidTpRepository.save(EidMapper.getEntity(eidaInputModel)).block();
    }
}

