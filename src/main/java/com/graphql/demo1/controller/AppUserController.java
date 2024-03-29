package com.graphql.demo1.controller;

import com.graphql.demo1.dto.UpdateUserDTO;
import com.graphql.demo1.model.AppUser;
import com.graphql.demo1.service.AppUserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class AppUserController {
    private Logger logger = LogManager.getLogger("AppUserController");
    @Autowired
    private AppUserService appUserService;

    @PostMapping
    public AppUser createUser(@RequestBody AppUser appUser){
        logger.info("Creating user");
        return appUserService.createAppUser(appUser);
    }

    @QueryMapping(name = "user")
    public AppUser getUser(@Argument Long id){
        logger.info("Fetching user");
        return appUserService.getAppUser(id);
    }

    @QueryMapping(name = "users")
    public List<AppUser> getAllUsers(){
        logger.info("fetching all users");
        return appUserService.getAllAppUsers();
    }

    public AppUser updateUser(UpdateUserDTO updateUserDTO){
        logger.info("Updating user");
        return appUserService.updateUser(updateUserDTO.getUserId(),updateUserDTO.getAppUser());
    }

    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable Long userId){
        logger.info("deleting user");
        appUserService.deleteUser(userId);
    }
}
