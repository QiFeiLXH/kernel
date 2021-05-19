package com.bsoft.person.entity.primary;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "hr_person_expert")
public class ExpertDO {
    @NotNull(message = "专家不能为空")
    private String expertId;
    @NotNull(message = "专家不能为空")
    private String expertName;
    @NotNull(message = "专家类型不能为空")
    private Integer type;
    private Integer id;

    @Id
    @SequenceGenerator(name="seq_hr_person_expert",allocationSize=1,sequenceName="seq_hr_person_expert")
    @GeneratedValue(generator="seq_hr_person_expert",strategy=GenerationType.SEQUENCE)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getExpertId() {
        return expertId;
    }

    public void setExpertId(String expertId) {
        this.expertId = expertId;
    }

    public String getExpertName() {
        return expertName;
    }

    public void setExpertName(String expertName) {
        this.expertName = expertName;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
