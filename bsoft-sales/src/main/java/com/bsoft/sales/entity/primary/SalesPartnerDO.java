package com.bsoft.sales.entity.primary;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import java.util.Date;

/**
 * @BelongsProject: bsoft-kernel
 * @BelongsPackage: com.bsoft.sales.entity
 * @Author: Xuhui Lin
 * @CreateTime: 2020-06-29 20:14
 * @Description: 合作协议-合作单位
 */
@Entity
@Table(name="ker_sales_partner")
public class SalesPartnerDO {
    private Integer id;
    /** 合作单位名称 */
    private String partnerName;
    /** 合作单位拼音简码 */
    private String nameCode;
    /** 地址 */
    private String address;
    /** 联系电话 */
    @Length(max = 16,message = "联系电话长度不超过16")
    private String phone;
    /** 登记日期 */
    private Date registerDate;
    /** 省 */
    private String province;
    /** 市 */
    private String city;
    /** 县 */
    private String county;
    /** 联系人 */
    @Length(max = 16,message = "联系人长度不超过16")
    private String contactPerson;

    @Id
    @SequenceGenerator(name="SEQ_KER_SALES_PARTNER",allocationSize=1,sequenceName="SEQ_KER_SALES_PARTNER")
    @GeneratedValue(generator="SEQ_KER_SALES_PARTNER",strategy=GenerationType.SEQUENCE)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPartnerName() {
        return partnerName;
    }

    public void setPartnerName(String partnerName) {
        this.partnerName = partnerName;
    }

    public String getNameCode() {
        return nameCode;
    }

    public void setNameCode(String nameCode) {
        this.nameCode = nameCode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }
}
