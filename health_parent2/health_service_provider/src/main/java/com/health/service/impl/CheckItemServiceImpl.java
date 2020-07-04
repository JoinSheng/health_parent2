package com.health.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.health.CheckItemService;
import com.health.mapper.CheckItemMapper;
import com.health.pojo.CheckItem;
import com.health.response.PageResult;
import com.health.response.Result;
import com.health.response.constant.MessageConstant;
import com.health.resquest.CheckItemDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @Author: JoinCao
 * @CreateDate: 2020-04-16
 */
@Service(interfaceClass = CheckItemService.class)
/*
service业务层就干三件事:
            1.参数校验
            2.业务代码流程
            3.封装执行结果
*/
public class CheckItemServiceImpl implements CheckItemService {
    @Autowired
    CheckItemMapper checkItemMapper;

    /**
     * @Author: JoinCao
     * @CreateDate: 2020-04-16
     * @Description: 查询所有
     */
    @Override
    public Result<List<CheckItem>> findAll() {
        List<CheckItem> checkItemList = checkItemMapper.findAll();
        if (checkItemList.size() == 0 || checkItemList == null) {
            return new Result<>("查询不到");
        }

        //封装结果返回
        return new Result<>(true, MessageConstant.QUERY_CHECKITEM_SUCCESS, checkItemList);
    }

    /**
     * @param checkItemDto
     * @param currentPage
     * @param pageSize
     * @Author: JoinCao
     * @CreateDate: 2020-04-16
     * @Description: 根据条件查询加分页
     */
    @Override
    public Result search(CheckItemDto checkItemDto, Integer currentPage, Integer pageSize) {
        //参数校验
        if (currentPage == null) {
            currentPage = 1;
        }
        if (pageSize == null) {
            pageSize = 1;
        }
        CheckItem checkItem = new CheckItem();
        BeanUtils.copyProperties(checkItemDto, checkItem);//将CheckItemDto对象拷贝到CheckItem中
        PageHelper.startPage(currentPage, pageSize);//PageHelper只对下面一条查询有效,再有一条查询需要再写一次
        //业务逻辑执行
        Page<CheckItem> pageList = (Page<CheckItem>) checkItemMapper.search(checkItem);
        if (pageList == null || pageList.getTotal() == 0) {
            return new Result<>("查询失败");
        }
        //封装结果
        PageResult<CheckItem> pageResult = new PageResult<>();
        pageResult.setTotal(pageList.getTotal());
        pageResult.setRows(pageList.getResult());
        return new Result(pageResult);
    }

    /**
     * @param id
     * @Author: JoinCao
     * @CreateDate: 2020-04-16
     * @Description: 根据Id查询
     */
    @Override
    public Result<CheckItem> findOne(Integer id) {
        CheckItem one = checkItemMapper.findOne(id);
        if (one == null) {
            return new Result<>("无此数据");
        }
        return new Result<>(true, MessageConstant.QUERY_CHECKITEM_SUCCESS, one);
    }

    /**
     * @param id
     * @param checkItem
     * @Author: JoinCao
     * @CreateDate: 2020-04-16
     * @Description: 根据id修改
     */
    @Override
    public Result<CheckItem> edit(Integer id, CheckItem checkItem) {
        //查询id
        CheckItem checkItem1 = checkItemMapper.findOne(id);
        if (checkItem1 == null) {
            return new Result<>("无此数据");
        }
        checkItem.setId(id);
        checkItemMapper.edit(checkItem);
        return new Result<>(true, MessageConstant.EDIT_CHECKITEM_SUCCESS, null);
    }

    /**
     * @param checkItem
     * @Author: JoinCao
     * @CreateDate: 2020-04-16
     * @Description: 新增
     */
    @Override
    public Result<CheckItem> add(CheckItem checkItem) {
        //返回值类型是CheckItem,需要主键返回
        checkItemMapper.add(checkItem);
        return new Result<>(checkItem);
    }

    /**
     * @param id
     * @Author: JoinCao
     * @CreateDate: 2020-04-16
     * @Description: 根据id删除
     */
    @Override
    public Result delete(Integer id) {
        checkItemMapper.delete(id);
        return new Result(true, MessageConstant.DELETE_CHECKITEM_SUCCESS, null);
    }
}
