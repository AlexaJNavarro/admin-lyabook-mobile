package com.example.adminlyabook.models;

import java.util.List;

public class Book {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public Float getPrice_current() {
        return price_current;
    }

    public void setPrice_current(Float price_current) {
        this.price_current = price_current;
    }

    public List<String> getImages_src() {
        return images_src;
    }

    public void setImages_src(List<String> images_src) {
        this.images_src = images_src;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public List<String> getCategories() {
        return categories;
    }

    public void setCategories(List<String> categories) {
        this.categories = categories;
    }

    private String author;
    private String editorial;
    private Float price_current;
    private List<String> images_src;
    private String description;
    private Type type;
    private List<String> categories;
}
