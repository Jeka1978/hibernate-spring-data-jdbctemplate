package com.nice.hibernatespringdatajdbctemplate.services;

import com.nice.hibernatespringdatajdbctemplate.model.Speaker;

import java.util.List;

/**
 * @author Evgeny Borisov
 */
public interface SpeakerDao {
    void save(Speaker speaker);

    List<Speaker> findAll();

    List<Speaker> findByName(String name);
}
