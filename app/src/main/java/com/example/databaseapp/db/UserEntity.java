package com.example.databaseapp.db;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "users_table")
public class UserEntity {
    @PrimaryKey
    @NonNull
    private String id;
    private String email;
    private String website;
    private String name;
    private String address;
    private String userImage;

    public UserEntity(@NonNull String id, String email, String website, String name, String address, String userImage) {
        this.id = id;
        this.email = email;
        this.website = website;
        this.name = name;
        this.address = address;
        this.userImage = userImage;
    }

    @NonNull
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
