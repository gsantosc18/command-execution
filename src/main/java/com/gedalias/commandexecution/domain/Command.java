package com.gedalias.commandexecution.domain;

import java.time.LocalDateTime;

public record Command(
    Long id,
    String description,
    String command,
    LocalDateTime createdAt,
    LocalDateTime updatedAt
) {
}
