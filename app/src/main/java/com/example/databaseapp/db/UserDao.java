package com.example.databaseapp.db;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface UserDao {
    @Query("SELECT * FROM users_table")
    LiveData<List<UserEntity>> getAllUsers();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAllUsers(List<UserEntity> users);
}
