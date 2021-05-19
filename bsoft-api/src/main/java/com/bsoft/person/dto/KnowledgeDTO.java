package com.bsoft.person.dto;

import java.io.Serializable;
import java.util.Date;


public class KnowledgeDTO implements Serializable {
    private Integer id;
    private String personId;
    private String catalog;
    private Date finishDate;
    private String outline;
    private String author;
    private Integer master;
    private Integer enclosure;
    private String enclosureName;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public String getCatalog() {
        return catalog;
    }

    public void setCatalog(String catalog) {
        this.catalog = catalog;
    }

    public Date getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(Date finishDate) {
        this.finishDate = finishDate;
    }

    public String getOutline() {
        return outline;
    }

    public void setOutline(String outline) {
        this.outline = outline;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getMaster() {
        return master;
    }

    public void setMaster(Integer master) {
        this.master = master;
    }

    public Integer getEnclosure() {
        return enclosure;
    }

    public void setEnclosure(Integer enclosure) {
        this.enclosure = enclosure;
    }

    public String getEnclosureName() {
        return enclosureName;
    }

    public void setEnclosureName(String enclosureName) {
        this.enclosureName = enclosureName;
    }
}
