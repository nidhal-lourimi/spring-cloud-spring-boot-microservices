package com.nidhallourimi.app.ws.userService;

import com.nidhallourimi.app.ws.data.UserEntity;
import com.nidhallourimi.app.ws.repository.UsersRepo;

import com.nidhallourimi.app.ws.shared.UserDto;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.UUID;

@Service
public class UserService implements IUserService {



    BCryptPasswordEncoder bCryptPasswordEncoder;
    UsersRepo userRepository;
    @Autowired
    public UserService(BCryptPasswordEncoder bCryptPasswordEncoder, UsersRepo userRepository) {
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.userRepository = userRepository;
    }



    @Override
    public UserDto createUser(UserDto userDetails) {
      userDetails.setUserId(UUID.randomUUID().toString());
      userDetails.setEncryptedPassword(bCryptPasswordEncoder.encode(userDetails.getPassword()));
      ModelMapper modelMapper=new ModelMapper();
      modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
      UserEntity userEntity=modelMapper.map(userDetails, UserEntity.class);

     userRepository.save(userEntity);
      return userDetails;
    }

    @Override
    public UserDto getUserDetailsByEmail(String email) {
        UserEntity userEntity=userRepository.findByEmail(email);
        if(userEntity==null)throw new UsernameNotFoundException(email);
        ModelMapper modelMapper=new ModelMapper();
        UserDto userDto=modelMapper.map(userEntity,UserDto.class);
        return userDto;

    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity = userRepository.findByEmail(username);
        if(userEntity==null)throw new UsernameNotFoundException(username);
        return new User(userEntity.getEmail(),userEntity.getEncryptedPassword(),true,true,true,true,new ArrayList<>());
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
