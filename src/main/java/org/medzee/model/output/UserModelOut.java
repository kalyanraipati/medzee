package org.medzee.model.output;

import lombok.Data;

@Data
public class UserModelOut {
    String id;
    String eId;
    String firstName;
    String middleName;
    String lastName;
    int age;
    String gender;
}
