package com.nidhallourimi.app.ws.userService;

import com.nidhallourimi.app.ws.shared.UserDto;
import org.springframework.security.core.userdetails.UserDetailsService;


public interface IUserService extends UserDetailsService {

  UserDto createUser(UserDto userDetails);
  UserDto getUserDetailsByEmail(String email);
  UserDto getUserByUserId(String userId) ;
}
