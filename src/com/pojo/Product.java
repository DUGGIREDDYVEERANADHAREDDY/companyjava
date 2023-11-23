package com.pojo;

public class Product {
    String catagory;
    Double buyingprice;
 
    
int prdid;
  String prdname;
  double sellingprice;
  int availablequantity;
public int getPrdid() {
    return prdid;
}
public void setPrdid(int prdid, int i) {
    this.prdid = prdid;
}
public String getPrdname() {
    return prdname;
}
public void setBuyingprice(Double buyingprice) {
    
    this.buyingprice = buyingprice;
}
public String getCatagory() {
    return catagory;
}
public void setCatagory(String catagory) {
    this.catagory = catagory;
}
public double getBuyingprice() {
    return buyingprice;
}
public void setPrdname(String prdname) {
    
    this.prdname = prdname;
}
public double getSellingprice() {
    return sellingprice;
}
public void setSellingprice(double sellingprice) {
    this.sellingprice = this.buyingprice+(this.buyingprice*0.5);
}
public int getAvailablequantity() {
    return availablequantity;
}
public void setAvailablequantity(int availablequantity) {
    this.availablequantity = availablequantity;
}
public double price;
public double getPrice() {
	return price;
}
public void setPrice(double price) {
	this.price = price;
}
public void setPrdid(int prdid) {
	this.prdid = prdid;
}


}

