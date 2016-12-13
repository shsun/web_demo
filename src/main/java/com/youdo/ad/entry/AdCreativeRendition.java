package com.youdo.ad.entry;

import java.util.HashMap;

/**
 * 
 * @author shsun
 * 
 */
public class AdCreativeRendition extends IdNameObject {

	private AdAsset primaryAdAsset;
	private HashMap< Integer, AdAsset > otherAdAssetes = new HashMap< Integer, AdAsset >();

	/**
	 * 
	 * @param id
	 * @param name
	 */
	public AdCreativeRendition(int id, String name) {
		super(id, name);
	}

	public AdAsset getPrimaryAdAsset() {
		return primaryAdAsset;
	}

	public void setPrimaryAdAsset( AdAsset primaryAdAsset ) {
		this.primaryAdAsset = primaryAdAsset;
	}

	public HashMap< Integer, AdAsset > getOtherAdAssetes() {
		return otherAdAssetes;
	}

	public void setOtherAdAssetes( HashMap< Integer, AdAsset > otherAdAssetes ) {
		this.otherAdAssetes = otherAdAssetes;
	}

	/**
	 * 
	 * @param adAsset
	 * @param override
	 */
	public void addAdAsset( AdAsset adAsset, boolean override ) {
		if (override) {
			this.getOtherAdAssetes().put(adAsset.getId(), adAsset);
		} else {
			if (!this.getOtherAdAssetes().containsValue(adAsset)) {
				this.getOtherAdAssetes().put(adAsset.getId(), adAsset);
			}
		}
	}

	/**
	 * 
	 * @param adAsset
	 */
	public AdAsset removeAdAsset( AdAsset adAsset ) {
		AdAsset t = null;
		if (this.containsAdAsset(adAsset)) {
			t = this.getOtherAdAssetes().remove(adAsset);
		}
		return t;
	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	public AdAsset removeAdAssetById( int id ) {
		AdAsset t = null;
		if (this.containsAdAssetId(id)) {
			t = this.removeAdAsset(this.getOtherAdAssetes().get(id));
		}
		return t;
	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	public boolean containsAdAssetId( int id ) {
		return this.getOtherAdAssetes().containsKey(id);
	}

	/**
	 * 
	 * @param adAsset
	 * @return
	 */
	public boolean containsAdAsset( AdAsset adAsset ) {
		return this.getOtherAdAssetes().containsValue(adAsset);
	}
}
