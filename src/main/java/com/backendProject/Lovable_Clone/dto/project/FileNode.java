package com.backendProject.Lovable_Clone.dto.project;

import java.time.Instant;

public record FileNode(
     String path,
     Instant modifiedAt,
     Long size,
     String type
) {
}
