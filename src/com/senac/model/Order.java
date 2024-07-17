/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.senac.model;

import com.google.gson.annotations.SerializedName;

/**
 *
 * @author 10156
 */
public class Order {
    private int id;
    
    @SerializedName("forma_pagamento")
    private PaymentMethod paymentMethod;
    
    @SerializedName("nome_cliente")
    private String customerName;
    
    @SerializedName("data")
    private String date;

    @SerializedName("hora")
    private String time;
    
    public Order() {
    }

    public Order(int id, PaymentMethod paymentMethod, String customerName, String date, String time) {
        this.id = id;
        this.paymentMethod = paymentMethod;
        this.customerName = customerName;
        this.date = date;
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Order{" + "id=" + id + ", paymentMethod=" + paymentMethod + ", customerName=" + customerName + ", date=" + date + ", time=" + time + '}';
    }
}
