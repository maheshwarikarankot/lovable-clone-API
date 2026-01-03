package com.backendProject.Lovable_Clone.mapper;

import com.backendProject.Lovable_Clone.dto.project.ProjectResponse;
import com.backendProject.Lovable_Clone.dto.project.ProjectSummaryResponse;
import com.backendProject.Lovable_Clone.entity.Project;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProjectMapper {

    ProjectResponse toProjectResponse(Project project);

    @Mapping(source = "name", target = "projectName") //dto--> ProjectSummaryResponse-Recorder--> changing field name to different name--> we can use @Mapping, by providing source & target.***explore more in mapping class
    ProjectSummaryResponse toProjectSummaryResponse(Project project); //source--> Project class-field name as "name" & target---> ProjectSummaryResponse class-field name to "projectName"

    List<ProjectSummaryResponse> toListOfProjectSummaryResponse(List<Project> projects);
}
