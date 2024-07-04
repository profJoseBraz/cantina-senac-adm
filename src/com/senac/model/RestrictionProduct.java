/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.senac.model;

/**
 *
 * @author 10156
 */
public class RestrictionProduct {
    private int id;
    private Product product;
    private Restriction restriction;

    public RestrictionProduct() {
    }

    public RestrictionProduct(int id, Product product, Restriction restriction) {
        this.id = id;
        this.product = product;
        this.restriction = restriction;
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

    public Restriction getRestriction() {
        return restriction;
    }

    public void setRestriction(Restriction restriction) {
        this.restriction = restriction;
    }

    @Override
    public String toString() {
        return "RestrictionProduct{" + "id=" + id + ", product=" + product + ", restriction=" + restriction + '}';
    }
}
