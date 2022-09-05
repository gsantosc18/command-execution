package com.gedalias.commandexecution.utils;

import com.gedalias.commandexecution.service.CommandProcessService;
import com.gedalias.commandexecution.service.impl.CommandProcessServiceImpl;

import java.util.function.Consumer;

public class CommandBuilder {
    private String command;
    private Consumer<String> onOutput;
    private Runnable onFinish;


    public static CommandBuilder create() {
        return new CommandBuilder();
    }

    public CommandBuilder command(final String command) {
        this.command = command;
        return this;
    }

    public CommandBuilder onOutput(Consumer<String> consumer) {
        onOutput = consumer;
        return this;
    }

    public CommandBuilder onFinish(Runnable runnable) {
        onFinish = runnable;
        return this;
    }

    public CommandProcessService builder() {
        final CommandProcessService commandProcessService = new CommandProcessServiceImpl(this.command);
        commandProcessService.onOutput(onOutput);
        commandProcessService.onFinish(onFinish);
        commandProcessService.start();
        return commandProcessService;
    }
}
