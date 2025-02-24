package com.ccsw.tutorial.prestamo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.sql.Date;

/**
 * @prestamo ccsw
 *
 */
@Entity
@Table(name = "prestamo")
public class Prestamo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @JsonProperty("game_name")
    @Column(name = "game_name", nullable = false)
    private String game_name;

    @JsonProperty("client_name")
    @Column(name = "client_name", nullable = false)
    private String client_name;

    @Column(name = "ini_Date", nullable = false)
    private Date ini_Date;

    @Column(name = "end_Date", nullable = false)
    private Date end_Date;

    /**
     * @return id
     */
    public Long getId() {

        return this.id;
    }

    /**
     * @param id new value of {@link #getId}.
     */
    public void setId(Long id) {

        this.id = id;
    }

    /**
     * @return game_name
     */
    public String getGame_Name() {
        return this.game_name;
    }

    /**
     * @param game_name new value of {@link #getGame_Name}.
     */
    public void setGame_Name(String game_name) {

        this.game_name = game_name;
    }

    /**
     * @return client_name
     */
    public String getClient_Name() {
        return this.client_name;
    }

    /**
     * @param client_name new value of {@link #getClient_Name}.
     */
    public void setClient_Name(String client_name) {

        this.client_name = client_name;
    }

    /**
     * @return ini_Date
     */
    public Date getIni() {

        return this.ini_Date;
    }

    /**
     * @param ini_Date new value of {@link #getIni}.
     */
    public void setIni(Date ini_Date) {

        this.ini_Date = ini_Date;
    }

    /**
     * @return end_Date
     */
    public Date getEnd() {

        return this.end_Date;
    }

    /**
     * @param end_Date new value of {@link #getEnd}.
     */
    public void setEnd(Date end_Date) {

        this.end_Date = end_Date;
    }

}