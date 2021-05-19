package com.bsoft.common.key;

import com.bsoft.common.manager.KeyGeneratorManager;
import com.bsoft.common.value.Table;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class KeyGenerator {
    @Autowired
    private KeyGeneratorManager keyGeneratorManager;
    public Integer increaseAttendance(){
        return increase(Table.ATTENDANCE);
    }

    public Integer increaseWorkLog(){
        return increase(Table.WORKLOG);
    }

    public Integer increaseTrackLog(){
        return increase(Table.TRACKLOG);
    }
    public Integer increaseProjectPlanDetail(){
        return increase(Table.PROJECTPLANDETAIL);
    }
    public Integer increaseFileDetail(){
        return increase(Table.FILEDETAIL);
    }

    public Integer increaseAccountFrozen(){
        return increase(Table.ACCOUNTFROZEN);
    }

    public Integer increaseFamilyInfo(){
        return increase(Table.FAMILYINFO);
    }

    public Integer increaseEducationInfo(){
        return increase(Table.EDUCATIONINFO);
    }

    public Integer increaseWorkInfo(){
        return increase(Table.WORKINFO);
    }

    public Integer increaseRecruitmentInfo(){
        return increase(Table.RECRUITMENTINFO);
    }

    public Integer increasePositionInfo(){
        return increase(Table.POSITIONINFO);
    }

    public Integer increaseResidentInfo(){
        return increase(Table.RESIDENTINFO);
    }

    public Integer increaseSubmission(){
        return increase(Table.SUBMISSION);
    }

    public Integer increaseWordInfo() {
        return increase(Table.WORDINFO);
    }

    public Integer increaseRank(){return increase(Table.RANK);}

    private Integer increase(String table){
        return keyGeneratorManager.nextKey(table);
    }

    public Integer increaseWordOriginalAcceptance(){
        return increase(Table.WORDORIGINALACCEPTANCE);
    }

    public Integer increaseCostRecord(){
        return keyGeneratorManager.pubNextKey(Table.COSTRECORDKEY);
    }

    public Integer increaseInvoiceLib(){
        return keyGeneratorManager.nextKey(Table.INVOICELIB);
    }

    public Integer increaseSalesCommis(){
        return keyGeneratorManager.nextKey(Table.SALESCOMMIS);
    }

    public Integer increaseCompany(){
        return keyGeneratorManager.nextKey(Table.COMPANY);
    }

    public Integer increaseDeptCostType() {
        return keyGeneratorManager.nextKey(Table.DEPTCOSTTYPE);
    }

    public Integer increaseDeptAccountbore(){
        return keyGeneratorManager.nextKey(Table.DEPTACCOUNTBORE);
    }
}
