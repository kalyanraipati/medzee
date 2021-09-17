package org.medzee.service.impl;

import org.medzee.entity.PartnerInfoEntity;
import org.medzee.entity.RoutineEntity;
import org.medzee.entity.UserEntity;
import org.medzee.entity.VisitsInfoEntity;
import org.medzee.exception.InvalidCredentialsException;
import org.medzee.exception.NotFoundException;
import org.medzee.mapper.UserMapper;
import org.medzee.model.input.SignupInputModel;
import org.medzee.model.input.UserRoutineInputModel;
import org.medzee.model.output.EIDModelOut;
import org.medzee.model.output.UserModelOut;
import org.medzee.model.vo.UserModel;
import org.medzee.repository.PartnerInfoRepository;
import org.medzee.repository.RoutineRepository;
import org.medzee.repository.UserRepository;
import org.medzee.repository.VisitsInfoRepository;
import org.medzee.service.UserService;
import org.medzee.util.SequenceGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.nio.CharBuffer;
import java.time.LocalDateTime;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private SequenceGeneratorService sequenceGeneratorService;
    @Autowired
    private RoutineRepository routineRepository;
    @Autowired
    private PartnerInfoRepository partnerInfoRepository;
    @Autowired
    private VisitsInfoRepository visitsInfoRepository;

    @Override
    public Mono<Boolean> existsByIdentityNumber(String identityNumber) {
        return userRepository.existsByIdentityNumber(identityNumber);
    }

    @Override
    public String save(EIDModelOut eidModelOut, UserModel userModel) {

        UserEntity entity=new UserEntity();
        entity.setId(sequenceGeneratorService.generatedSequenceString(UserEntity.SEQUENCE_NAME));
        entity.setIdentityNumber(eidModelOut.getId());
        entity.setFirstName(eidModelOut.getFirstName());
        entity.setMiddleName(eidModelOut.getMiddleName());
        entity.setLastName(eidModelOut.getLastName());
        entity.setAge(eidModelOut.getAge());
        entity.setGender(eidModelOut.getGender());
        entity.setPasswordHash(passwordEncoder.encode(CharBuffer.wrap(userModel.getPassword())));
        // routine addition is pending
        entity = userRepository.save(entity).block();
        return entity.getId();
    }

    @Override
    public Mono<UserModelOut> getUserById(String id) {
       return userRepository.findById(id).map(UserMapper::from);
    }

    @Override
    public String authenticate(SignupInputModel signupInputModel) {
        UserEntity entity = userRepository.findByIdentityNumber(signupInputModel.getIdentityNumber()).block();
        if (ObjectUtils.isEmpty(entity)) {
            throw new InvalidCredentialsException();
        }
        boolean authenticated = passwordEncoder.matches(CharBuffer.wrap(signupInputModel.getPassword()), entity.getPasswordHash());
        if(!authenticated) {
            throw new InvalidCredentialsException();
        }
        return entity.getId();
    }

    @Override
    public void saveRoutineInfo(String registrationId, UserRoutineInputModel routineInfo) {
        boolean userExists = userRepository.existsById(registrationId).block();
        if (!userExists) {
            throw new NotFoundException("User is not registered");
        }
        RoutineEntity entity = new RoutineEntity();
        entity.setRegistrationId(registrationId);
        entity.setTimings(routineInfo.getTimings());
        routineRepository.save(entity).block();
    }

    @Override
    public Flux<PartnerInfoEntity> getPartnerDetails() {
        return partnerInfoRepository.findAll();
    }

    @Override
    public Flux<VisitsInfoEntity> getVisitsInfo(String registrationId) {
        boolean isRegistered = visitsInfoRepository.existsByRegistrationId(registrationId).block();
        if (!isRegistered) {
            throw new NotFoundException("User not registered");
        }
        return visitsInfoRepository.findByRegistrationId(registrationId);
    }
}
