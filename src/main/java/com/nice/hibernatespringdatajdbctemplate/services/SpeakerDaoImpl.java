package com.nice.hibernatespringdatajdbctemplate.services;

import com.nice.hibernatespringdatajdbctemplate.model.Speaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * @author Evgeny Borisov
 */
@Repository
public class SpeakerDaoImpl implements SpeakerDao {
    @Autowired
    private JdbcTemplate template;

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void save(Speaker speaker) {
        entityManager.persist(speaker);
    }

    @Override
    public List<Speaker> findAll() {
       /* template.query("select * from Speaker",new Object[]{},resultSet -> {
            Speaker speaker = Speaker.builder().name(resultSet.getString("name"))
                    .id(resultSet.getInt("id")).build();
        });*/
        List<Speaker> speaker = entityManager.createQuery("from Speaker").getResultList();
        return speaker;
    }

    @Override
    public List<Speaker> findByName(String name) {
        return null;
    }
}






