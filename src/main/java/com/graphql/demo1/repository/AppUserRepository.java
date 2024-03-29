package com.graphql.demo1.repository;

import com.graphql.demo1.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppUserRepository extends JpaRepository<AppUser, Long> {

    void deleteById(Long id);
}
