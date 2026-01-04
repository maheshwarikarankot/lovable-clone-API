package com.backendProject.Lovable_Clone.mapper;

import com.backendProject.Lovable_Clone.dto.auth.SignUpRequest;
import com.backendProject.Lovable_Clone.dto.auth.UserProfileResponse;
import com.backendProject.Lovable_Clone.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User toEntity(SignUpRequest signUpRequest);
    UserProfileResponse toUserProfileResponse(User user);
}
