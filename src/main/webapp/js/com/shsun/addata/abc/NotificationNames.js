/**
 * @class Defines <code>Notification</code> names for the application.
 */
var NotificationNames = Objs("com.shsun.addata.abc.NotificationNames", {});
//
//
NotificationNames.STARTUP = "STARTUP";
//
//
NotificationNames.PREPARE_VIEW = "PREPARE_VIEW";
//
// action
//
NotificationNames.REQUEST_CHANNEL = "RETRIEVE_CHANNEL";
NotificationNames.REQUEST_GEO = "REQUEST_GEO";
NotificationNames.REQUEST_INVENTORY = "REQUEST_INVENTORY";
NotificationNames.REQUEST_IMPRESSION = "REQUEST_IMPRESSION";
//
NotificationNames.INIT_VIEW = "INIT_VIEW";
NotificationNames.INIT_CATEGORY_VIEW = "INIT_CATEGORY_VIEW";
NotificationNames.INIT_GEO_VIEW = "INIT_GEO_VIEW";
NotificationNames.INIT_DATAGRID_VIEW = "INIT_DATAGRID_VIEW";
// status
//
NotificationNames.CHANNEL_REQUEST_COMPLETED = "CHANNEL_REQUEST_COMPLETED";
NotificationNames.GEO_REQUEST_COMPLETED = "GEO_REQUEST_COMPLETED";
NotificationNames.INVENTORY_REQUEST_COMPLETED = "INVENTORY_REQUEST_COMPLETED";
NotificationNames.IMPRESSION_REQUEST_COMPLETED = "IMPRESSION_REQUEST_COMPLETED";
NotificationNames.CHANNEL_REQUEST_FAILED = "CHANNEL_REQUEST_FAILED";
NotificationNames.GEO_REQUEST_FAILED = "GEO_REQUEST_FAILED";
NotificationNames.INVENTORY_REQUEST_FAILED = "INVENTORY_REQUEST_FAILED";
NotificationNames.IMPRESSION_REQUEST_FAILED = "IMPRESSION_REQUEST_FAILED";
//