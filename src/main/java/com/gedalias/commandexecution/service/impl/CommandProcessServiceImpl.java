package com.gedalias.commandexecution.service.impl;

import com.gedalias.commandexecution.service.CommandProcessService;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.function.Consumer;

import static java.nio.charset.StandardCharsets.UTF_8;

public class CommandProcessServiceImpl implements CommandProcessService {
    private Process process;
    private final String command;
    private Consumer<String> consumerOnOutput;
    private Runnable runnableOnFinish;
    private final String BREAK_LINE = "\n";

    public CommandProcessServiceImpl(final String command) {
        this.command = command;
    }

    @Override
    public void run() {
        try{
            process = Runtime.getRuntime().exec(new String[]{command});
            int line;
            while((line = process.inputReader(UTF_8).read()) != -1) {
                consumerOnOutput.accept(String.valueOf((char)line));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            runnableOnFinish.run();
        }
    }

    @Override
    public void start() {
        new Thread(this).start();
    }

    @Override
    public void stop() {
        process.destroy();
    }

    @Override
    public void input(String value) {
        try {
            BufferedWriter writer = process.outputWriter(UTF_8);
            writer.write(value.concat(BREAK_LINE));
            writer.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onOutput(Consumer<String> consumer) {
        consumerOnOutput = consumer;
    }

    @Override
    public void onFinish(Runnable callback) {
        runnableOnFinish = callback;
    }
}
