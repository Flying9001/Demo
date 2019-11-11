package com.ljq.demo.base;

import java.util.List;
import java.util.Map;

/**
 * @Description: 数据持久层基础类
 * @Author: junqiang.lu
 * @Date: 2019/4/29
 */
public interface BaseDao<T> {

    /**
     * 保存单个对象
     *
     * @param t
     * @return
     */
    long save(T t);

    /**
     * 保存复杂参数对象
     *
     * @param map
     * @return
     */
    long saveComplex(Map<String, Object> map);

    /**
     * 批量保存、插入
     * @param list
     * @return
     */
    <E> long saveBatch(List<E> list);

    /**
     * 更新对象
     *
     * @param t
     * @return
     */
    int update(T t);

    /**
     * 更新复杂对象
     *
     * @param map 复杂参数
     * @return
     */
    int updateComplex(Map<String, Object> map);

    /**
     * 删除单个对象
     *
     * @param t
     * @return
     */
    int delete(T t);

    /**
     * 删除对象(可多个,可单个)
     *
     * @param map 复杂参数
     * @return
     */
    int deleteComplex(Map<String, Object> map);

    /**
     * 批量删除
     *
     * @param list
     * @return
     */
    <E> int deleteBatch(List<E> list);

    /**
     * 查询单个对象
     * @param obj
     * @return
     */
    <E> List<E> queryObject(T obj);

    /**
     * 查询列表
     * @param map 复杂参数
     * @return
     */
    <E> List<E> queryList(Map<String, Object> map);

    /**
     * 查询列表
     * @param obj
     * @return
     */
    <E> List<E> queryList(T obj);

    /**
     * 查询列表
     * @param t
     * @return
     */
    List<Map<String, Object>> queryListAll(T t);

    /**
     * 统计查询个数
     * @param map
     * @return
     */
    int queryCount(Map<String, Object> map);

    /**
     * 统计查询个数
     * @param t
     * @return
     */
    int queryCount(T t);

    /**
     * 统计查询个数
     * @return
     */
    int queryCount();

}
