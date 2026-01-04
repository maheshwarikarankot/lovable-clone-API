package com.backendProject.Lovable_Clone.error;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class BadRequestException extends RuntimeException{
    private final String message;
}
