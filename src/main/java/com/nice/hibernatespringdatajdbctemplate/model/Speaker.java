package com.nice.hibernatespringdatajdbctemplate.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

/**
 * @author Evgeny Borisov
 */
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Speaker {
    @Id
    @GeneratedValue
    private int id;

    private String name;

    @OneToMany(cascade = CascadeType.ALL)
    @Singular
    private List<Talk> talks;

}










