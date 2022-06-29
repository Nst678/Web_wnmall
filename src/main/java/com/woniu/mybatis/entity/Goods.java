package com.woniu.mybatis.entity;

import sun.awt.image.IntegerInterleavedRaster;

import java.math.BigDecimal;

public class Goods {
    private int id;
    private String isbn;
    private String name;
    private Category category;
    private BigDecimal price;
    private BigDecimal salesPrice;
    private String image;
    private String description;
    private Integer stock;
    private Integer salesNum;
    private String newest;
    private String hotest;
    private String status;


    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "id=" + id +
                ", isbn='" + isbn + '\'' +
                ", name='" + name + '\'' +
                ", category=" + category +
                ", price=" + price +
                ", salesPrice=" + salesPrice +
                ", image='" + image + '\'' +
                ", description='" + description + '\'' +
                ", stock=" + stock +
                ", salesNum=" + salesNum +
                ", newest='" + newest + '\'' +
                ", hotest='" + hotest + '\'' +
                ", status='" + status + '\'' +
                '}';
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getSalesPrice() {
        return salesPrice;
    }

    public void setSalesPrice(BigDecimal salesPrice) {
        this.salesPrice = salesPrice;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Integer getSalesNum() {
        return salesNum;
    }

    public void setSalesNum(Integer salesNum) {
        this.salesNum = salesNum;
    }

    public String getNewest() {
        return newest;
    }

    public void setNewest(String newest) {
        this.newest = newest;
    }

    public String getHotest() {
        return hotest;
    }

    public void setHotest(String hotest) {
        this.hotest = hotest;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
