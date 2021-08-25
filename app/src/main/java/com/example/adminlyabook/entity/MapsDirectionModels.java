package com.example.adminlyabook.entity;

public class MapsDirectionModels {
    private String display_address;
    private String display_region;
    private Float lat;
    private Float lon;

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
}
