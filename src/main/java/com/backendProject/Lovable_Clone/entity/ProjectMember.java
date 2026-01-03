package com.backendProject.Lovable_Clone.entity;

import com.backendProject.Lovable_Clone.enums.ProjectRole;
import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "project_members")
public class ProjectMember {

    @EmbeddedId //using composite Id here
    private ProjectMemberId id; // takes all the fields of ProjectMemberId class & make primary key out of these two composite keys

    @ManyToOne
    @MapsId("projectId")
    private Project project;

    @ManyToOne
    @MapsId("userId")
    private User user;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ProjectRole projectRole;

    private Instant invitedAt;
    private Instant acceptedAt;

}
