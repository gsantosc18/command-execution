package com.gedalias.commandexecution.observer;

import com.gedalias.commandexecution.persist.entity.CommandEntity;

public interface CommandObserver {
    void update(CommandEntity command);
}
