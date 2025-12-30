package com.backendProject.Lovable_Clone.repository;

import com.backendProject.Lovable_Clone.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
