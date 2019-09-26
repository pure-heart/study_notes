package com.jhly.myBatisDemo.model;

import lombok.Data;

import java.util.List;

/**
 * 分页参数数据类
 * @Auther:JHLY
 * @Date:2019/9/26
 * @Description:com.jhly.myBatisDemo.model
 * @Version:1.0
 */
@Data
public class PageInfo {
    private Integer pageSize;//每页条数
    private Integer pageNumber;//开始页码
    private Integer pageStart;//起始行
    private Long total;//总条数
    private List<?> list;//当前页数据
}
