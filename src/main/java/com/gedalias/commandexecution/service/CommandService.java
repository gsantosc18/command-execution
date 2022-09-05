package com.gedalias.commandexecution.service;

import com.gedalias.commandexecution.persist.entity.CommandEntity;

import java.util.List;

public interface CommandService {
    CommandEntity save(CommandEntity commandEntity);
    void delete(CommandEntity commandEntity);
    List<CommandEntity> findAll();
}
