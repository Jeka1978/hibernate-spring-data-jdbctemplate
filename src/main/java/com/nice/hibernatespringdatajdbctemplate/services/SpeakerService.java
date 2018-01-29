package com.nice.hibernatespringdatajdbctemplate.services;

import com.nice.hibernatespringdatajdbctemplate.model.Speaker;

import java.util.List;

/**
 * @author Evgeny Borisov
 */
public interface SpeakerService {

    void save(Speaker speaker);

    List<Speaker> getAllSpeakers();

    List<Speaker> findByName(String name);

    List<Speaker> findSlavenianSpeakers();
}
