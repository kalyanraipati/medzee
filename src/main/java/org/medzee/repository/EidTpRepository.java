package org.medzee.repository;

import org.medzee.entity.EIDEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EidTpRepository extends ReactiveCrudRepository<EIDEntity, String> {
}
