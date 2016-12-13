package com.shsun.addata.vo;

import java.util.Date;

public class DIM_ADS_CHANNEL {
    private Integer CHANNEL_AGENT_ID;

    private String CHANNEL_CODE;

    private String CHANNEL_NAME;

    private Short SITE_ID;

    private Short IS_INUSE;

    private String DESCRIPTION;

    private Date START_DATE;

    private Date END_DATE;

    private Integer CHANNEL_NUMBER;

    public Integer getCHANNEL_AGENT_ID() {
        return CHANNEL_AGENT_ID;
    }

    public void setCHANNEL_AGENT_ID(Integer CHANNEL_AGENT_ID) {
        this.CHANNEL_AGENT_ID = CHANNEL_AGENT_ID;
    }

    public String getCHANNEL_CODE() {
        return CHANNEL_CODE;
    }

    public void setCHANNEL_CODE(String CHANNEL_CODE) {
        this.CHANNEL_CODE = CHANNEL_CODE;
    }

    public String getCHANNEL_NAME() {
        return CHANNEL_NAME;
    }

    public void setCHANNEL_NAME(String CHANNEL_NAME) {
        this.CHANNEL_NAME = CHANNEL_NAME;
    }

    public Short getSITE_ID() {
        return SITE_ID;
    }

    public void setSITE_ID(Short SITE_ID) {
        this.SITE_ID = SITE_ID;
    }

    public Short getIS_INUSE() {
        return IS_INUSE;
    }

    public void setIS_INUSE(Short IS_INUSE) {
        this.IS_INUSE = IS_INUSE;
    }

    public String getDESCRIPTION() {
        return DESCRIPTION;
    }

    public void setDESCRIPTION(String DESCRIPTION) {
        this.DESCRIPTION = DESCRIPTION;
    }

    public Date getSTART_DATE() {
        return START_DATE;
    }

    public void setSTART_DATE(Date START_DATE) {
        this.START_DATE = START_DATE;
    }

    public Date getEND_DATE() {
        return END_DATE;
    }

    public void setEND_DATE(Date END_DATE) {
        this.END_DATE = END_DATE;
    }

    public Integer getCHANNEL_NUMBER() {
        return CHANNEL_NUMBER;
    }

    public void setCHANNEL_NUMBER(Integer CHANNEL_NUMBER) {
        this.CHANNEL_NUMBER = CHANNEL_NUMBER;
    }
}