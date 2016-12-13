package com.youdo.ad.entry;

/**
 * 
 * @author shsun
 * 
 */
public class Ad extends IdNameObject {

    private AdCreative adCreative;

    public Ad(int id, String name) {
        super(id, name);
    }

    public AdCreative getAdCreative() {
        return adCreative;
    }

    public void setAdCreative(AdCreative adCreative) {
        this.adCreative = adCreative;
    }
}
