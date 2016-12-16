package com.youdo.interfaces;

/**
 * 
 * @author shsun
 * 
 * @param <T>
 */
public interface IContainer<T> {

    /**
     * 
     * @param id
     * @return
     */
    public boolean has(T value);

    /**
     * 
     * @return
     */
    public int size();


}
