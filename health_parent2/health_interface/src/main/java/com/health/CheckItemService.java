package com.health;

import com.health.pojo.CheckItem;
import com.health.response.Result;
import com.health.resquest.CheckItemDto;

import java.util.List;

/**
 * @Description: 检查项管理接口
 * @Author: JoinCao
 * @CreateDate: 2020-04-16
 * @UpdateUser: JoinCao
 * @UpdateDate: 2020-04-16
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public interface CheckItemService {
    /**
     * @Author: JoinCao
     * @CreateDate: 2020-04-16
     * @Description: 查询所有
     */
    public Result<List<CheckItem>> findAll();

    /**
     * @Author: JoinCao
     * @CreateDate: 2020-04-16
     * @Description: 根据条件查询加分页
     */
    public Result search(CheckItemDto checkItemDto, Integer currentPage, Integer pageSize);

    /**
     * @Author: JoinCao
     * @CreateDate: 2020-04-16
     * @Description: 根据Id查询
     */
    public Result<CheckItem> findOne(Integer id);

    /**
     * @Author: JoinCao
     * @CreateDate: 2020-04-16
     * @Description: 根据id修改
     */
    public Result<CheckItem> edit(Integer id, CheckItem checkItem);

    /**
     * @Author: JoinCao
     * @CreateDate: 2020-04-16
     * @Description: 新增
     */
    public Result<CheckItem> add(CheckItem checkItem);

    /**
     * @Author: JoinCao
     * @CreateDate: 2020-04-16
     * @Description: 根据id删除
     */
    public Result delete(Integer id);
}
