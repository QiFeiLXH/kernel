package com.bsoft.person.entity.primary;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "hr_person_knowledge")
public class KnowledgeDO {
    private Integer id;
    /** 员工id */
    private String personId;
    /** 知识贡献 */
    private String catalog;
    /** 完成时间 */
    private Date finishDate;
    /** 概要 */
    private String outline;
    /** 第几作者 */
    private String author;
    /** 是否代表作 */
    private Integer master;
    /** 附件id */
    private Integer enclosure;
    /** 附件名 */
    private String enclosureName;

    @Id
    @SequenceGenerator(name="seq_hr_person_knowledge",allocationSize=1,sequenceName="seq_hr_person_knowledge")
    @GeneratedValue(generator="seq_hr_person_knowledge",strategy=GenerationType.SEQUENCE)
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

    @Transient
    public String getEnclosureName() {
        return enclosureName;
    }

    public void setEnclosureName(String enclosureName) {
        this.enclosureName = enclosureName;
    }
}
