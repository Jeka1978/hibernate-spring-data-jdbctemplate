package com.nice.hibernatespringdatajdbctemplate.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * @author Evgeny Borisov
 */
@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Talk {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private Date date;
}










