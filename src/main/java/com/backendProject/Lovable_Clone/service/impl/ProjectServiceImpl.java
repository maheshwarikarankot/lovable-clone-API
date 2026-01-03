package com.backendProject.Lovable_Clone.service.impl;

import com.backendProject.Lovable_Clone.dto.project.ProjectRequest;
import com.backendProject.Lovable_Clone.dto.project.ProjectResponse;
import com.backendProject.Lovable_Clone.dto.project.ProjectSummaryResponse;
import com.backendProject.Lovable_Clone.entity.Project;
import com.backendProject.Lovable_Clone.entity.User;
import com.backendProject.Lovable_Clone.error.ResourceNotFoundException;
import com.backendProject.Lovable_Clone.mapper.ProjectMapper;
import com.backendProject.Lovable_Clone.repository.ProjectRepository;
import com.backendProject.Lovable_Clone.repository.UserRepository;
import com.backendProject.Lovable_Clone.service.ProjectService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;
    private final UserRepository userRepository;
    private final ProjectMapper projectMapper;

    @Override
    public ProjectResponse createProject(ProjectRequest request, Long userId) {
        User owner = userRepository.findById(userId).orElseThrow();
        Project project = Project.builder()
                .name(request.name())
                .owner(owner)
                .isPublic(false)
                .build();
        project = projectRepository.save(project);
//        return new ProjectResponse(project.getId(), project.getName(), project.getCreatedAt(),project.getUpdatedAt());
        return projectMapper.toProjectResponse(project); //using mapper model
    }

    @Override
    public List<ProjectSummaryResponse> getUserProjects(Long userid) {
//        return List.of();
//  Returning list of ProjectSummaryResponse can be done in 2 ways: using stream & project mapper
//      return projectRepository.findAllAccessibleByUser(userid)//gives list of Project, but it require list of project summary response
      //conversion of List<Project> to List<ProjectSummaryResponse>
//  1. Using stream
//              .stream()
//              .map(projectMapper::toProjectSummaryResponse)
//              .collect(Collectors.toList());

//  2. Using ProjectMapper
       var projects = projectRepository.findAllAccessibleByUser(userid);
       return projectMapper.toListOfProjectSummaryResponse(projects);
    }

    @Override
    public ProjectResponse getUserProjectById(Long id, Long userId) {
//        return null;
        Project project = getAccessibleProjectById(id, userId);

        return projectMapper.toProjectResponse(project);
    }

    @Override
    public ProjectResponse updateProject(Long id, ProjectRequest request, Long userId) {
//        return null;
//        Project project = projectRepository.findAccessibleProjectById(id,userId).orElseThrow();
        Project project = getAccessibleProjectById(id,userId);

        if(!project.getOwner().getId().equals(userId)){
            throw  new RuntimeException("You are not allowed to update the name");
        }

        project.setName(request.name());
        project = projectRepository.save(project);

        return projectMapper.toProjectResponse(project);
    }

    @Override
    public void softDelete(Long id, Long userId) {
        Project project = getAccessibleProjectById(id,userId);

        if(!project.getOwner().getId().equals(userId)){
            throw  new RuntimeException("You are not allowed to delete");
        }
        project.setDeletedAt(Instant.now());
        projectRepository.save(project);
    }
    /// Internal functions
    public Project getAccessibleProjectById(Long projectId, Long userId){
        return projectRepository.findAccessibleProjectById(projectId,userId)
//                .orElseThrow(() -> new ResourceNotFoundException("Project",projectId.toString()));
                .orElseThrow(() -> new ResourceNotFoundException("Project", projectId.toString()));
    }
}
