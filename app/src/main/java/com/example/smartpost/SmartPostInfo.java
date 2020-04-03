package com.example.smartpost;

public class SmartPostInfo {
    private Integer place_id;
    private String name;
    private String address;
    private String country;
    private String availability;
    @Override
            public String toString(){
        return place_id+name+address+country+availability;
    }

    SmartPostInfo(Integer place_id, String name, String address, String country, String availability){
        this.place_id = place_id;
        this.name = name;
        this.address = address;
        this.country = country;
        this.availability = availability;
    }

    Integer getPlace_id(){ return place_id;}
    String getName(){ return name;}
    String getAddress(){ return address;}
    String getCountry(){ return country;}
    String getAvailability(){ return availability;}


}




