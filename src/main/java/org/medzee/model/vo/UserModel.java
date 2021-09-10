package org.medzee.model.vo;

import lombok.Data;

@Data
public class UserModel {
    char[] password;
    UserRoutine userRoutine;
}
