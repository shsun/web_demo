package com.shsun.addata.vo;

import java.math.BigDecimal;
import java.util.Date;

public class DW_ADS_ADI_PROGRAMME_DAY {
    private Date DATE_TIME;

    private Integer DATE_ID;

    private Short SITE_ID;

    private BigDecimal PROGRAMME_ID;

    private Short VIDEO_LENGTH_ID;

    private Short TYPE_ID;

    private Short SLOT_ID;

    private String RESERVED_VAR1;

    private String PROGRAMME_AGENT_ID;

    private Short AD_LENGTH;

    private BigDecimal RADI;

    private Integer PROVINCE_ID;

    private BigDecimal CONTRACT_ID;

    private Short COPYRIGHT_ID;

    public Date getDATE_TIME() {
        return DATE_TIME;
    }

    public void setDATE_TIME(Date DATE_TIME) {
        this.DATE_TIME = DATE_TIME;
    }

    public Integer getDATE_ID() {
        return DATE_ID;
    }

    public void setDATE_ID(Integer DATE_ID) {
        this.DATE_ID = DATE_ID;
    }

    public Short getSITE_ID() {
        return SITE_ID;
    }

    public void setSITE_ID(Short SITE_ID) {
        this.SITE_ID = SITE_ID;
    }

    public BigDecimal getPROGRAMME_ID() {
        return PROGRAMME_ID;
    }

    public void setPROGRAMME_ID(BigDecimal PROGRAMME_ID) {
        this.PROGRAMME_ID = PROGRAMME_ID;
    }

    public Short getVIDEO_LENGTH_ID() {
        return VIDEO_LENGTH_ID;
    }

    public void setVIDEO_LENGTH_ID(Short VIDEO_LENGTH_ID) {
        this.VIDEO_LENGTH_ID = VIDEO_LENGTH_ID;
    }

    public Short getTYPE_ID() {
        return TYPE_ID;
    }

    public void setTYPE_ID(Short TYPE_ID) {
        this.TYPE_ID = TYPE_ID;
    }

    public Short getSLOT_ID() {
        return SLOT_ID;
    }

    public void setSLOT_ID(Short SLOT_ID) {
        this.SLOT_ID = SLOT_ID;
    }

    public String getRESERVED_VAR1() {
        return RESERVED_VAR1;
    }

    public void setRESERVED_VAR1(String RESERVED_VAR1) {
        this.RESERVED_VAR1 = RESERVED_VAR1;
    }

    public String getPROGRAMME_AGENT_ID() {
        return PROGRAMME_AGENT_ID;
    }

    public void setPROGRAMME_AGENT_ID(String PROGRAMME_AGENT_ID) {
        this.PROGRAMME_AGENT_ID = PROGRAMME_AGENT_ID;
    }

    public Short getAD_LENGTH() {
        return AD_LENGTH;
    }

    public void setAD_LENGTH(Short AD_LENGTH) {
        this.AD_LENGTH = AD_LENGTH;
    }

    public BigDecimal getRADI() {
        return RADI;
    }

    public void setRADI(BigDecimal RADI) {
        this.RADI = RADI;
    }

    public Integer getPROVINCE_ID() {
        return PROVINCE_ID;
    }

    public void setPROVINCE_ID(Integer PROVINCE_ID) {
        this.PROVINCE_ID = PROVINCE_ID;
    }

    public BigDecimal getCONTRACT_ID() {
        return CONTRACT_ID;
    }

    public void setCONTRACT_ID(BigDecimal CONTRACT_ID) {
        this.CONTRACT_ID = CONTRACT_ID;
    }

    public Short getCOPYRIGHT_ID() {
        return COPYRIGHT_ID;
    }

    public void setCOPYRIGHT_ID(Short COPYRIGHT_ID) {
        this.COPYRIGHT_ID = COPYRIGHT_ID;
    }
}