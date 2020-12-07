package com.example.simplerestapis.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "jobs")
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(max = 100)
    private String UUID;

    @NotNull
    @Size(max = 250)
    private String STATUS;

    @Size(max = 250)
    private String RESULT;

    private Integer STEP;

    public Integer getSTEP() {
        return STEP;
    }

    public void setSTEP(Integer STEP) {
        this.STEP = STEP;
    }

    public Integer getGOAL() {
        return GOAL;
    }

    public void setGOAL(Integer GOAL) {
        this.GOAL = GOAL;
    }

    private Integer GOAL;

    public String getRESULT() {
        return RESULT;
    }

    public void setRESULT(String RESULT) {
        this.RESULT = RESULT;
    }





    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUUID() {
        return UUID;
    }

    public void setUUID(String UUID) {
        this.UUID = UUID;
    }

    public String getSTATUS() {
        return STATUS;
    }

    public void setSTATUS(String STATUS) {
        this.STATUS = STATUS;
    }
}
