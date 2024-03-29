package com.graphql.demo1.dto;

import com.graphql.demo1.model.AppUser;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateUserDTO {
    private Long userId;
    private AppUser appUser;
}
