package org.medzee.service;

import org.medzee.model.output.EIDModelOut;
import org.medzee.model.output.UserModelOut;
import org.medzee.model.vo.UserModel;
import reactor.core.publisher.Mono;

public interface UserService {

    Mono<Boolean> existsByEid(String eid);
    void save(EIDModelOut eidModelOut, UserModel userModel);

    Mono<UserModelOut> getUserById(String id);
}
