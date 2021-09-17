package org.medzee.model.input;

import lombok.Data;

@Data
public class SignupInputModel {
    private String identityNumber;
    private char[] password;
    private UserRoutineInputModel userRoutine;
}
