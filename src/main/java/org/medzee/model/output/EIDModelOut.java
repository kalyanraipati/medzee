package org.medzee.model.output;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Data
public class EIDModelOut {
    String id;
    String firstName;
    String middleName;
    String lastName;
    int age;
    String gender;
    String expiryDate;
    String dob;

}
