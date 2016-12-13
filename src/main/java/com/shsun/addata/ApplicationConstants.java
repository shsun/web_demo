package com.shsun.addata;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author shsun
 * 
 */
public class ApplicationConstants {
	/**
	 * 
	 * @author shsun
	 * 
	 */
	public static class Client extends BaseEnumeration {
		private String label;

		public static final Client WEB = new Client("WEB", "WEB");
		public static final Client APP = new Client("APP", "APP");

		/**
		 * 
		 * @param code
		 * @param label
		 */
		public Client(String code, String label) {
			super(code);
			this.label = label;
			//
			if (getHolder() == null) {
				holder = new HashMap<String, Client>();
			}
			getHolder().put(code, this);
		}

		private static Map<String, Client> holder;

		public static Map<String, Client> getHolder() {
			return holder;
		}

		public String getLabel() {
			return this.label;
		}
	}

	/**
	 * 
	 * @author shsun
	 * 
	 */
	public static class Device extends BaseEnumeration {
		private String label;

		public static final Device PHONE = new Device("PHONE", "PHONE");
		public static final Device PAD = new Device("PAD", "PAD");

		/**
		 * 
		 * @param code
		 * @param label
		 */
		public Device(String code, String label) {
			super(code);
			this.label = label;
			//
			if (getHolder() == null) {
				holder = new HashMap<String, Device>();
			}
			getHolder().put(code, this);
		}

		private static Map<String, Device> holder;

		public static Map<String, Device> getHolder() {
			return holder;
		}

		public String getLabel() {
			return this.label;
		}
	}

	/**
	 * 
	 * @author shsun
	 * 
	 */
	public static class OS extends BaseEnumeration {
		private String label;
		public static final OS IOS = new OS("IOS", "IOS");
		public static final OS ANDROID = new OS("ANDROID", "ANDROID");

		/**
		 * 
		 * @param code
		 * @param label
		 */
		public OS(String code, String label) {
			super(code);
			this.label = label;
			//
			if (getHolder() == null) {
				holder = new HashMap<String, OS>();
			}
			getHolder().put(code, this);
		}

		private static Map<String, OS> holder;

		public static Map<String, OS> getHolder() {
			return holder;
		}

		public String getLabel() {
			return this.label;
		}
	}

	/**
	 * 
	 * @author shsun
	 * 
	 */
	public static class SLOT_TYPE_ID_DESCRIPTOR extends BaseEnumeration {
		private String label;
		/**
		 * 
		 */
		public static final SLOT_TYPE_ID_DESCRIPTOR TYPE_SLOT_DESCRIPTOR = new SLOT_TYPE_ID_DESCRIPTOR("TS", "type_slot");
		/**
		 * 
		 */
		public static final SLOT_TYPE_ID_DESCRIPTOR SLOT_SLOT_DESCRIPTOR = new SLOT_TYPE_ID_DESCRIPTOR("SS", "slot_slot");

		public SLOT_TYPE_ID_DESCRIPTOR(String code, String label) {
			super(code);
			this.label = label;
			//
			if (getHolder() == null) {
				holder = new HashMap<String, SLOT_TYPE_ID_DESCRIPTOR>();
			}
			getHolder().put(code, this);
		}

		private static Map<String, SLOT_TYPE_ID_DESCRIPTOR> holder;

		public static Map<String, SLOT_TYPE_ID_DESCRIPTOR> getHolder() {
			return holder;
		}

		public String getLabel() {
			return this.label;
		}
	}

	/**
	 * 
	 * @author shsun
	 * 
	 */
	public static class Site extends BaseEnumeration {
		private String label;
		/**
		 * a platform
		 */
		public static final Site SiteA = new Site("1", "SiteA");
		/**
		 * b platform
		 */
		public static final Site SiteB = new Site("2", "SiteB");
		/**
		 * (a + b)
		 */
		public static final Site FULL = new Site("-999", "全部");

		/**
		 * 
		 * @param code
		 * @param label
		 */
		public Site(String code, String label) {
			super(code);
			this.label = label;
			//
			if (getHolder() == null) {
				holder = new HashMap<String, Site>();
			}
			getHolder().put(code, this);
		}

		private static Map<String, Site> holder;

		public static Map<String, Site> getHolder() {
			return holder;
		}

		public String getLabel() {
			return this.label;
		}
	}

	/*
	 * public static class AdType extends BaseEnumeration { // ALL public static
	 * final AdType AD_TYPE_ALL = new AdType("-1"); // 短前贴 public static final
	 * AdType AD_TYPE_SHORT_PREROLL = new AdType("1"); // 前贴 public static final
	 * AdType AD_TYPE_V_PREFOLL = new AdType("2"); // 长前贴 public static final
	 * AdType AD_TYPE_LONG_PREROLL = new AdType("3"); // 暂停 public static final
	 * AdType AD_TYPE_V_PAUSE = new AdType("4"); // 后贴 public static final
	 * AdType AD_TYPE_V_POSTROLL = new AdType("5"); // 5秒全屏 public static final
	 * AdType AD_TYPE_V_FULL_SCREEN = new AdType("6"); // 赞助标版 public static
	 * final AdType AD_TYPE_V_SPONSOR_SHIP = new AdType("7"); public static
	 * final AdType AD_TYPE_V_MIDROLL = new AdType("8"); //
	 * ------------------------------------------------------------------ // 角标
	 * public static final AdType AD_TYPE_V_OVERLAY = new AdType("10"); //
	 * Banner public static final AdType AD_TYPE_VHTML = new AdType("11"); //
	 * 页面广告 public static final AdType AD_TYPE_HTML = new AdType("12"); // 贴片
	 * public static final AdType AD_TYPE_V_TEMPORAL = new AdType("13"); public
	 * AdType(String code) { super(code); if (getHolder() == null) { holder =
	 * new HashMap<String, AdType>(); } getHolder().put(code, this); } private
	 * static Map<String, AdType> holder; public static Map<String, AdType>
	 * getHolder() { return holder; } }
	 */

