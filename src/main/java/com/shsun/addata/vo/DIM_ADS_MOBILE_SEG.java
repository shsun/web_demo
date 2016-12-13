package com.shsun.addata.vo;

import java.util.Date;

public class DIM_ADS_MOBILE_SEG {
    private Short MOBILE_SEGMENT_ID;

    private String DEVICE_TYPE;

    private String OS_TYPE;

    private String CLIENT_TYPE;

    private String PLATFORM_TYPE;

    private Date START_DATE;

    private Date END_DATE;

    private Short IS_INUSE;

    private String DESCRIPTION;

    public Short getMOBILE_SEGMENT_ID() {
        return MOBILE_SEGMENT_ID;
    }

    public void setMOBILE_SEGMENT_ID(Short MOBILE_SEGMENT_ID) {
        this.MOBILE_SEGMENT_ID = MOBILE_SEGMENT_ID;
    }

    public String getDEVICE_TYPE() {
        return DEVICE_TYPE;
    }

    public void setDEVICE_TYPE(String DEVICE_TYPE) {
        this.DEVICE_TYPE = DEVICE_TYPE;
    }

    public String getOS_TYPE() {
        return OS_TYPE;
    }

    public void setOS_TYPE(String OS_TYPE) {
        this.OS_TYPE = OS_TYPE;
    }

    public String getCLIENT_TYPE() {
        return CLIENT_TYPE;
    }

    public void setCLIENT_TYPE(String CLIENT_TYPE) {
        this.CLIENT_TYPE = CLIENT_TYPE;
    }

    public String getPLATFORM_TYPE() {
        return PLATFORM_TYPE;
    }

    public void setPLATFORM_TYPE(String PLATFORM_TYPE) {
        this.PLATFORM_TYPE = PLATFORM_TYPE;
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
}