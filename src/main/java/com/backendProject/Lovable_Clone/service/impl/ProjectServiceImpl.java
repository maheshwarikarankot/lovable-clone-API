package com.backendProject.Lovable_Clone.service.impl;

import com.backendProject.Lovable_Clone.dto.project.ProjectRequest;
import com.backendProject.Lovable_Clone.dto.project.ProjectResponse;
import com.backendProject.Lovable_Clone.dto.project.ProjectSummaryResponse;
import com.backendProject.Lovable_Clone.entity.Project;
import com.backendProject.Lovable_Clone.entity.User;
import com.backendProject.Lovable_Clone.repository.ProjectRepository;
import com.backendProject.Lovable_Clone.repository.UserRepository;
import com.backendProject.Lovable_Clone.service.ProjectService;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;
    private final UserRepository userRepository;
    @Override
    public ProjectResponse createProject(ProjectRequest request, Long userId) {
        User owner = userRepository.findById(userId).orElseThrow();
        Project project = Project.builder()
                .name(request.name())
                .owner(owner)
                .build();
        project = projectRepository.save(project);

        return new ProjectResponse(project.getId(), project.getName(), project.getCreatedAt(),project.getUpdatedAt());
    }

    @Override
    public List<ProjectSummaryResponse> getUserProjects(Long userid) {
        return List.of();
    }

    @Override
    public ProjectResponse getUserProjectById(Long id, Long userId) {
        return null;
    }

    @Override
    public ProjectResponse updateProject(Long id, ProjectRequest request, Long userId) {
        return null;
    }

    @Override
    public void softDelete(Long id, Long userId) {

    }
}
