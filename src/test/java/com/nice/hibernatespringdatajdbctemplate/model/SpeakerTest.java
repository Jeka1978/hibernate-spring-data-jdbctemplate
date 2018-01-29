package com.nice.hibernatespringdatajdbctemplate.model;

import com.nice.hibernatespringdatajdbctemplate.services.SpeakerService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author Evgeny Borisov
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpeakerTest {

    @Autowired
    SpeakerService speakerService;

    @Before
    public void setUp() throws Exception {
        Speaker speaker = Speaker.builder().name("Jeka Borisov")
                .talk(Talk.builder().name("Spring the Ripper").date(new Date()).build())
                .talk(Talk.builder().name("Spring Data").date(new Date()).build())
                .talk(Talk.builder().name("Spring Boot").date(new Date()).build())
                .build();
        Speaker speaker2 = Speaker.builder().name("Baruch Sadogursky")
                .talk(Talk.builder().name("Hibernate").date(new Date()).build())
                .talk(Talk.builder().name("Artifactory").date(new Date()).build())
                .build();
        Speaker speaker3= Speaker.builder().name("Nikolai Alimenkov")
                .talk(Talk.builder().name("Hibernate").date(new Date()).build())
                .talk(Talk.builder().name("Artifactory").date(new Date()).build())
                .build();
        speakerService.save(speaker);
        speakerService.save(speaker2);
        speakerService.save(speaker3);
    }

    @Test
    public void getName() throws Exception {
        List<Speaker> speakers = speakerService.getAllSpeakers();
        Assert.assertEquals(3,speakers.size());
        List<Speaker> jekaSpeakers = speakerService.findByName("Jeka Borisov");
        Assert.assertEquals(1,jekaSpeakers.size());

    }

    @Test
    public void testThatWeHaveOnly2SlavenianNamedSpeakers() {
        List<Speaker> speakers = speakerService.findSlavenianSpeakers();
        Assert.assertEquals(2, speakers.size());
        speakers.forEach(speaker-> System.out.println(speaker.getName()));
    }

}


