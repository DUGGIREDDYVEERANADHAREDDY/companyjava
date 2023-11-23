package com.pojo;
import java.util.*;
public class Userdetails {
    private String username;
    private String password;
    private String mail;
    public List<Product> getProd() {
		return prod;
	}
	public void setProd(List<Product> prod) {
		this.prod = prod;
	}
	public double Sellingprice;
    List<Product> prod;
    public double getSellingprice() {
        return Sellingprice;
    }
    public void setSellingprice(double sellingprice) {
        Sellingprice = sellingprice;
    }
    private double supercoins;
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getMail() {
        return mail;
    }
    public void setMail(String mail) {
        this.mail = mail;
    }
    public double getSupercoins() {
        return supercoins;
    }
    public void setSupercoins(double supercoins) {
        this.supercoins = supercoins;
    }
    
}
