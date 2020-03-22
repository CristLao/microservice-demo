package com.ms.common.page;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author : crist
 * @Description :
 * @Date : 2020/3/21 22:24
 */
@Data
@Builder
public class PageVO <T> implements Serializable {

    private List<T> data;

    /**
     * 当前页
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


    public long getTotalPage() {
        if (total % size == 0)
            return total / size;
        else
            return total / size + 1;
    }

    /**
     * 该页是否有下一页.
     */
    public boolean hasNextPage() {
        return this.getPage() < this.getTotalPage() - 1;
    }

    /**
     * 该页是否有上一页.
     */
    public boolean hasPreviousPage() {
        return this.getPage() > 1;
    }
}
