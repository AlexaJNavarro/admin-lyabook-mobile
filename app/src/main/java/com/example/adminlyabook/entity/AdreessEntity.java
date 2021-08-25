package com.example.adminlyabook.entity;

import com.google.gson.annotations.SerializedName;

public class AdreessEntity {
    @SerializedName("display_address")
    private String display_address;

    @SerializedName("display_region")
    private String display_region;

    @SerializedName("lat")
    private Float lat;

    @SerializedName("lon")
    private Float lon;

    public AdreessEntity(String display_address, String display_region, Float lat, Float lon){
        this.display_address = display_address;
        this.display_region = display_region;
        this.lat = lat;
        this.lon = lon;
    }


    public String getDisplay_address() {
        return display_address;
    }

    public void setDisplay_address(String display_address) {
        this.display_address = display_address;
    }

    public String getDisplay_region() {
        return display_region;
    }

    public void setDisplay_region(String display_region) {
        this.display_region = display_region;
    }

    public Float getLat() {
        return lat;
    }

    public void setLat(Float lat) {
        this.lat = lat;
    }

    public Float getLon() {
        return lon;
    }

    public void setLon(Float lon) {
        this.lon = lon;
    }

    @Override
    public String toString(){
        return "Datos(" +
                "name: " + display_address + "/"+
                ", region: " + display_region + "/" +
                ", lon: " + lon + "/" +
                ", lat: " + lat + "/"  +
                ")";
    }
}
