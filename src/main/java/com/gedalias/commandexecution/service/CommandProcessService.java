package com.gedalias.commandexecution.service;

import java.util.function.Consumer;

public interface CommandProcessService extends Runnable {
    void start();
    void stop();
    void input(String value);
    void onOutput(Consumer<String> callback);
    void onFinish(Runnable callback);
}
