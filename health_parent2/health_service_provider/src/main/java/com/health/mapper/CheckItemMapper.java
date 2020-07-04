package com.health.mapper;

import com.health.pojo.CheckItem;
import com.health.response.Result;
import com.health.resquest.CheckItemDto;

import java.util.List;

/**
 * @Author: JoinCao
 * @CreateDate: 2020-04-16
 */
public interface CheckItemMapper {
    /**
     * @Author: JoinCao
     * @CreateDate: 2020-04-16
     * @Description: 查询所有
     */
    public List<CheckItem> findAll();

    /**
     * @Author: JoinCao
     * @CreateDate: 2020-04-16
     * @Description: 根据条件查询加分页
     */
    public List<CheckItem> search(CheckItem checkItem);

    /**
     * @Author: JoinCao
     * @CreateDate: 2020-04-16
     * @Description: 根据Id查询
     */
    public CheckItem findOne(Integer id);

    /**
     * @Author: JoinCao
     * @CreateDate: 2020-04-16
     * @Description: 根据id修改
     */
    public void edit(CheckItem checkItem);

    /**
     * @Author: JoinCao
     * @CreateDate: 2020-04-16
     * @Description: 新增
     */
    public void add(CheckItem checkItem);

    /**
     * @Author: JoinCao
     * @CreateDate: 2020-04-16
     * @Description: 根据id删除
     */
    public void delete(Integer id);
}
