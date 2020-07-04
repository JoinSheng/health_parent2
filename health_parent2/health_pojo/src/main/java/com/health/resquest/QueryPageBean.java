package com.health.resquest;

import lombok.Data;

import java.io.Serializable;

/**
 * 封装查询条件
 */
@Data
public class QueryPageBean implements Serializable {
    private Integer currentPage;//页码
    private Integer pageSize;//每页记录数

}