package com.room.tutorial.using.java.local.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import java.util.Date;

@Entity(tableName = "school")
public class School {

    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "school_id")
    @NonNull
    public String schoolId;

    @ColumnInfo(name = "school_type")
    public String schoolType;

    @ColumnInfo(name = "school_name")
    public String schoolName;

    @Embedded
    public Address address;

    @ColumnInfo(name = "created_at")
    public Date createdAt;

    @ColumnInfo(name = "updated_at")
    public Date updatedAt;

    public School(@NonNull String schoolId, String schoolType, String schoolName, Address address, Date createdAt, Date updatedAt) {
        this.schoolId = schoolId;
        this.schoolType = schoolType;
        this.schoolName = schoolName;
        this.address = address;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "School{" +
                "schoolId='" + schoolId + '\'' +
                ", schoolType='" + schoolType + '\'' +
                ", schoolName='" + schoolName + '\'' +
                ", address=" + address +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
