package org.medzee.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.medzee.exception.InvalidCredentialsException;
import org.medzee.exception.NotFoundException;
import org.medzee.exception.UserAlreadyExistsException;
import org.medzee.model.input.SignupInputModel;
import org.medzee.model.output.EIDModelOut;
import org.medzee.model.output.SignupResponse;
import org.medzee.model.vo.UserModel;
import org.medzee.model.vo.UserRoutine;
import org.medzee.service.EidService;
import org.medzee.service.SignupService;
import org.medzee.service.UserService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.Optional;

@Service
@Slf4j
public class SignupServiceImpl implements SignupService {

    private EidService eidService;
    private UserService userService;

    public SignupServiceImpl(EidService eidService, UserService userService) {
        this.eidService = eidService;
        this.userService = userService;
    }

    @Override
    public SignupResponse signup(SignupInputModel inputModel) {
        boolean exists = userService.existsByIdentityNumber(inputModel.getIdentityNumber()).block();
        if (exists) {
            throw new UserAlreadyExistsException();
        }
        Mono<EIDModelOut> eidModelOutMono = eidService.getEidById(inputModel.getIdentityNumber());
        Optional<EIDModelOut> eidOpt = eidModelOutMono.blockOptional();
        if (eidOpt.isEmpty()) {
            throw new NotFoundException("EID");
        } else {
            UserModel model = new UserModel();
            model.setPassword(inputModel.getPassword());
            model.setUserRoutine(new UserRoutine());
            log.info("saved");
            SignupResponse response = new SignupResponse();
            response.setRegistrationId(userService.save(eidOpt.get(),model));
            return response;
        }
    }

    @Override
    public SignupResponse authenticate(SignupInputModel inputModel) {
        String registrationId = userService.authenticate(inputModel);
        SignupResponse response = new SignupResponse();
        response.setRegistrationId(registrationId);
        return response;
    }
}
