package com.example.adminlyabook.models;

public class Data {
    private String display_address;

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

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLon() {
        return lon;
    }

    public void setLon(Double lon) {
        this.lon = lon;
    }

    private String display_region;
    private Double lat;
    private Double lon;
}