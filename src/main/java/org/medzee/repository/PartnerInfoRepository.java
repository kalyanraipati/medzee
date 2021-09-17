package org.medzee.repository;

import org.medzee.entity.PartnerInfoEntity;
import org.medzee.entity.RoutineEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PartnerInfoRepository extends ReactiveCrudRepository<PartnerInfoEntity, String> {

}
