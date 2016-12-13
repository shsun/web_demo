package com.shsun.addata.vo;

import java.math.BigDecimal;
import java.util.Date;

public class DW_ADS_ADI_VIDEOGP_DAY {
    private Date DATE_TIME;

    private Integer DATE_ID;

    private Short SITE_ID;

    private BigDecimal VIDEO_GROUP_ID;

    private Integer PROVINCE_ID;

    private Short VIDEO_LENGTH_ID;

    private Short SLOT_ID;

    private BigDecimal RADI;

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

    public BigDecimal getVIDEO_GROUP_ID() {
        return VIDEO_GROUP_ID;
    }

    public void setVIDEO_GROUP_ID(BigDecimal VIDEO_GROUP_ID) {
        this.VIDEO_GROUP_ID = VIDEO_GROUP_ID;
    }

    public Integer getPROVINCE_ID() {
        return PROVINCE_ID;
    }

    public void setPROVINCE_ID(Integer PROVINCE_ID) {
        this.PROVINCE_ID = PROVINCE_ID;
    }

    public Short getVIDEO_LENGTH_ID() {
        return VIDEO_LENGTH_ID;
    }

    public void setVIDEO_LENGTH_ID(Short VIDEO_LENGTH_ID) {
        this.VIDEO_LENGTH_ID = VIDEO_LENGTH_ID;
    }

    public Short getSLOT_ID() {
        return SLOT_ID;
    }

    public void setSLOT_ID(Short SLOT_ID) {
        this.SLOT_ID = SLOT_ID;
    }

    public BigDecimal getRADI() {
        return RADI;
    }

    public void setRADI(BigDecimal RADI) {
        this.RADI = RADI;
    }
}