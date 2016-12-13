package com.shsun.addata.vo;

import java.math.BigDecimal;
import java.util.Date;

public class DIM_ADS_VIDEOGROUP {
    private BigDecimal VIDEO_GROUP_ID;

    private String VIDEO_GROUP_NAME;

    private Short GROUP_TYPE;

    private Short GROUP_STATUS;

    private Short REGISTER_STATUS;

    private Short SITE_ID;

    private Date START_DATE;

    private Date END_DATE;

    private String DESCRIPTION;

    public BigDecimal getVIDEO_GROUP_ID() {
        return VIDEO_GROUP_ID;
    }

    public void setVIDEO_GROUP_ID(BigDecimal VIDEO_GROUP_ID) {
        this.VIDEO_GROUP_ID = VIDEO_GROUP_ID;
    }

    public String getVIDEO_GROUP_NAME() {
        return VIDEO_GROUP_NAME;
    }

    public void setVIDEO_GROUP_NAME(String VIDEO_GROUP_NAME) {
        this.VIDEO_GROUP_NAME = VIDEO_GROUP_NAME;
    }

    public Short getGROUP_TYPE() {
        return GROUP_TYPE;
    }

    public void setGROUP_TYPE(Short GROUP_TYPE) {
        this.GROUP_TYPE = GROUP_TYPE;
    }

    public Short getGROUP_STATUS() {
        return GROUP_STATUS;
    }

    public void setGROUP_STATUS(Short GROUP_STATUS) {
        this.GROUP_STATUS = GROUP_STATUS;
    }

    public Short getREGISTER_STATUS() {
        return REGISTER_STATUS;
    }

    public void setREGISTER_STATUS(Short REGISTER_STATUS) {
        this.REGISTER_STATUS = REGISTER_STATUS;
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

    public String getDESCRIPTION() {
        return DESCRIPTION;
    }

    public void setDESCRIPTION(String DESCRIPTION) {
        this.DESCRIPTION = DESCRIPTION;
    }
}