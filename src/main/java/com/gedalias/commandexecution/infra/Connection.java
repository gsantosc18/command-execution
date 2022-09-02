package com.gedalias.commandexecution.infra;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Connection {
    private static EntityManagerFactory entityManager;
    static {
        try{
            entityManager = Persistence.createEntityManagerFactory("banco");
        } catch(Exception ex) {
            Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, ex.getMessage());
        }
    }
    
    public static EntityManagerFactory getEntityManager() {
        return entityManager;
    }
}
