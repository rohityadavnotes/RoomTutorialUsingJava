package com.room.tutorial.using.java.local.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(tableName = "user",
        indices = {@Index(value = {"user_id"})})
public class User {

    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "user_id")
    @NonNull
    public String userId;

    @ColumnInfo(name = "first_name")
    public String firstName;

    @ColumnInfo(name = "last_name")
    public String lastName;

    @ColumnInfo(name = "age")
    public String age;

    public User(@NonNull String userId, String firstName, String lastName, String age) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }
}