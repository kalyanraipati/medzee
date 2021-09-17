package org.medzee.mapper;

import org.medzee.entity.UserEntity;
import org.medzee.model.output.UserModelOut;
import org.medzee.model.vo.UserModel;

public class UserMapper {

    public static UserEntity from(UserModel model){
        UserEntity entity=new UserEntity();
        entity.setUserEntity(new UserEntity());
        return entity;
    }
    public static UserModelOut from(UserEntity entity){
        UserModelOut modelOut=new UserModelOut();
        modelOut.setEId(entity.getIdentityNumber());
        modelOut.setId(entity.getId());
        modelOut.setAge(entity.getAge());
        modelOut.setGender(entity.getGender());
        modelOut.setFirstName(entity.getFirstName());
        modelOut.setLastName(entity.getLastName());
        modelOut.setMiddleName(entity.getMiddleName());
        return modelOut;
    }
}
