package com.shsun.addata.support.vo.videogroup;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.oro.text.regex.PatternCompiler;

import com.shsun.addata.m.AdStatsService;
import com.shsun.addata.vo.DIM_ADS_VIDEOGROUP;
import com.shsun.addata.vo.base.ApplicationSharedObject;

/**
 * 
 * @author shsun
 * 
 */
public class VideoGroupCollector {

	static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(VideoGroupCollector.class);
	
	
	private Map<BigDecimal, DIM_ADS_VIDEOGROUP> collection = new HashMap<BigDecimal, DIM_ADS_VIDEOGROUP>();

	/**
	 * 
	 * @param list
	 */
	public VideoGroupCollector(List<DIM_ADS_VIDEOGROUP> list) {
		if (list != null) {
			for (int i = 0; i < list.size(); i++) {
				collection.put(list.get(i).getVIDEO_GROUP_ID(), list.get(i));
			}
		}
	}

	/**
	 * 
	 * @param videoGroupId
	 * @return
	 */
	public DIM_ADS_VIDEOGROUP getByVGId(BigDecimal videoGroupId) {
		return this.collection.get(videoGroupId);
	}
	
	/**
	 * 
	 * @param videoGroupName
	 * @return List of video group ids
	 */
	public List<BigDecimal> getIdsByVGName(String videoGroupName) {
		List<BigDecimal> ids = new ArrayList<BigDecimal>();
		Pattern p = Pattern.compile(videoGroupName);
		Collection<DIM_ADS_VIDEOGROUP> vgs = collection.values();
		Iterator<DIM_ADS_VIDEOGROUP> it = vgs.iterator();
		while(it.hasNext()) {
			Matcher matcher = p.matcher((it.next()).getVIDEO_GROUP_NAME());
			if (matcher.find()) {
				ids.add((it.next()).getVIDEO_GROUP_ID());
			}
		}
		return ids;
	}
}
