package com.room.tutorial.using.java.local.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(tableName = "principal",
        foreignKeys = @ForeignKey(
                entity = School.class,
                parentColumns = "school_id",
                childColumns = "p_school_id",
                onUpdate = ForeignKey.CASCADE,
                onDelete = ForeignKey.CASCADE
        ),
        indices = @Index(value = "p_school_id", unique = true)
)
public class Principal {

    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "principal_id")
    @NonNull
    public String principalId;

    @ColumnInfo(name = "first_name")
    public String firstName;

    @ColumnInfo(name = "last_name")
    public String lastName;

    @ColumnInfo(name = "p_school_id")
    public String schoolId;

    public Principal(@NonNull String principalId, String firstName, String lastName, String schoolId) {
        this.principalId = principalId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.schoolId = schoolId;
    }

    @Override
    public String toString() {
        return "Principal{" +
                "principalId='" + principalId + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", schoolId='" + schoolId + '\'' +
                '}';
    }
}
