package com.example.smartpost;

public class SmartPostInfo {
    private Integer place_id;
    private String name;
    private String address;
    private String country;
    private String availability;
    private String city;
    private String postalcode;
    @Override
            public String toString(){
        return name+" : "+availability;
    }

    SmartPostInfo(Integer place_id, String name, String address, String country, String availability, String city, String postalcode){
        this.place_id = place_id;
        this.name = name;
        this.address = address;
        this.country = country;
        this.availability = availability;
        this.city = city;
        this.postalcode = postalcode;
    }

    Integer getPlace_id(){ return place_id;}
    String getName(){ return name;}
    String getAddress(){ return address;}
    String getCountry(){ return country;}
    String getAvailability(){ return availability;}
    String getCity(){ return city;}
    String getPostalcode(){return postalcode;}


}




