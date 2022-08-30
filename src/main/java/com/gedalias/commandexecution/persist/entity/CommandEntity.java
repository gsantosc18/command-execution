package com.gedalias.commandexecution.persist.entity;

import java.time.LocalDateTime;

public record CommandEntity (
    Long id,
    String description,
    String command,
    LocalDateTime createdAt,
    LocalDateTime updatedAt
){}
