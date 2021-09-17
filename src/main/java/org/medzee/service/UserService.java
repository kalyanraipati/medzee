package org.medzee.service;

import org.medzee.entity.PartnerInfoEntity;
import org.medzee.entity.VisitsInfoEntity;
import org.medzee.model.input.SignupInputModel;
import org.medzee.model.input.UserRoutineInputModel;
import org.medzee.model.output.EIDModelOut;
import org.medzee.model.output.UserModelOut;
import org.medzee.model.vo.UserModel;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UserService {

    Mono<Boolean> existsByIdentityNumber(String eid);
    String save(EIDModelOut eidModelOut, UserModel userModel);
    Mono<UserModelOut> getUserById(String id);
    String authenticate(SignupInputModel signupInputModel);
    void saveRoutineInfo(String registrationId, UserRoutineInputModel routineInfo);
    Flux<PartnerInfoEntity> getPartnerDetails();
    Flux<VisitsInfoEntity> getVisitsInfo(String registrationId);
}
