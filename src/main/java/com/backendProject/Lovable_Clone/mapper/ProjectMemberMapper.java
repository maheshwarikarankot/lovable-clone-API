package com.backendProject.Lovable_Clone.mapper;

import com.backendProject.Lovable_Clone.dto.member.MemberResponse;
import com.backendProject.Lovable_Clone.entity.ProjectMember;
import com.backendProject.Lovable_Clone.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProjectMemberMapper {

    @Mapping(target = "userId", source = "id") //mapping User class id to MemberResponse's userId
    @Mapping(target = "projectRole", constant = "OWNER" )
    MemberResponse toProjectMemberResponseFromOwner(User owner);

    @Mapping(target = "userId",source = "user.id") //source-->ProjectMember class-User,this User class has id  & target--->MemberResponse's userId
    @Mapping(target = "email",source = "user.email")
    @Mapping(target = "name",source = "user.name")
    MemberResponse toProjectMemberResponseFromMember(ProjectMember projectMember);
}
