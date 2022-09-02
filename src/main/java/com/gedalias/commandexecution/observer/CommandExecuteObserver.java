package com.gedalias.commandexecution.observer;

public interface CommandExecuteObserver<T> {
    void add(CommandObserver observer);
    
    void onUpdateCommandEvent(T commandEntity);
    
    void notifyObservers(T commandEntity);
}
