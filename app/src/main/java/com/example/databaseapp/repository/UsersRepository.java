package com.example.databaseapp.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.databaseapp.db.UserEntity;
import com.example.databaseapp.db.AppDatabase;
import com.example.databaseapp.db.UserDao;

import java.util.List;

public class UsersRepository {
    private LiveData<List<UserEntity>> users;
    private UserDao userDao;

    public UsersRepository(Application application) {
        AppDatabase appDatabase = AppDatabase.getDatabaseInstance(application);
        userDao = appDatabase.userDao();
        users = userDao.getAllUsers();
    }

    public LiveData<List<UserEntity>> getAllUsers(){
        return users;
    }

    public void insertAllUsers(final List<UserEntity> users){
        AppDatabase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                userDao.insertAllUsers(users);
            }
        });
    }

}
