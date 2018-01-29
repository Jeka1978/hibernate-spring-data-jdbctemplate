package com.nice.hibernatespringdatajdbctemplate.services;

import com.nice.hibernatespringdatajdbctemplate.model.Speaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Evgeny Borisov
 */
//@Transactional
@Service
public class SpeakerServiceImpl implements SpeakerService {

    @Autowired
    private SpeakerDao speakerDao;
    @SelfInject
    private SpeakerService proxy;

    @Override
    public void save(Speaker speaker) {
        speakerDao.save(speaker);
    }

    @Override
    public List<Speaker> getAllSpeakers() {
//        proxy.findByName("Jeka");
        return speakerDao.findAll();
    }

    @Override
    public List<Speaker> findByName(String name) {
        return speakerDao.findByName(name);
    }

    @Override
    public List<Speaker> findSlavenianSpeakers() {
        return speakerDao.findPleaseSpeakersByNameEndingWith("ov");
    }

}


