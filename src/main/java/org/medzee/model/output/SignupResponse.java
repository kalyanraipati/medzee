package org.medzee.model.output;

import lombok.Data;

import java.io.Serializable;

@Data
public class SignupResponse implements Serializable {
    private String registrationId;
}
