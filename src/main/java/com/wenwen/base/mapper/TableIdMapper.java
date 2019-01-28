package com.wenwen.base.mapper;

import org.apache.ibatis.annotations.Param;

/**
 * @author xiaoxinga
 * @date 2019/01/10 13:52
 * @since
 */
public interface TableIdMapper {
    String getMaxTableId(@Param("tableName") String tableName, @Param("columnName") String columnName);

    int updateMaxId(@Param("tableId") String tableId, @Param("tableName") String tableName, @Param("columnName") String columnName);

    void insertMaxId(@Param("tableId") String tableId, @Param("tableName") String tableName, @Param("columnName") String columnName);
}
