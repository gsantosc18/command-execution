package com.gedalias.commandexecution.persist.repository.impl;

import com.gedalias.commandexecution.infra.Connection;
import com.gedalias.commandexecution.observer.OnUpdateCommandSubject;
import com.gedalias.commandexecution.persist.entity.CommandEntity;
import com.gedalias.commandexecution.persist.repository.CommandRepository;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CommandRepositoryImpl implements CommandRepository{
    private final EntityManager entityManager;

    public CommandRepositoryImpl() {
        entityManager = Connection.getEntityManager().createEntityManager();
    }

    @Override
    public CommandEntity save(CommandEntity command) {
        Logger.getLogger(CommandRepositoryImpl.class.getName()).log(Level.INFO, "Iniciada a persistencia do comando");
        entityManager.getTransaction().begin();
        entityManager.persist(command);
        entityManager.getTransaction().commit();
        OnUpdateCommandSubject.getInstance().onUpdateCommandEvent(command);
        Logger.getLogger(CommandRepositoryImpl.class.getName()).log(Level.INFO, "Finalizada a persistencia do comando");
        return command;
    }

    @Override
    public List<CommandEntity> findAll() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<CommandEntity> cq = cb.createQuery(CommandEntity.class);
        Root<CommandEntity> root = cq.from(CommandEntity.class);
        CriteriaQuery<CommandEntity> all = cq.select(root);
        
        return entityManager.createQuery(all).getResultList();
    }

    @Override
    public void delete(CommandEntity command) {
        entityManager.getTransaction().begin();
        entityManager.remove(command);
        entityManager.getTransaction().commit();
        entityManager.flush();
        entityManager.clear();
    }
}
