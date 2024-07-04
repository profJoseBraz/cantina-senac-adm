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
public class Product {
    private int id;
    private Category category;
    
    @SerializedName("nome")
    private String name;
    
    @SerializedName("descricao")
    private String description;
    
    @SerializedName("valor")
    private Double value;
    
    @SerializedName("imagem")
    private String image;

    public Product() {
    }

    public Product(int id, Category categoryId, String name, String description, Double value, String image) {
        this.id = id;
        this.category = categoryId;
        this.name = name;
        this.description = description;
        this.value = value;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Category getCategoryId() {
        return category;
    }

    public void setCategoryId(Category categoryId) {
        this.category = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Product{" + "id=" + id + ", categoryId=" + category + ", name=" + name + ", description=" + description + ", value=" + value + ", image=" + image + '}';
    }
}
