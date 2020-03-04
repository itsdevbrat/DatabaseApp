package com.example.databaseapp.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.databaseapp.adapters.RecyclerAdapter;
import com.example.databaseapp.db.UserEntity;
import com.example.databaseapp.R;
import com.example.databaseapp.viewmodels.UsersViewModel;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.usersRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        final RecyclerAdapter recyclerAdapter = new RecyclerAdapter();
        recyclerView.setAdapter(recyclerAdapter);
        ArrayList<UserEntity> users = new ArrayList<>();
        try {
            CSVReader csvReader = new CSVReader(new InputStreamReader(getAssets().open("data1.csv")));
            String[] record;
            csvReader.readNext();
            int i = 0;
            while ((record = csvReader.readNext()) != null) {
                users.add(new UserEntity(record[0], record[1], record[2], record[3], record[4], String.valueOf(i++)));
            }
            csvReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (CsvValidationException e) {
            e.printStackTrace();
        }

        UsersViewModel usersViewModel = new ViewModelProvider(this).get(UsersViewModel.class);
        usersViewModel.getAllUsers().observe(this, new Observer<List<UserEntity>>() {
            @Override
            public void onChanged(List<UserEntity> users) {
                recyclerAdapter.setUsers((ArrayList<UserEntity>) users);
            }
        });
        usersViewModel.insertAllUsers(users);
    }
}
