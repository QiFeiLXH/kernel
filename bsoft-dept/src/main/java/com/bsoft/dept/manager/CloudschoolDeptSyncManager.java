package com.bsoft.dept.manager;

public interface CloudschoolDeptSyncManager {

    /**新增，修改
     * 与云学堂同步部门信息：
     * 部门要先按照层级结构排序排好后单个同步，正常只需要，id，部门名，parentId，部门同步按照先同步父部门在同步子部门
     */
    void SyncSaveDept();


    /**删除
     * 与云学堂同步部门信息：
     * 部门要先按照层级结构排序排好后单个同步，正常只需要，id，部门名，parentId，部门同步按照先同步父部门在同步子部门
     */
    void SyncDeleteDept();

    /**第一次同步云学堂部门信息
     * 与云学堂同步部门信息：
     * 部门要先按照层级结构排序排好后单个同步，正常只需要，id，部门名，parentId，部门同步按照先同步父部门在同步子部门
     * 将备份表中所有数据传送至云学堂中
     */
    void SyncOneDept();
}
