package com.example.databaseapp.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {UserEntity.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    public abstract UserDao userDao();

    private static AppDatabase appDatabase;
    public static ExecutorService databaseWriteExecutor = Executors.newSingleThreadExecutor();

    public static synchronized AppDatabase getDatabaseInstance(Context context) {
        if (appDatabase != null)
            return appDatabase;
        appDatabase = Room.databaseBuilder(context, AppDatabase.class, "yozo_tech_db").build();
        return appDatabase;
    }
}
