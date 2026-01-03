package com.backendProject.Lovable_Clone.repository;

import com.backendProject.Lovable_Clone.entity.ProjectMember;
import com.backendProject.Lovable_Clone.entity.ProjectMemberId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectMemberRepository extends JpaRepository<ProjectMember, ProjectMemberId> {

    List<ProjectMember> findByProjectId(Long projectId);

    boolean existsById(ProjectMemberId projectMemberId);
}
