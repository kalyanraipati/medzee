package org.medzee.entity;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document(collection = "eid_tp")
public class EIDEntity extends BaseEntity {
    String firstName;
    String middleName;
    String lastName;
    int age;
    String gender;
}
