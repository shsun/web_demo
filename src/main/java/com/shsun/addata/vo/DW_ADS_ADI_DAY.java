package com.shsun.addata.vo;

import java.math.BigDecimal;

public class DW_ADS_ADI_DAY extends DW_ADS_ADI_DAYKey {
    private Integer DATE_ID;

    private Short TYPE_ID;

    private String RESERVED_VAR1;

    private BigDecimal RADI;

    private BigDecimal RESERVED_NUM1;

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

    public BigDecimal getRADI() {
        return RADI;
    }

    public void setRADI(BigDecimal RADI) {
        this.RADI = RADI;
    }

    public BigDecimal getRESERVED_NUM1() {
        return RESERVED_NUM1;
    }

    public void setRESERVED_NUM1(BigDecimal RESERVED_NUM1) {
        this.RESERVED_NUM1 = RESERVED_NUM1;
    }
}