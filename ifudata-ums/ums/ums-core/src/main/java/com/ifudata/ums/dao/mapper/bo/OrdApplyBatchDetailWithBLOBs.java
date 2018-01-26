package com.ifudata.ums.dao.mapper.bo;

public class OrdApplyBatchDetailWithBLOBs extends OrdApplyBatchDetail {
    private String excelBody1;

    private String excelBody2;

    private String excelBody3;

    public String getExcelBody1() {
        return excelBody1;
    }

    public void setExcelBody1(String excelBody1) {
        this.excelBody1 = excelBody1 == null ? null : excelBody1.trim();
    }

    public String getExcelBody2() {
        return excelBody2;
    }

    public void setExcelBody2(String excelBody2) {
        this.excelBody2 = excelBody2 == null ? null : excelBody2.trim();
    }

    public String getExcelBody3() {
        return excelBody3;
    }

    public void setExcelBody3(String excelBody3) {
        this.excelBody3 = excelBody3 == null ? null : excelBody3.trim();
    }
}