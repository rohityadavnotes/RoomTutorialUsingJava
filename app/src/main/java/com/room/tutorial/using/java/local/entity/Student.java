package com.room.tutorial.using.java.local.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "student")
public class Student {

    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "roll_number")
    @NonNull
    public String rollNumber;

    @ColumnInfo(name = "first_name")
    public String firstName;

    @ColumnInfo(name = "last_name")
    public String lastName;

    @ColumnInfo(name = "study_in_class")
    public String studyInClass;

    @ColumnInfo(name = "email")
    public String email;

    @ColumnInfo(name = "phone_number")
    public String phoneNumber;

    @ColumnInfo(name = "school_id")
    public String schoolId;

    public Student(@NonNull String rollNumber, String firstName, String lastName, String studyInClass, String email, String phoneNumber, String schoolId) {
        this.rollNumber = rollNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.studyInClass = studyInClass;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.schoolId = schoolId;
    }

    @Override
    public String toString() {
        return "Student{" +
                "rollNumber='" + rollNumber + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", studyInClass='" + studyInClass + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", schoolId='" + schoolId + '\'' +
                '}';
    }
}
