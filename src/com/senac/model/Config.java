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
public class Config {
    @SerializedName("banco_imgs_token")
    private String dbImgsToken;

    public Config() {
    }

    public Config(String dbImgsToken) {
        this.dbImgsToken = dbImgsToken;
    }

    public String getDbImgsToken() {
        return dbImgsToken;
    }

    public void setDbImgsToken(String dbImgsToken) {
        this.dbImgsToken = dbImgsToken;
    }

    @Override
    public String toString() {
        return "Config{" + "dbImgsToken=" + dbImgsToken + '}';
    }
}
