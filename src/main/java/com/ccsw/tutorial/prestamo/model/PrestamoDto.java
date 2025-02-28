package com.ccsw.tutorial.prestamo.model;

import java.time.LocalDate;

public class PrestamoDto {

    private Long id;

    private String game_name;

    private String client_name;

    private LocalDate ini_Date;

    private LocalDate end_Date;

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
     * @param name new value of {@link #getGame_Name}.
     */
    public void setGame_Name(String name) {

        this.game_name = name;
    }

    /**
     * @return client_name
     */
    public String getClient_Name() {
        return this.client_name;
    }

    /**
     * @param name new value of {@link #getClient_Name}.
     */
    public void setClient_Name(String name) {

        this.client_name = name;
    }

    /**
     * @return ini_Date
     */
    public LocalDate getIni() {

        return this.ini_Date;
    }

    /**
     * @param ini_Date new value of {@link #getIni}.
     */
    public void setIni(LocalDate ini_Date) {

        this.ini_Date = ini_Date;
    }

    /**
     * @return end_Date
     */
    public LocalDate getEnd() {

        return this.end_Date;
    }

    /**
     * @param end_Date new value of {@link #getEnd}.
     */
    public void setEnd(LocalDate end_Date) {

        this.end_Date = end_Date;
    }

}