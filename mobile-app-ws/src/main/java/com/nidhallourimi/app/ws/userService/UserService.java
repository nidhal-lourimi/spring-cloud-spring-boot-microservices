package com.nidhallourimi.app.ws.userService;

import com.nidhallourimi.app.ws.model.request.UserDetailsRequestModel;
import com.nidhallourimi.app.ws.model.response.UserRest;
import com.nidhallourimi.app.ws.shared.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class UserService implements IUserService {
    Map<String, UserRest> users;
    Utils utils;

    public UserService() {
    }

    @Autowired
    public UserService(Utils utils) {
        this.utils = utils;
    }

    @Override
    public UserRest createUser(UserDetailsRequestModel userDetails) {
        UserRest returnValue = new UserRest();
        returnValue.setEmail(userDetails.getEmail());
        returnValue.setFirstName(userDetails.getFirstName());
        returnValue.setLastName(userDetails.getLastName());
        String userId = utils.generateUserId();
        returnValue.setUserId(userId);
        if (users == null) users = new HashMap<>();
        users.put(userId, returnValue);

        return returnValue;
    }
}
