package com.shsun.addata.vo;

import java.math.BigDecimal;

public class DW_ADS_MOBILE_IMP_DAY extends DW_ADS_MOBILE_IMP_DAYKey {
    private Integer DATE_ID;

    private Short PREDEFINED1;

    private Short PREDEFINED2;

    private BigDecimal IMP;

    private BigDecimal CLICK;

    private BigDecimal IMPOVER;

    public Integer getDATE_ID() {
        return DATE_ID;
    }

    public void setDATE_ID(Integer DATE_ID) {
        this.DATE_ID = DATE_ID;
    }

    public Short getPREDEFINED1() {
        return PREDEFINED1;
    }

    public void setPREDEFINED1(Short PREDEFINED1) {
        this.PREDEFINED1 = PREDEFINED1;
    }

    public Short getPREDEFINED2() {
        return PREDEFINED2;
    }

    public void setPREDEFINED2(Short PREDEFINED2) {
        this.PREDEFINED2 = PREDEFINED2;
    }

    public BigDecimal getIMP() {
        return IMP;
    }

    public void setIMP(BigDecimal IMP) {
        this.IMP = IMP;
    }

    public BigDecimal getCLICK() {
        return CLICK;
    }

    public void setCLICK(BigDecimal CLICK) {
        this.CLICK = CLICK;
    }

    public BigDecimal getIMPOVER() {
        return IMPOVER;
    }

    public void setIMPOVER(BigDecimal IMPOVER) {
        this.IMPOVER = IMPOVER;
    }
}