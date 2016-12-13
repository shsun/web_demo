package com.shsun.addata.utils.io;

import com.youdo.m.BaseKVObject;

/**
 * 
 * @author shsun
 * 
 */
public interface IBeforeWritingItemProcessor {

	/**
	 * 
	 * @param object
	 * @throws Throwable
	 */
	public void process( BaseKVObject object );
}
