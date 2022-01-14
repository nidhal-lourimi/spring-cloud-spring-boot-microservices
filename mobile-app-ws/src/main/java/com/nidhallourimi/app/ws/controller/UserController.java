package com.nidhallourimi.app.ws.controller;

import com.nidhallourimi.app.ws.exceptions.UserServiceException;
import com.nidhallourimi.app.ws.model.request.UpdateUserDetailsRequestModel;
import com.nidhallourimi.app.ws.model.request.UserDetailsRequestModel;
import com.nidhallourimi.app.ws.model.response.UserRest;
import com.nidhallourimi.app.ws.userService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("users")


public class UserController {

    Map<String,UserRest> users;
    @Autowired
    UserService userService;

    @GetMapping(path = "/status")
    public String checkStatus() {
        return "working ....";
    }

    @GetMapping
    public String getUsers(@RequestParam(value = "page",defaultValue = "1") int page,
                           @RequestParam(value = "limit",defaultValue = "30") int limit)
    {
    return "get user was called with page = "+page+" and limit = "+limit ;
    }

    @GetMapping(path ="/{userId}",produces = {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity getUser(@PathVariable String userId) {
        /*if(true)throw new UserServiceException("A user service exception is thrown");*/

        if (users.containsKey(userId)) {
            return new ResponseEntity(users.get(userId), HttpStatus.OK);
        }else {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }

    }
    @PostMapping(consumes ={MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE} ,
                produces = {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity createUser(@Valid @RequestBody UserDetailsRequestModel userDetails){

        UserRest returnValue= userService.createUser(userDetails);
        return new ResponseEntity(returnValue,HttpStatus.OK);
    }
    @PutMapping(path ="/{userId}" ,consumes ={MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE} ,
            produces = {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity updateUser(@PathVariable String userId,@Valid @RequestBody UpdateUserDetailsRequestModel userDetails){
       if(users.containsKey(userId) ){
           UserRest storedUser = users.get(userId);
           storedUser.setFirstName(userDetails.getFirstName());
           storedUser.setLastName(userDetails.getLastName());
           users.put(userId,storedUser);
           return new ResponseEntity(storedUser,HttpStatus.OK);

       }else {
           return new ResponseEntity(HttpStatus.NOT_FOUND);
       }
    }

    @DeleteMapping(path = "/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable String userId){
        users.remove(userId);
        return ResponseEntity.noContent().build();
    }



}
