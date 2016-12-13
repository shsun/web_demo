package com.shsun.addata.vo;

import java.math.BigDecimal;

public class DW_ADS_MOBILE_ADI_DAY extends DW_ADS_MOBILE_ADI_DAYKey {
    private Integer DATE_ID;

    private Short PREDEFINED1;

    private Short PREDEFINED2;

    private BigDecimal RADI;

    private Short TYPE_ID;

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

    public BigDecimal getRADI() {
        return RADI;
    }

    public void setRADI(BigDecimal RADI) {
        this.RADI = RADI;
    }

    public Short getTYPE_ID() {
        return TYPE_ID;
    }

    public void setTYPE_ID(Short TYPE_ID) {
        this.TYPE_ID = TYPE_ID;
    }
}