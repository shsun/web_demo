package com.shsun.entity.base;

import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.youdo.m.IJSONObjectParsable;
import com.youdo.mybatis.Page;

/**
 * 
 * @author shsun
 * 
 */
public interface IHttpServletRequestParameter extends IJSONObjectParsable {

    /**
     * 
     * @return
     */
    // public Page<IRowResultSetItem> getPager();

    /**
     * 
     * @param out
     */
    public void exportFile(OutputStream out);

    // -------------------------------------------------------------------------------
    /**
     * 
     * @return
     */
    public HttpServletRequest getHttpServeltRequest();

    /**
     * 
     * @param request
     */
    public void setHttpServeltRequest(HttpServletRequest request);

    /**
     * 
     * @return
     */
    public HttpServletResponse getHttpServletResponse();

    /**
     * 
     * @param response
     */
    public void setHttpServletResponse(HttpServletResponse response);

    // -------------------------------------------------------------------------------

    public String toSQL();

    // -------------------------------------------------------------------------------

    public String getTimecost();

    public void setTimecost(String timecost);

    // -------------------------------------------------------------------------------

    public String getTimestamp();

    public void setTimestamp(String timestamp);
}
