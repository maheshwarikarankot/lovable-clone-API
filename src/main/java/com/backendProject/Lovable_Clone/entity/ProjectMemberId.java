package com.backendProject.Lovable_Clone.entity;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Embeddable //when we've repeatable fields & don't want to repeat the code in the table
public class ProjectMemberId {

//    private ProjectMemberId id;
//    private Project project;
//    private User user;
    Long projectId;
    Long userId;

}
