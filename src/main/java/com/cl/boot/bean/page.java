package com.cl.boot.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class page {
    /**
     * 总条数
     */
    Integer total; //总条数

    /**
     * 总页数
     */
    Integer totalPage; //总页数
    /**
     * 页条数
     */
    Integer pageSize; //页条数
    /**
     * 当前页
     */
    Integer currentPage; //当前页
    /**
     * 当前页条数
     */
    Integer currentCount;//当前页条数
    List sList;

    public page(Integer total , Integer pageSize , Integer currentPage ) {
        this.total = total;
        this.pageSize = pageSize;
        this.currentPage = currentPage;
    }
}
