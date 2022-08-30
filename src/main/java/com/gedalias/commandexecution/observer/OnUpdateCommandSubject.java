package com.gedalias.commandexecution.observer;

import com.gedalias.commandexecution.persist.entity.CommandEntity;
import java.util.ArrayList;
import java.util.List;

public class OnUpdateCommandSubject {
    private static final List<CommandObserver> observers = new ArrayList<>();
    
    public static void add(CommandObserver observer) {
        observers.add(observer);
    }
    
    public static void updateCommandEvent(CommandEntity commandEntity) {
        notifyObservers(commandEntity);
    }
    
    private static void notifyObservers(CommandEntity commandEntity) {
        for(CommandObserver observer: observers) {
            observer.update(commandEntity);
        }
    }
}
