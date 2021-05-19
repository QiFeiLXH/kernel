package com.bsoft.common.entity.primary;

import javax.persistence.*;

@Entity
@Table(name = "bsoftmis.pub_identity")
@NamedStoredProcedureQuery(name = "PubKeyGeneratorProcedure", procedureName = "pd_ker_public_keygenerator",
        parameters = {
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "tname1", type = String.class),
        @StoredProcedureParameter(mode = ParameterMode.OUT, name = "tvalue1", type = Integer.class) })
public class PubKeyGeneratorDO {
    private Integer id;

    @Id
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
