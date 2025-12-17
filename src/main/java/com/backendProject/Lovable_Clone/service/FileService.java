package com.backendProject.Lovable_Clone.service;

import com.backendProject.Lovable_Clone.dto.project.FileContentResponse;
import com.backendProject.Lovable_Clone.dto.project.FileNode;

import java.util.List;

public interface FileService {
    List<FileNode> getFileTree(Long projectId, Long userId);
    FileContentResponse getFileContent(Long projectId, String path, Long userId);
}
