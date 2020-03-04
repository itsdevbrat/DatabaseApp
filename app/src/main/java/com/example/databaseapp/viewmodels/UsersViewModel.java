package com.example.databaseapp.viewmodels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.databaseapp.db.UserEntity;
import com.example.databaseapp.repository.UsersRepository;

import java.util.List;

public class UsersViewModel extends AndroidViewModel {
    private UsersRepository usersRepository;
    private LiveData<List<UserEntity>> users;

    public UsersViewModel(@NonNull Application application) {
        super(application);
        usersRepository = new UsersRepository(application);
        users = usersRepository.getAllUsers();
    }

    public LiveData<List<UserEntity>> getAllUsers() {
        return users;
    }

    public void insertAllUsers(List<UserEntity> users) {
        usersRepository.insertAllUsers(users);
    }
}
