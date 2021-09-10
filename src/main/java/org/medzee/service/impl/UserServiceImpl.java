package org.medzee.service.impl;

import org.medzee.entity.UserEntity;
import org.medzee.mapper.UserMapper;
import org.medzee.model.output.EIDModelOut;
import org.medzee.model.output.UserModelOut;
import org.medzee.model.vo.UserModel;
import org.medzee.repository.UserRepository;
import org.medzee.service.UserService;
import org.medzee.util.SequenceGeneratorService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.nio.CharBuffer;
import java.time.LocalDateTime;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;
    private SequenceGeneratorService sequenceGeneratorService;


    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder, SequenceGeneratorService sequenceGeneratorService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.sequenceGeneratorService = sequenceGeneratorService;
    }

    @Override
    public Mono<Boolean> existsByEid(String eid) {
        return userRepository.existsByEid(eid);
    }

    @Override
    public void save(EIDModelOut eidModelOut, UserModel userModel) {

        UserEntity entity=new UserEntity();
        entity.setId(sequenceGeneratorService.generatedSequenceString(UserEntity.SEQUENCE_NAME));
        entity.setEid(eidModelOut.getId());
        entity.setFirstName(eidModelOut.getFirstName());
        entity.setMiddleName(eidModelOut.getMiddleName());
        entity.setLastName(eidModelOut.getLastName());
        entity.setAge(eidModelOut.getAge());
        entity.setGender(eidModelOut.getGender());
        entity.setPasswordHash(passwordEncoder.encode(CharBuffer.wrap(userModel.getPassword())));
        // routine addition is pending
        userRepository.save(entity).block();
    }

    @Override
    public Mono<UserModelOut> getUserById(String id) {
       return userRepository.findById(id).map(UserMapper::from);
    }


}
