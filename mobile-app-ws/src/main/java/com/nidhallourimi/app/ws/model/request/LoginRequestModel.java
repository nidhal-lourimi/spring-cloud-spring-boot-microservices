package com.nidhallourimi.app.ws.model.request;

import javax.validation.constraints.NotNull;

public record LoginRequestModel(@NotNull(message = "email field should not be null") String email,
                                @NotNull(message = "password field should not be null") String password) {

}
