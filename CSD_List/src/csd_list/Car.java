/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csd_list;

/**
 *
 * @author PHUC NGUYEN
 */
class Car {
    int price;
    String vendor, type;
    
    Car(){
        
    }
    Car(int xPrice,String xVendor,String xType){
        price = xPrice;
        vendor = xVendor;
        type = xType;
    }
    @Override
    public String toString() {
        return ("(" + price +"," +vendor + "," +type+ "} ");
    }
    
}
