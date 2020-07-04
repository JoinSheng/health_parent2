package com.health.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.health.CheckItemService;
import com.health.pojo.CheckItem;
import com.health.response.Result;
import com.health.resquest.CheckItemDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: JoinCao
 * @CreateDate: 2020-04-16
 */
@RestController
@RequestMapping("checkitem")
/*
controller层就干三件事:
                    1.接受承参数
                    2.调用service
                    3.返回结果
*/
public class CheckItemController {
    @Reference
    CheckItemService checkItemService;

    /**
     * @Author: JoinCao
     * @CreateDate: 2020-04-16
     * @Description: 查询所有
     */
    @GetMapping
    public Result<List<CheckItem>> findAll() {
        return checkItemService.findAll();
    }

    /**
     * @Author: JoinCao
     * @CreateDate: 2020-04-16
     * @Description: 根据条件查询加分页
     */
    @GetMapping("search")
    public Result search(@RequestBody CheckItemDto checkItemDto, @RequestParam("currentPage") Integer currentPage, @RequestParam("pageSize") Integer pageSize) {
        return checkItemService.search(checkItemDto, currentPage, pageSize);
    }

    /**
     * @Author: JoinCao
     * @CreateDate: 2020-04-16
     * @Description: 根据Id查询
     */
    @GetMapping("findOne")
    public Result<CheckItem> findOne(Integer id) {
        return checkItemService.findOne(id);
    }

    /**
     * @Author: JoinCao
     * @CreateDate: 2020-04-16
     * @Description: 根据id修改
     */
    @PutMapping
    public Result<CheckItem> edit(Integer id, @RequestBody CheckItem checkItem) {
        return checkItemService.edit(id, checkItem);
    }

    /**
     * @Author: JoinCao
     * @CreateDate: 2020-04-16
     * @Description: 新增
     */
    @PostMapping
    public Result<CheckItem> add(@RequestBody CheckItem checkItem) {
        return checkItemService.add(checkItem);
    }

    /**
     * @Author: JoinCao
     * @CreateDate: 2020-04-16
     * @Description: 根据id删除
     */
    @DeleteMapping
    public Result delete(Integer id) {
        return checkItemService.delete(id);
    }
}
