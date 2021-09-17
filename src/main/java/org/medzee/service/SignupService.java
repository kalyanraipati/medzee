package org.medzee.service;

import org.medzee.model.input.SignupInputModel;
import org.medzee.model.output.SignupResponse;

public interface SignupService {
    SignupResponse signup(SignupInputModel inputModel);

    SignupResponse authenticate(SignupInputModel inputModel);
}
