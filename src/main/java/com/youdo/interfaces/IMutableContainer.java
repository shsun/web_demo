package com.youdo.interfaces;

/**
 * 
 * @author shsun
 * 
 * @param <T>
 */
public interface IMutableContainer<T> extends IContainer<T> {
    /**
     * 
     * @param id
     * @param value
     */
    public void add(T value);

    /**
     * 
     * @param id
     */
    public void remove(T value);

    /**
     * make it empty
     */
    public void empty();
}
