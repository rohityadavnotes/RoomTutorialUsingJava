package com.room.tutorial.using.java.local.relations;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import com.room.tutorial.using.java.local.entity.Student;
import com.room.tutorial.using.java.local.entity.Teacher;

@Entity(tableName = "teacher_student_join",
        primaryKeys = {"teacher_id","roll_number"},
        foreignKeys = {
                @ForeignKey(entity = Teacher.class,
                        parentColumns = "teacher_id",
                        childColumns = "teacher_id",
                        onUpdate = ForeignKey.CASCADE,
                        onDelete = ForeignKey.CASCADE
                ),
                @ForeignKey(entity = Student.class,
                        parentColumns = "roll_number",
                        childColumns = "roll_number",
                        onUpdate = ForeignKey.CASCADE,
                        onDelete = ForeignKey.CASCADE
                )
        },
        indices = @Index(value = {"teacher_id","roll_number"})
)
public class TeacherStudentCrossRef {

    @ColumnInfo(name = "teacher_id")
    @NonNull
    public String teacherId;

    @ColumnInfo(name = "roll_number")
    @NonNull
    public String rollNumber;

    public TeacherStudentCrossRef(@NonNull String teacherId, @NonNull String rollNumber) {
        this.teacherId = teacherId;
        this.rollNumber = rollNumber;
    }

    @Override
    public String toString() {
        return "TeacherStudentCrossRef{" +
                "teacherId='" + teacherId + '\'' +
                ", rollNumber='" + rollNumber + '\'' +
                '}';
    }
}