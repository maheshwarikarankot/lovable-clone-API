package com.backendProject.Lovable_Clone.controller;

import com.backendProject.Lovable_Clone.dto.project.FileContentResponse;
import com.backendProject.Lovable_Clone.dto.project.FileNode;
import com.backendProject.Lovable_Clone.service.FileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/projects/{projectId}/files")
public class FileController {

    private final FileService fileService;

    @GetMapping
    public ResponseEntity<List<FileNode>> getFileTree(@PathVariable Long projectId){
        Long userId = 1L;
        return ResponseEntity.ok(fileService.getFileTree(projectId,userId));
    }

    @GetMapping("/{*path}") // /{*path}= /src/hooks/Apphook.js= /(*path)-src/hooks/Apphook.js
    public ResponseEntity<FileContentResponse> getFile(
            @PathVariable Long projectId,
            @PathVariable String path
    ){
        Long userId = 1L;
        return ResponseEntity.ok(fileService.getFileContent(projectId,path,userId));
    }
}
