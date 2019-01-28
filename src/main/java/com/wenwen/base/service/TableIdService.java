package com.wenwen.base.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wenwen.base.mapper.TableIdMapper;

import lombok.extern.slf4j.Slf4j;

/**
 * @author xiaoxinga
 * @date 2018/9/10 14:59
 * @since
 */
@Slf4j
@Service
public class TableIdService {

    final static DateTimeFormatter pattern = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    
    @Autowired
    private TableIdMapper tableIdMapper;

    /**
     *
     * @param tableName  表名
     * @param columnName 列名
     * @param prefix     前缀
     * @return
     */
    @Transactional
    public String getTableId(String tableName, String columnName, String prefix) {
        if (prefix.length() != 2) {
            log.info("前缀不等于两位数");
            return null;
        }
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println("localDateTime：" + localDateTime);
        String date = localDateTime.format(pattern);
        date = date.replace("-", "");
        String tableIdStart = prefix.toUpperCase();
        String maxTableId = tableIdMapper.getMaxTableId(tableName, columnName);
        int no = 0;
        if (!StringUtils.isBlank(maxTableId) && maxTableId.substring(0,2).equals(tableIdStart)) {
            if(date.equals(maxTableId.substring(2,10))){
                no = Integer.parseInt(maxTableId.substring(maxTableId.length() - 5, maxTableId.length()));
            }
        }
        String tableIdEnd = String.format("%0" + 5 + "d", no + 1);
        String tableId = tableIdStart + date + tableIdEnd;
        if (StringUtils.isNotBlank(maxTableId)) {
            tableIdMapper.updateMaxId(tableId, tableName, columnName);
        } else {
            tableIdMapper.insertMaxId(tableId, tableName, columnName);
        }
        return tableId;
    }
}
