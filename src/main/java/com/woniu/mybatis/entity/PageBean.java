package com.woniu.mybatis.entity;

import java.util.List;

/**
 * @创建人 NST
 * @创建时间 2022/6/24
 * @描述
 */
public class PageBean<T> {
    private List<T> data; // 当前页数据
    private int currPageSize; // 当前页数据的数量
    private int currPage; // 当前页面
    private int totalPages;// 总页数
    private int totalNums;// 总数量
    private int pageSize;// 分页大小

    @Override
    public String toString() {
        return "PageBean{" +
                "data=" + data +
                ", currPageSize=" + currPageSize +
                ", currPage=" + currPage +
                ", totalPages=" + totalPages +
                ", totalNums=" + totalNums +
                ", pageSize=" + pageSize +
                '}';
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public int getCurrPageSize() {
        return currPageSize;
    }

    public void setCurrPageSize(int currPageSize) {
        this.currPageSize = currPageSize;
    }

    public int getCurrPage() {
        return currPage;
    }

    public void setCurrPage(int currPage) {
        this.currPage = currPage;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public int getTotalNums() {
        return totalNums;
    }

    public void setTotalNums(int totalNums) {
        this.totalNums = totalNums;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
