package com.graphql.demo1.service;

import com.graphql.demo1.model.AppUser;
import com.graphql.demo1.repository.AppUserRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppUserService {
    private Logger logger = LogManager.getLogger("AppUserService");
    @Autowired
    private AppUserRepository appUserRepository;

    /**
     * Creates AppUser model
     * @param appUser
     * @return appUser
     */
    public AppUser createAppUser(AppUser appUser) {
        logger.info("Creating user");
        return appUserRepository.save(appUser);
    }


    /**
     * Returns user by user id value
     * @param userId
     * @return appUser
     */
    public AppUser getAppUser(Long userId) {
        logger.info("Fetching user with userId: " + userId);
        return appUserRepository.findById(userId).get();
    }

    /**
     * returns a list of all user
     * @return List<AppUsers>
     */
    public List<AppUser> getAllAppUsers() {
        logger.info("Fetching all users...");
        return appUserRepository.findAll();
    }

    /**
     * updates user values
     * @param appUser
     * @return appUser
     */
    public AppUser updateUser(Long userId,AppUser appUser) {
        logger.info("Updating user values for user with userId: " + appUser.getId());
        appUser.setId(userId);
        return appUserRepository.save(appUser);
    }

    /**
     * Deletes user
     * @param userId
     */
    public void deleteUser(Long userId){
        logger.info("Deleting user " + userId);
          appUserRepository.deleteById(userId);
    }
}
