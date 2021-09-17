package org.medzee.repository;

import org.medzee.entity.PartnerInfoEntity;
import org.medzee.entity.VisitsInfoEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface VisitsInfoRepository extends ReactiveCrudRepository<VisitsInfoEntity, String> {
    Mono<Boolean> existsByRegistrationId(String registrationId);
    Flux<VisitsInfoEntity> findByRegistrationId(String registrationId);
}
