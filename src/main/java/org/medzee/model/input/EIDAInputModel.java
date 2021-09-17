package org.medzee.model.input;

import lombok.Data;

import java.io.Serializable;

@Data
public class EIDAInputModel implements Serializable {
    private String identityNumber;
    private String firstName;
    private String middleName;
    private String lastName;
    private String gender;
    private String expiryDate;
    private String dob;
    private int age;
}
