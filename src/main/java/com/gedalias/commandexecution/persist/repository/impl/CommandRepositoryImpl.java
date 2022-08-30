package com.gedalias.commandexecution.persist.repository.impl;

import com.gedalias.commandexecution.observer.OnUpdateCommandSubject;
import com.gedalias.commandexecution.persist.entity.CommandEntity;
import com.gedalias.commandexecution.persist.repository.CommandRepository;
import java.util.ArrayList;
import java.util.List;

public class CommandRepositoryImpl implements CommandRepository{
    private static List<CommandEntity> commands = new ArrayList<>();

    @Override
    public CommandEntity save(CommandEntity command) {
        commands.add(command);
        OnUpdateCommandSubject.updateCommandEvent(command);
        return command;
    }

    @Override
    public List<CommandEntity> findAll() {
        return commands;
    }
}
