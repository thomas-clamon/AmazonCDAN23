package com.example.amazoncdan.dto;

import java.util.List;

public class CommandeDto {

    private String date;

    private String mail_client;

    private Integer produit;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getMail_client() {
        return mail_client;
    }

    public void setMail_client(String mail_client) {
        this.mail_client = mail_client;
    }

    public Integer getProduit() {
        return produit;
    }

    public void setProduit(Integer produit) {
        this.produit = produit;
    }
}
