package com.bsoft.common.entity.primary;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "bsoftmis.gy_identity")
@NamedStoredProcedureQuery(name = "KeyGeneratorProcedure", procedureName = "pd_ker_pub_keygenerator",
        parameters = {
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "tname1", type = String.class),
        @StoredProcedureParameter(mode = ParameterMode.OUT, name = "tvalue1", type = Integer.class) })
public class KeyGeneratorDO {
    private Integer id;

    @Id
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
