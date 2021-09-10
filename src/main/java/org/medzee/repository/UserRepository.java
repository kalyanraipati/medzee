package org.medzee.repository;

import org.medzee.entity.EIDEntity;
import org.medzee.entity.UserEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface UserRepository extends ReactiveCrudRepository<UserEntity, String> {
    Mono<Boolean> existsByEid(String eid);
}
