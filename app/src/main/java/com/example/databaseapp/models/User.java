package com.example.databaseapp.models;

public class User {
    private String id, email, website, name, address, userImage;

    public User(String id, String email, String website, String name, String address, String userImage) {
        this.id = id;
        this.email = email;
        this.website = website;
        this.name = name;
        this.address = address;
        this.userImage = userImage;
    }

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getWebsite() {
        return website;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getUserImage() {
        return userImage;
    }
}
