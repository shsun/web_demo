package com.shsun.addata.vo;

import java.math.BigDecimal;
import java.util.Date;

public class DW_ADS_MOBILE_IMP_DAYKey {
    private Date DATE_TIME;

    private Short SITE_ID;

    private Short MOBILE_SEGMENT_ID;

    private Integer CHANNEL_AGENT_ID;

    private Long SUB_CHANNEL_AGENT_ID;

    private Integer PROVINCE_ID;

    private Integer CITY_ID;

    private Short TYPE_ID;

    private Short SLOT_ID;

    private Short VIDEO_LENGTH_ID;

    private BigDecimal CREATIVE_ID;

    public Date getDATE_TIME() {
        return DATE_TIME;
    }

    public void setDATE_TIME(Date DATE_TIME) {
        this.DATE_TIME = DATE_TIME;
    }

    public Short getSITE_ID() {
        return SITE_ID;
    }

    public void setSITE_ID(Short SITE_ID) {
        this.SITE_ID = SITE_ID;
    }

    public Short getMOBILE_SEGMENT_ID() {
        return MOBILE_SEGMENT_ID;
    }

    public void setMOBILE_SEGMENT_ID(Short MOBILE_SEGMENT_ID) {
        this.MOBILE_SEGMENT_ID = MOBILE_SEGMENT_ID;
    }

    public Integer getCHANNEL_AGENT_ID() {
        return CHANNEL_AGENT_ID;
    }

    public void setCHANNEL_AGENT_ID(Integer CHANNEL_AGENT_ID) {
        this.CHANNEL_AGENT_ID = CHANNEL_AGENT_ID;
    }

    public Long getSUB_CHANNEL_AGENT_ID() {
        return SUB_CHANNEL_AGENT_ID;
    }

    public void setSUB_CHANNEL_AGENT_ID(Long SUB_CHANNEL_AGENT_ID) {
        this.SUB_CHANNEL_AGENT_ID = SUB_CHANNEL_AGENT_ID;
    }

    public Integer getPROVINCE_ID() {
        return PROVINCE_ID;
    }

    public void setPROVINCE_ID(Integer PROVINCE_ID) {
        this.PROVINCE_ID = PROVINCE_ID;
    }

    public Integer getCITY_ID() {
        return CITY_ID;
    }

    public void setCITY_ID(Integer CITY_ID) {
        this.CITY_ID = CITY_ID;
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

    public Short getVIDEO_LENGTH_ID() {
        return VIDEO_LENGTH_ID;
    }

    public void setVIDEO_LENGTH_ID(Short VIDEO_LENGTH_ID) {
        this.VIDEO_LENGTH_ID = VIDEO_LENGTH_ID;
    }

    public BigDecimal getCREATIVE_ID() {
        return CREATIVE_ID;
    }

    public void setCREATIVE_ID(BigDecimal CREATIVE_ID) {
        this.CREATIVE_ID = CREATIVE_ID;
    }
}