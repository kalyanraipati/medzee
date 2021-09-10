package org.medzee.mapper;

import org.medzee.entity.EIDEntity;
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
        return out;
    }
}
