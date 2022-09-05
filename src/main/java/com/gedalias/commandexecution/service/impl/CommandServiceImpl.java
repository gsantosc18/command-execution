package com.gedalias.commandexecution.service.impl;

import com.gedalias.commandexecution.persist.entity.CommandEntity;
import com.gedalias.commandexecution.persist.repository.CommandRepository;
import com.gedalias.commandexecution.persist.repository.impl.CommandRepositoryImpl;
import com.gedalias.commandexecution.service.CommandService;

import java.util.List;

public class CommandServiceImpl implements CommandService {
    private final CommandRepository commandRepository;

    public CommandServiceImpl() {
        this.commandRepository = new CommandRepositoryImpl();
    }

    @Override
    public CommandEntity save(CommandEntity commandEntity) {
        return commandRepository.save(commandEntity);
    }

    @Override
    public void delete(CommandEntity commandEntity) {
        commandRepository.delete(commandEntity);
    }

    @Override
    public List<CommandEntity> findAll() {
        return commandRepository.findAll();
    }
}
