package com.shsun.addata.vo;

import java.math.BigDecimal;

public class DW_ADS_IMP_DAY extends DW_ADS_IMP_DAYKey {
    private Integer DATE_ID;

    private Short TYPE_ID;

    private String RESERVED_VAR1;

    private BigDecimal IMP;

    private BigDecimal CLICK;

    private BigDecimal IMPOVER;

    public Integer getDATE_ID() {
        return DATE_ID;
    }

    public void setDATE_ID(Integer DATE_ID) {
        this.DATE_ID = DATE_ID;
    }

    public Short getTYPE_ID() {
        return TYPE_ID;
    }

    public void setTYPE_ID(Short TYPE_ID) {
        this.TYPE_ID = TYPE_ID;
    }

    public String getRESERVED_VAR1() {
        return RESERVED_VAR1;
    }

    public void setRESERVED_VAR1(String RESERVED_VAR1) {
        this.RESERVED_VAR1 = RESERVED_VAR1;
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