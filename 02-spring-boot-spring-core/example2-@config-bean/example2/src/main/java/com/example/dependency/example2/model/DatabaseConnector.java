package com.example.dependency.example2.model;

public abstract class DatabaseConnector {
    private String url;

    public abstract String connect();

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
