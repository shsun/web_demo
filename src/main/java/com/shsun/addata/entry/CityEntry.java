package com.shsun.addata.entry;

import java.util.ArrayList;
import java.util.List;

import com.shsun.addata.entry.raw.City;
import com.youdo.interfaces.IContainer;


/**
 * 
 * @author shsun
 *
 */
public class CityEntry extends City implements IContainer<AreaEntry> {

    private List<AreaEntry> mList;

    public CityEntry(List<AreaEntry> list) {
        this.mList = list == null ? new ArrayList<AreaEntry>() : list;
    }

    public AreaEntry getAreaEntryById(String id) {
        AreaEntry value = null;
        for (int i = 0; i < this.mList.size(); i++) {
            if (this.mList.get(i).getAreaid().equals(id)) {
                value = this.mList.get(i);
                break;
            }
        }
        return value;
    }

    public AreaEntry getAreaEntryByName(String name) {
        AreaEntry value = null;
        for (int i = 0; i < this.mList.size(); i++) {
            if (this.mList.get(i).getArea().equals(name)) {
                value = this.mList.get(i);
                break;
            }
        }
        return value;
    }

    public boolean has(AreaEntry value) {
        return this.mList.contains(value);
    }

    public int size() {
        return this.mList.size();
    }
}
