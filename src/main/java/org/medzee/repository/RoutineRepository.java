package org.medzee.repository;

import org.medzee.entity.RoutineEntity;
import org.medzee.entity.UserEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface RoutineRepository extends ReactiveCrudRepository<RoutineEntity, String> {

}
