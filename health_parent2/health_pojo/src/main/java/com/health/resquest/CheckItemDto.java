package com.health.resquest;

import lombok.Data;

/**
 * @Description: 前端传递参数, 后台接受
 * @Author: JoinCao
 * @CreateDate: 2020-04-16
 * @UpdateUser: JoinCao
 * @UpdateDate: 2020-04-16
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
@Data
public class CheckItemDto extends QueryPageBean {
    private String code;//项目编码
    private String name;//项目名称
    private String type;//检查项类型，分为检查和检验两种类型
}
