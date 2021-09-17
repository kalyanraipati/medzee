package org.medzee.mapper;

import org.medzee.entity.EIDEntity;
import org.medzee.model.input.EIDAInputModel;
import org.medzee.model.output.EIDModelOut;

public class EidMapper {

    public static EIDModelOut from(EIDEntity entity){
        EIDModelOut out=new EIDModelOut();
        out.setId(entity.getId());
        out.setAge(entity.getAge());
        out.setFirstName(entity.getFirstName());
        out.setGender(entity.getGender());
        out.setLastName(entity.getLastName());
        out.setMiddleName(entity.getMiddleName());
        out.setExpiryDate(entity.getExpiryDate());
        out.setDob(entity.getDob());
        return out;
    }

    public static EIDEntity getEntity(EIDAInputModel eidaInputModel){
        EIDEntity out=new EIDEntity();
        out.setId(eidaInputModel.getIdentityNumber());
        out.setAge(eidaInputModel.getAge());
        out.setFirstName(eidaInputModel.getFirstName());
        out.setGender(eidaInputModel.getGender());
        out.setLastName(eidaInputModel.getLastName());
        out.setMiddleName(eidaInputModel.getMiddleName());
        out.setDob(eidaInputModel.getDob());
        out.setExpiryDate(eidaInputModel.getExpiryDate());
        return out;
    }
}
