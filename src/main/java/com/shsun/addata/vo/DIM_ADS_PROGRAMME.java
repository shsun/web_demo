package com.shsun.addata.vo;

import java.math.BigDecimal;
import java.util.Date;

public class DIM_ADS_PROGRAMME {
    private BigDecimal PROGRAMME_ID;

    private String PROGRAMME_NAME;

    private String CHANNEL_ID;

    private Short SITE_ID;

    private Date START_DATE;

    private Date END_DATE;

    private Short IS_INUSE;

    private String DESCRIPTION;

    private String PROGRAMME_AGENT_ID;

    public BigDecimal getPROGRAMME_ID() {
        return PROGRAMME_ID;
    }

    public void setPROGRAMME_ID(BigDecimal PROGRAMME_ID) {
        this.PROGRAMME_ID = PROGRAMME_ID;
    }

    public String getPROGRAMME_NAME() {
        return PROGRAMME_NAME;
    }

    public void setPROGRAMME_NAME(String PROGRAMME_NAME) {
        this.PROGRAMME_NAME = PROGRAMME_NAME;
    }

    public String getCHANNEL_ID() {
        return CHANNEL_ID;
    }

    public void setCHANNEL_ID(String CHANNEL_ID) {
        this.CHANNEL_ID = CHANNEL_ID;
    }

    public Short getSITE_ID() {
        return SITE_ID;
    }

    public void setSITE_ID(Short SITE_ID) {
        this.SITE_ID = SITE_ID;
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

    public String getPROGRAMME_AGENT_ID() {
        return PROGRAMME_AGENT_ID;
    }

    public void setPROGRAMME_AGENT_ID(String PROGRAMME_AGENT_ID) {
        this.PROGRAMME_AGENT_ID = PROGRAMME_AGENT_ID;
    }
}