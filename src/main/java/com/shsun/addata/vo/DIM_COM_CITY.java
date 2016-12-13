package com.shsun.addata.vo;

import java.util.Date;

public class DIM_COM_CITY {
    private Integer CITY_ID;

    private String CITY_NAME;

    private Integer PROVINCE_ID;

    private String PROVINCE_NAME;

    private Short REGION_ID;

    private String REGION_NAME;

    private Integer COUNTRY_ID;

    private String COUNTRY_NAME;

    private Short TOTAL_ID;

    private String TOTAL_NAME;

    private Date START_DATE;

    private Date END_DATE;

    private Short IS_INUSE;

    private String DESCRIPTION;

    public Integer getCITY_ID() {
        return CITY_ID;
    }

    public void setCITY_ID(Integer CITY_ID) {
        this.CITY_ID = CITY_ID;
    }

    public String getCITY_NAME() {
        return CITY_NAME;
    }

    public void setCITY_NAME(String CITY_NAME) {
        this.CITY_NAME = CITY_NAME;
    }

    public Integer getPROVINCE_ID() {
        return PROVINCE_ID;
    }

    public void setPROVINCE_ID(Integer PROVINCE_ID) {
        this.PROVINCE_ID = PROVINCE_ID;
    }

    public String getPROVINCE_NAME() {
        return PROVINCE_NAME;
    }

    public void setPROVINCE_NAME(String PROVINCE_NAME) {
        this.PROVINCE_NAME = PROVINCE_NAME;
    }

    public Short getREGION_ID() {
        return REGION_ID;
    }

    public void setREGION_ID(Short REGION_ID) {
        this.REGION_ID = REGION_ID;
    }

    public String getREGION_NAME() {
        return REGION_NAME;
    }

    public void setREGION_NAME(String REGION_NAME) {
        this.REGION_NAME = REGION_NAME;
    }

    public Integer getCOUNTRY_ID() {
        return COUNTRY_ID;
    }

    public void setCOUNTRY_ID(Integer COUNTRY_ID) {
        this.COUNTRY_ID = COUNTRY_ID;
    }

    public String getCOUNTRY_NAME() {
        return COUNTRY_NAME;
    }

    public void setCOUNTRY_NAME(String COUNTRY_NAME) {
        this.COUNTRY_NAME = COUNTRY_NAME;
    }

    public Short getTOTAL_ID() {
        return TOTAL_ID;
    }

    public void setTOTAL_ID(Short TOTAL_ID) {
        this.TOTAL_ID = TOTAL_ID;
    }

    public String getTOTAL_NAME() {
        return TOTAL_NAME;
    }

    public void setTOTAL_NAME(String TOTAL_NAME) {
        this.TOTAL_NAME = TOTAL_NAME;
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