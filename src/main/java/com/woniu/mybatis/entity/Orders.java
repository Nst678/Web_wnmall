package com.woniu.mybatis.entity;

import java.math.BigDecimal;
import java.util.List;

public class Orders {
    private int id;
    private String no;
    private User user;
    private String orderTime;
    private BigDecimal totalMoney;
    private String people;
    private String address;
    private String phone;
    private String status;
    private String startTime;
    private String endTime;

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    private List<OrdersItem> ordersItems;

    @Override
    public String toString() {
        return "Orders{" +
                "id=" + id +
                ", no='" + no + '\'' +
                ", user=" + user +
                ", orderTime='" + orderTime + '\'' +
                ", totalMoney=" + totalMoney +
                ", people='" + people + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", status='" + status + '\'' +
                ", ordersItems=" + ordersItems +
                '}';
    }

    public List<OrdersItem> getOrdersItems() {
        return ordersItems;
    }

    public void setOrdersItems(List<OrdersItem> ordersItems) {
        this.ordersItems = ordersItems;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(String orderTime) {
        this.orderTime = orderTime;
    }

    public BigDecimal getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(BigDecimal totalMoney) {
        this.totalMoney = totalMoney;
    }

    public String getPeople() {
        return people;
    }

    public void setPeople(String people) {
        this.people = people;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
