package com.gedalias.commandexecution.observer;

import com.gedalias.commandexecution.persist.entity.CommandEntity;
import java.util.ArrayList;
import java.util.List;

public class OnUpdateCommandSubject implements CommandExecuteObserver<CommandEntity> {
    private static final List<CommandObserver> observers = new ArrayList<>();
    
    private static OnUpdateCommandSubject instance;
    
    private OnUpdateCommandSubject() {}
    
    public static OnUpdateCommandSubject getInstance() {
        if(instance == null) {
            instance = new OnUpdateCommandSubject();
        }
        return instance;
    }
    
    public void add(CommandObserver observer) {
        observers.add(observer);
    }
    
    public void onUpdateCommandEvent(CommandEntity commandEntity) {
        notifyObservers(commandEntity);
    }
    
    public void notifyObservers(CommandEntity commandEntity) {
        for(CommandObserver observer: observers) {
            observer.update(commandEntity);
        }
    }
}
