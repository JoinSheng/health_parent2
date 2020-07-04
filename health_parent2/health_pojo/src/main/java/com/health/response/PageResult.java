package com.health.response;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * 分页结果封装对象
 */
@Data//lombok插件注解
@NoArgsConstructor//lombok插件注解
public class PageResult<T> implements Serializable {
    private Long total;//总记录数
    private List<T> rows;//当前页结果

    public PageResult() {
        super();
        this.total = total;
        this.rows = rows;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }
}
