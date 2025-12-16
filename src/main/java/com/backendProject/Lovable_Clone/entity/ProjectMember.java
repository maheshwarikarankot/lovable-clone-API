package com.backendProject.Lovable_Clone.entity;

import com.backendProject.Lovable_Clone.enums.ProjectRole;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
public class ProjectMember {

    private ProjectMemberId id;
    private Project project;
    private User user;

    private ProjectRole projectRole;

    private Instant invitedAt;
    private Instant acceptedAt;

}
