package com.shsun.addata.vo;

import java.util.Date;

public class DIM_ADS_SLOT {
    private Short SLOT_ID;

    private String SLOT_NAME;

    private Short SLOT_GROUP1_ID;

    private String SLOT_GROUP1_NAME;

    private Short SLOT_GROUP2_ID;

    private String SLOT_GROUP2_NAME;

    private Short SITE_ID;

    private Date START_DATE;

    private Date END_DATE;

    private Short IS_INUSE;

    private String DESCRIPTION;

    private Short TYPE_ID;

    private String TYPE_NAME;

    private Short IS_PC;

    private Short IS_MOBILE;

    public Short getSLOT_ID() {
        return SLOT_ID;
    }

    public void setSLOT_ID(Short SLOT_ID) {
        this.SLOT_ID = SLOT_ID;
    }

    public String getSLOT_NAME() {
        return SLOT_NAME;
    }

    public void setSLOT_NAME(String SLOT_NAME) {
        this.SLOT_NAME = SLOT_NAME;
    }

    public Short getSLOT_GROUP1_ID() {
        return SLOT_GROUP1_ID;
    }

    public void setSLOT_GROUP1_ID(Short SLOT_GROUP1_ID) {
        this.SLOT_GROUP1_ID = SLOT_GROUP1_ID;
    }

    public String getSLOT_GROUP1_NAME() {
        return SLOT_GROUP1_NAME;
    }

    public void setSLOT_GROUP1_NAME(String SLOT_GROUP1_NAME) {
        this.SLOT_GROUP1_NAME = SLOT_GROUP1_NAME;
    }

    public Short getSLOT_GROUP2_ID() {
        return SLOT_GROUP2_ID;
    }

    public void setSLOT_GROUP2_ID(Short SLOT_GROUP2_ID) {
        this.SLOT_GROUP2_ID = SLOT_GROUP2_ID;
    }

    public String getSLOT_GROUP2_NAME() {
        return SLOT_GROUP2_NAME;
    }

    public void setSLOT_GROUP2_NAME(String SLOT_GROUP2_NAME) {
        this.SLOT_GROUP2_NAME = SLOT_GROUP2_NAME;
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

    public Short getTYPE_ID() {
        return TYPE_ID;
    }

    public void setTYPE_ID(Short TYPE_ID) {
        this.TYPE_ID = TYPE_ID;
    }

    public String getTYPE_NAME() {
        return TYPE_NAME;
    }

    public void setTYPE_NAME(String TYPE_NAME) {
        this.TYPE_NAME = TYPE_NAME;
    }

    public Short getIS_PC() {
        return IS_PC;
    }

    public void setIS_PC(Short IS_PC) {
        this.IS_PC = IS_PC;
    }

    public Short getIS_MOBILE() {
        return IS_MOBILE;
    }

    public void setIS_MOBILE(Short IS_MOBILE) {
        this.IS_MOBILE = IS_MOBILE;
    }
}