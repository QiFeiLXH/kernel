package com.bsoft.dept.dto;


public class CloudschoolDeptSyncDTO {

    /**
     * 部门ID
     */
    private String id;

    /**
     * 部门名称
     */
    private String ouName;

    /**
     * 父节点ID
     */
    private String parentId;


    /**
     * 排序索引
     */
    private int orderIndex;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOuName() {
        return ouName;
    }

    public void setOuName(String ouName) {
        this.ouName = ouName;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public int getOrderIndex() {
        return orderIndex;
    }

    public void setOrderIndex(int orderIndex) {
        this.orderIndex = orderIndex;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.toLowerCase().hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        CloudschoolDeptSyncDTO other = (CloudschoolDeptSyncDTO) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equalsIgnoreCase(other.id))
            return false;
        return true;
    }

}
