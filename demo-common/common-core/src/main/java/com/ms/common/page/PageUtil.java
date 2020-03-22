package com.ms.common.page;

import java.util.List;

/**
 * @author
 * @title: PageUtil
 * @Description :
 * @Date ： 2020/3/22 21:47
 */
public class PageUtil {

    public static <T> PageVO<T> getPage(List<T> t, int page, int size, int total) {
        return PageVO.<T> builder().data(t)
                                   .page(page)
                                   .size(size)
                                   .total(total)
                                   .build();
    }
}
