/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.gedalias.commandexecution.persist.repository;

import com.gedalias.commandexecution.persist.entity.CommandEntity;
import java.util.List;

/**
 *
 * @author gedalias
 */
public interface CommandRepository {
    CommandEntity save(CommandEntity command);
    List<CommandEntity> findAll();
}
