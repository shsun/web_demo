package com.shsun.addata.vo.base;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.shsun.addata.ApplicationConstants.Site;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * 
 * @author shsun
 * 
 */
public class SecondLevelParameter {

	private Map<String, MapVO> collection;
	
	private List<String> standaloneIds = new ArrayList<String>();
	private List<String> allIds = new ArrayList<String>();
	
	/**
	 * 
	 * @param jsonString
	 */
	public SecondLevelParameter(String jsonString) {
		this.collection = new HashMap<String, SecondLevelParameter.MapVO>();
		//
		JSONArray dataArray = JSONObject.fromObject(jsonString).getJSONArray("data");
		for (int i = 0; i < dataArray.size(); i++) {
			MapVO vo = new MapVO(dataArray.getJSONObject(i));
			this.collection.put(vo.getId(), vo);
			this.allIds.add(vo.getId());
			if (!vo.hasChildren()) {
				this.standaloneIds.add(vo.getId());
			}
		}
	}
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	public boolean hasChildren(String id) {
		return this.collection.get(id).hasChildren();
	}
	
	/**
	 * 
	 * @return
	 */
	public List<String> getAllLeafs() {		
		List<String> children = new ArrayList<String>();
		Set<Map.Entry<String, SecondLevelParameter.MapVO>> set = this.collection.entrySet();
		for (Iterator<Map.Entry<String, SecondLevelParameter.MapVO>> it = set.iterator(); it.hasNext();) {
			Map.Entry<String, SecondLevelParameter.MapVO> entry = (Map.Entry<String, SecondLevelParameter.MapVO>) it.next();
			children.addAll(entry.getValue().getChildren());
		}
		return children;
	}
	
	public boolean has2ndLevelParameter() {
		return this.getAllLeafs().size() > 0;
	}

	public boolean has1stLevelParameter() {
		return this.size() > 0;
	}
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	public List<String> getChildren(String id) {
		return this.collection.get(id).getChildren();
	}

	public Map<String, MapVO> getCollection() {
		return collection;
	}
	
	public int size() {
		return this.getCollection().size();
	}
	
	public List<String> getStandaloneIds() {
		return standaloneIds;
	}
	// ------------------------------------------------------------------------------------------------------------------------------------
	/**
	 * 
	 * @author shsun
	 * 
	 */
	public static class MapVO {
		private String id;
		private List<String> children = new ArrayList<String>();
		
		private Site platform;
		
		// {id:'21',name'辽宁'},cs:[{id:'210300',name:'鞍山市'},{id:'210200',name:'大连市'},{id:'210100',name:'沈阳市'}]},
		public MapVO(JSONObject jsonObject) {
			this.id = jsonObject.getString("id");
			JSONArray c = jsonObject.getJSONArray("cs");
			if (c != null) {
				for (int i = 0; i < c.size(); i++) {
					this.children.add(c.getJSONObject(i).getString("id"));
				}
			}
			//
			this.platform = Site.getHolder().get(jsonObject.get("p"));
		}

		public boolean hasChildren() {
			return this.children.size() > 0;
		}

		public String getId() {
			return id;
		}

		public List<String> getChildren() {
			return children;
		}

		public Site getPlatform() {
			return platform;
		}
	}
	public List<String> getAllIds() {
		return allIds;
	}
}
/*
 * 
 * 
 * [{id:
 * '21',name'辽宁'},cs:[{id:'210300',name:'鞍山市'},{id:'210200',name:'大连市'},{id:'210100',name:'沈阳市'}]},{id:"13",name:"河北",cs:[{id:'131000',name:'廊坊市'},{id:'131100',name:'衡水市'}]}]
 */
