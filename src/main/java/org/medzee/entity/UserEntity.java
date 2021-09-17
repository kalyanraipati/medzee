package org.medzee.entity;

import com.fasterxml.jackson.databind.ser.Serializers;
import lombok.Data;
import org.springframework.data.annotation.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document("user")
public class UserEntity extends BaseEntity {
    @Transient
    public static final String SEQUENCE_NAME = "users_sequence";

    private String identityNumber;
    private String passwordHash;
    private String firstName;
    private String middleName;
    private String lastName;
    private String gender;
    private int age;
    private UserEntity userEntity;
}
