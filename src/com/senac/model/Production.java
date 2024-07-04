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
public class Production {
    private int id;
    private Product product;
    
    @SerializedName("data")
    private String date;
    
    @SerializedName("quantidade")
    private int amount;
    
    @SerializedName("observacao")
    private String observation;

    public Production() {
    }

    public Production(int id, Product product, String date, int amount, String observation) {
        this.id = id;
        this.product = product;
        this.date = date;
        this.amount = amount;
        this.observation = observation;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }

    @Override
    public String toString() {
        return "Production{" + "id=" + id + ", product=" + product + ", date=" + date + ", amount=" + amount + ", observation=" + observation + '}';
    }
}
