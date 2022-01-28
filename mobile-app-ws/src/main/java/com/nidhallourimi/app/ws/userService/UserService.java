package com.nidhallourimi.app.ws.userService;

import com.nidhallourimi.app.ws.data.UserEntity;
import com.nidhallourimi.app.ws.repository.UsersRepo;

import com.nidhallourimi.app.ws.shared.UserDto;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserService implements IUserService {



    UsersRepo userRepository;

    @Autowired
    public UserService(UsersRepo userRepository) {

        this.userRepository=userRepository;
    }

    @Override
    public UserDto createUser(UserDto userDetails) {
      userDetails.setUserId(UUID.randomUUID().toString());
      ModelMapper modelMapper=new ModelMapper();
      modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
      UserEntity userEntity=modelMapper.map(userDetails, UserEntity.class);
      userEntity.setEncryptedPassword("test");
     userRepository.save(userEntity);
      return userDetails;
    }

/*    @Override
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
    }*/
}
