package com.shsun.addata.vo.base;

/**
 * 
 * @author shsun
 * 
 */
public abstract class AbstractTableSelectionStrategy implements ITableSelectionStrategy {

    /**
     * 
     */
    protected IHttpServletRequestParameter httpServletRequestParameter;
    /**
     * 
     */
    protected ISqlParameterSource sqlParameterSource;

    /**
     * 
     * @param httpServletRequestParameter
     * @param sqlParameterSource
     */
    public AbstractTableSelectionStrategy(IHttpServletRequestParameter httpServletRequestParameter, ISqlParameterSource sqlParameterSource) {
        this.httpServletRequestParameter = httpServletRequestParameter;
        this.sqlParameterSource = sqlParameterSource;
    }

    // ----------------------------------------------------------------------------------------------------------------------------------
    /**
     * select the most suitable table for querying.
     */
    public void select() {
        this.doSelect();
    }

    protected abstract void doSelect();
}
