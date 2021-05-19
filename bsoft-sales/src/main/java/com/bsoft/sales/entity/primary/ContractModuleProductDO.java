package com.bsoft.sales.entity.primary;

import javax.persistence.*;
import java.util.Date;

/**
 * @Author Xuhui Lin
 * @Date 2021/3/3 12:46
 * @Description
 */
@Entity
@Table(name="bsoftmis.con_contract_module_product")
public class ContractModuleProductDO {
    private Integer id;
    private Integer productId;
    private Integer moduleId;
    private String register;
    private Date registerDate;
    private Double amount;

    @Id
    @SequenceGenerator(name="BSOFTMIS.SEQ_CONTRACT_MODULE_PRODUCT",allocationSize=1,sequenceName="BSOFTMIS.SEQ_CONTRACT_MODULE_PRODUCT")
    @GeneratedValue(generator="BSOFTMIS.SEQ_CONTRACT_MODULE_PRODUCT",strategy=GenerationType.SEQUENCE)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getModuleId() {
        return moduleId;
    }

    public void setModuleId(Integer moduleId) {
        this.moduleId = moduleId;
    }

    public String getRegister() {
        return register;
    }

    public void setRegister(String register) {
        this.register = register;
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}
