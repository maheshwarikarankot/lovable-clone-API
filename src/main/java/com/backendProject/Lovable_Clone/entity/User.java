package com.backendProject.Lovable_Clone.entity;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.time.LocalDateTime;

@Getter
@Setter
public class User {

    private Long id;

    private String email;
    private String passwordHash;
    private String name;

    private String avatarUrl;

//  LocalDateTime createdAt; //or Instant-used to define time & has more functions compare to LocalDateTime
    private Instant createdAt;
    private Instant updatedAt;
    private Instant deletedAt; //soft delete

}
