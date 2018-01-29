package com.nice.hibernatespringdatajdbctemplate.services;

import com.nice.hibernatespringdatajdbctemplate.model.Speaker;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * @author Evgeny Borisov
 */
public interface SpeakerDao extends CrudRepository<Speaker, Integer> {

    List<Speaker> findByName(String name);

    List<Speaker> findAll();

//    List<Speaker> findByTalksNameContains(String partOfName);

    List<Speaker> findPleaseSpeakersByNameEndingWith(String suffix);
}
