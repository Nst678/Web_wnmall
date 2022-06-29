package com.woniu.mybatis.entity;

/**
 * 类别的实体类
 *
 * @author laotan
 *
 */
public class Category {
    private int id;
    private String name;;
    private String navigation;
    private int sort;
    private String deleted;

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", navigation='" + navigation + '\'' +
                ", sort=" + sort +
                ", deleted='" + deleted + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNavigation() {
        return navigation;
    }

    public void setNavigation(String navigation) {
        this.navigation = navigation;
    }

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }

    public String getDeleted() {
        return deleted;
    }

    public void setDeleted(String deleted) {
        this.deleted = deleted;
    }

}

