package com.graphql.demo1.controller;

import com.graphql.demo1.dto.CreateUserInput;
import com.graphql.demo1.dto.UpdateUserInput;
import com.graphql.demo1.model.AppUser;
import com.graphql.demo1.service.AppUserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
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
    public AppUser createUser(@RequestBody AppUser appUser) {
        logger.info("Creating user");
        return appUserService.createAppUser(appUser);
    }

    @MutationMapping(name = "createUser")
    public AppUser createUser(@Argument CreateUserInput createUserInput) {
        logger.info("Creating user");
        return appUserService.createAppUser(new AppUser(null, createUserInput.name(), createUserInput.email()));
    }

    @QueryMapping(name = "user")
    public AppUser getUser(@Argument Long id) {
        logger.info("Fetching user");
        return appUserService.getAppUser(id);
    }

    @QueryMapping(name = "users")
    public List<AppUser> getAllUsers() {
        logger.info("fetching all users");
        return appUserService.getAllAppUsers();
    }

    @MutationMapping(name = "updateUser")
    public AppUser updateUser(@Argument Long id, @Argument(name = "updateUserInput") UpdateUserInput updateUserInput) {
        logger.info("Updating user");
        return appUserService.updateUser(new AppUser(id, updateUserInput.name(), updateUserInput.email()));
    }

    @MutationMapping(name = "deleteUser")
    public void deleteUser(@Argument Long userId) {
        logger.info("deleting user");
        appUserService.deleteUser(userId);
    }
}
