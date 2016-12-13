package com.shsun.addata;

import javax.servlet.ServletContextEvent;

import org.springframework.web.context.ContextLoaderListener;

import com.shsun.addata.m.AdStatsService;
import com.youdo.spring.SpringApplicationContextHolder;

/**
 * 
 * @author shsun
 * 
 */
public class ApplicationDataContextListener extends ContextLoaderListener {

    static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(ApplicationDataContextListener.class);

    static final String AD_STATS_SERVICE_BEAN_KEY = "adStatsService";

    @Override
    public void contextDestroyed(ServletContextEvent event) {
        super.contextDestroyed(event);
    }

    @Override
    public void contextInitialized(ServletContextEvent event) {
        super.contextInitialized(event);
        logger.info("contextInitialized");

        //
        AdStatsService service = SpringApplicationContextHolder.getBean(AD_STATS_SERVICE_BEAN_KEY);
        service.reloadChannel();
        service.reloadGEO();
        service.reloadGEO2();
        service.reloadAdSlot();
        service.reloadAdType();
        service.reloadSegment();
        // service.reloadVideoGroup();
    }
}
