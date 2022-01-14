package com.nidhallourimi.app.ws.userService;

import com.nidhallourimi.app.ws.model.request.UserDetailsRequestModel;
import com.nidhallourimi.app.ws.model.response.UserRest;

public interface IUserService {
  UserRest createUser(UserDetailsRequestModel userDetails);
}
