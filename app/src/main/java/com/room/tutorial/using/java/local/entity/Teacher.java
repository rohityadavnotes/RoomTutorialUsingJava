package com.room.tutorial.using.java.local.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(tableName = "teacher",
        foreignKeys = @ForeignKey(
                entity = School.class,
                parentColumns = "school_id",
                childColumns = "t_school_id",
                onUpdate = ForeignKey.CASCADE,
                onDelete = ForeignKey.CASCADE
        )
)
public class Teacher {

    @PrimaryKey()
    @ColumnInfo(name = "teacher_id")
    @NonNull
    public String teacherId;

    @ColumnInfo(name = "first_name")
    public String firstName;

    @ColumnInfo(name = "last_name")
    public String lastName;

    @ColumnInfo(name = "t_school_id")
    public String schoolId;

    public Teacher(@NonNull String teacherId, String firstName, String lastName, String schoolId) {
        this.teacherId = teacherId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.schoolId = schoolId;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "teacherId='" + teacherId + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", schoolId='" + schoolId + '\'' +
                '}';
    }
}
