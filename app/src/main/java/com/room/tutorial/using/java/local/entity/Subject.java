package com.room.tutorial.using.java.local.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(tableName = "subject",
        foreignKeys = @ForeignKey(
                entity = Teacher.class,
                parentColumns = "teacher_id",
                childColumns = "sub_teacher_id",
                onUpdate = ForeignKey.CASCADE,
                onDelete = ForeignKey.CASCADE
        )
)
public class Subject {
    @PrimaryKey()
    @ColumnInfo(name = "subject_id")
    @NonNull
    public String subjectId;

    @ColumnInfo(name = "subject_name")
    public String subjectName;

    @ColumnInfo(name = "subject_code")
    public String subjectCode;

    @ColumnInfo(name = "sub_teacher_id")
    public String teacherId;

    public Subject(@NonNull String subjectId, String subjectName, String subjectCode, String teacherId) {
        this.subjectId = subjectId;
        this.subjectName = subjectName;
        this.subjectCode = subjectCode;
        this.teacherId = teacherId;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "subjectId='" + subjectId + '\'' +
                ", subjectName='" + subjectName + '\'' +
                ", subjectCode='" + subjectCode + '\'' +
                ", teacherId='" + teacherId + '\'' +
                '}';
    }
}
