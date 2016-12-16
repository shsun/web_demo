package com.shsun.addata.entry;

import java.util.ArrayList;
import java.util.List;

import com.youdo.interfaces.IContainer;

/**
 * 
 * @author shsun
 *
 */
public class PRC implements IContainer<ProvinceEntry> {
    private List<ProvinceEntry> mList;

    public PRC(List<ProvinceEntry> list) {
        this.mList = list == null ? new ArrayList<ProvinceEntry>() : list;
    }

    public ProvinceEntry getProvinceById(String id) {
        ProvinceEntry value = null;
        for (int i = 0; i < this.mList.size(); i++) {
            if (this.mList.get(i).getProvinceid().equals(id)) {
                value = this.mList.get(i);
                break;
            }
        }
        return value;
    }

    public ProvinceEntry getProvinceByName(String name) {
        ProvinceEntry value = null;
        for (int i = 0; i < this.mList.size(); i++) {
            if (this.mList.get(i).getProvince().equals(name)) {
                value = this.mList.get(i);
                break;
            }
        }
        return value;
    }

    public boolean has(ProvinceEntry value) {
        return this.mList.contains(value);
    }

    public int size() {
        return this.mList.size();
    }
}
