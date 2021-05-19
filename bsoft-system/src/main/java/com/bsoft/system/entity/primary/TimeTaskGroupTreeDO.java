package com.bsoft.system.entity.primary;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author zhanglf
 * @Date 2020-07-01 10:14
 * @Version 1.0
 * @Description
 */
@Entity
@Table(name = "PRO_TIMETASK_GROUP")
public class TimeTaskGroupTreeDO {
    private Integer key;
    private String value;
    private String title;
    private Integer parentId;
    private List<TimeTaskGroupTreeDO> children = new ArrayList<>();

    @Id
    @SequenceGenerator(name="SEQ_PRO_TIMETASK_GROUP",allocationSize=1,sequenceName="SEQ_PRO_TIMETASK_GROUP")
    @GeneratedValue(generator="SEQ_PRO_TIMETASK_GROUP",strategy=GenerationType.SEQUENCE)
    public Integer getKey() {
        return key;
    }

    public void setKey(Integer key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    @Transient
    public List<TimeTaskGroupTreeDO> getChildren() {
        return children;
    }

    public void setChildren(List<TimeTaskGroupTreeDO> children) {
        this.children = children;
    }
}