	/**
	 * 
	 * @author shsun
	 * 
	 */
	public static class Type extends BaseEnumeration {
		private String label;
		public static final Type AD_SELECTOR = new Type("3", "AD selector");
		public static final Type CORNER = new Type("10", "角标");
		public static final Type PREROLL = new Type("1", "前贴");
		public static final Type MIDROLL = new Type("8", "中插");
		public static final Type POSTROLL = new Type("5", "后贴");
		public static final Type VIDEO_PLAYER_PAGE_BANNER = new Type("11", "播放页banner");
		public static final Type CRAZY = new Type("2", "Crazy");
		public static final Type FULL_SCREEN = new Type("6", "全屏");
		public static final Type SPONSOR_SHIP = new Type("7", "赞助标版");
		public static final Type PAUSEROLL = new Type("4", "暂停");
		public static final Type OVER_FLOW_1ST_PREROLL_2_SHORT_MAIN_VIDEO = new Type("20", "长一前贴溢出");

		public Type(String code, String label) {
			super(code);
			this.label = label;
			if (getHolder() == null) {
				holder = new HashMap<String, Type>();
			}
			getHolder().put(code, this);
		}

		private static Map<String, Type> holder;

		public static Map<String, Type> getHolder() {
			return holder;
		}

		public String getLabel() {
			return this.label;
		}
	}

	/**
	 * 
	 * @author shsun
	 * 
	 */
	public static class SlotType extends BaseEnumeration {

		private String label;

		public static final SlotType PREROLL_SHORT = new SlotType("1", "短前贴位");
		public static final SlotType PREROLL_LONG_1ST = new SlotType("2", "长一前贴位");
		public static final SlotType PREROLL_LONG_2ND = new SlotType("3", "长二前贴位");
		public static final SlotType PAUSEROLL = new SlotType("4", "暂停位");
		public static final SlotType POSTROLL = new SlotType("5", "后贴位");
		public static final SlotType FULL_SCREEN_5S = new SlotType("6", "5秒全屏位");
		public static final SlotType SPONSOR_SHIP = new SlotType("7", "赞助标版位");
		public static final SlotType MIDROLL = new SlotType("8", "中插位");
		public static final SlotType PREROLL_LONG_3RD = new SlotType("9", "长三前贴位");
		public static final SlotType OVERLAY = new SlotType("10", "角标位");
		public static final SlotType BANNER = new SlotType("11", "播放页banner");

		/**
		 * 
		 * @param code
		 * @param label
		 */
		public SlotType(String code, String label) {
			super(code);
			this.label = label;
			//
			if (getHolder() == null) {
				holder = new HashMap<String, SlotType>();
			}
			getHolder().put(code, this);
		}

		private static Map<String, SlotType> holder;

		public static Map<String, SlotType> getHolder() {
			return holder;
		}

		public String getLabel() {
			return this.label;
		}

		public boolean isLongPreroll() {
			return (this == ApplicationConstants.SlotType.PREROLL_LONG_1ST || this == ApplicationConstants.SlotType.PREROLL_LONG_2ND || this == ApplicationConstants.SlotType.PREROLL_LONG_3RD);
		}
	}

	public static class ReportType extends BaseEnumeration {
		/**
		 * statistical
		 */
		public static final ReportType STATISTICAL = new ReportType("1");
		/**
		 * detail
		 */
		public static final ReportType DETAILS = new ReportType("2");

		public ReportType(String code) {
			super(code);
			//
			if (getHolder() == null) {
				holder = new HashMap<String, ReportType>();
			}
			getHolder().put(code, this);
		}

		private static Map<String, ReportType> holder;

		public static Map<String, ReportType> getHolder() {
			return holder;
		}
	}

	/**
	 * 
	 * @author shsun
	 * 
	 */
	public static class TableLevel extends BaseEnumeration {
		/**
		 * 
		 */
		public static final TableLevel DAY = new TableLevel("DAY");
		/**
		 * detail
		 */
		public static final TableLevel HOUR = new TableLevel("HOUR");

		public TableLevel(String code) {
			super(code);
			//
			if (getHolder() == null) {
				holder = new HashMap<String, TableLevel>();
			}
			getHolder().put(code, this);
		}

		private static Map<String, TableLevel> holder;

		public static Map<String, TableLevel> getHolder() {
			return holder;
		}
	}

	/**
	 * 
	 * @author shsun
	 * 
	 */
	public static class BaseEnumeration {
		private String code;

		public BaseEnumeration(String code) {
			this.code = code;
		}

		public String getCode() {
			return this.code;
		}

	}

}
