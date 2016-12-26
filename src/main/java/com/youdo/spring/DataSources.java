package com.youdo.spring;

import java.sql.SQLFeatureNotSupportedException;
import java.util.logging.Logger;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * 
 * @author shsun
 * 
 */
public class DataSources extends AbstractRoutingDataSource {

	@Override
	protected Object determineCurrentLookupKey() {
		return DataSourceSwitcher.getDataSourceType();
	}

    public Logger getParentLogger() throws SQLFeatureNotSupportedException {
        // TODO Auto-generated method stub
        return null;
    }
}