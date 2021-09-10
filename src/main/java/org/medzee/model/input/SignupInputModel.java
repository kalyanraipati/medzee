package org.medzee.model.input;

import lombok.Data;

@Data
public class SignupInputModel {
    private String eid;
    private char[] password;
    private UserRoutineInputModel userRoutine;
}
