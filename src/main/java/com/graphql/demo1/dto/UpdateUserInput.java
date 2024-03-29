package com.graphql.demo1.dto;

import com.graphql.demo1.model.AppUser;

public record UpdateUserInput(Long userId, String name, String email) {

}
