package com.ms.common.page;

import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * @author : crist
 * @Description :
 * @Date : 2020/3/21 22:24
 */
@Data
@Builder
public class PageVO <T> {

    private List<T> data;

    /**
     * 分页
     */
    private int page;

    /**
     * 分页值
     */
    private int size;

    /**
     * 一共查询了多少条数据
     */
    private long total;
}
