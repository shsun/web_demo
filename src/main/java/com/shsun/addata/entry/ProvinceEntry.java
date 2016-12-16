package com.shsun.addata.entry;

import java.util.ArrayList;
import java.util.List;

import com.shsun.addata.entry.raw.Province;
import com.youdo.interfaces.IContainer;

/**
 * 
 * @author shsun
 *
 */
public class ProvinceEntry extends Province implements IContainer<CityEntry> {

    private List<CityEntry> mList;

    public ProvinceEntry(List<CityEntry> list) {
        this.mList = list == null ? new ArrayList<CityEntry>() : list;
    }

    public CityEntry getCityEntryById(String id) {
        CityEntry value = null;
        for (int i = 0; i < this.mList.size(); i++) {
            if (this.mList.get(i).getCityid().equals(id)) {
                value = this.mList.get(i);
                break;
            }
        }
        return value;
    }

    public CityEntry getCityEntryByName(String name) {
        CityEntry value = null;
        for (int i = 0; i < this.mList.size(); i++) {
            if (this.mList.get(i).getCity().equals(name)) {
                value = this.mList.get(i);
                break;
            }
        }
        return value;
    }

    public boolean has(CityEntry value) {
        return this.mList.contains(value);
    }

    public int size() {
        return this.mList.size();
    }
}
