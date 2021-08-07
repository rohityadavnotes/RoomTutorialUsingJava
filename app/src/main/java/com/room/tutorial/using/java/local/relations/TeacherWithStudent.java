package com.room.tutorial.using.java.local.relations;

import androidx.room.Embedded;
import androidx.room.Junction;
import androidx.room.Relation;
import com.room.tutorial.using.java.local.entity.Student;
import com.room.tutorial.using.java.local.entity.Teacher;
import java.util.List;

public class TeacherWithStudent {

    @Embedded
    public Teacher teacher;

    @Relation(
            parentColumn = "teacher_id",
            entity = Student.class,
            entityColumn = "roll_number",
            associateBy = @Junction(TeacherStudentCrossRef.class)
    )
    public List<Student> studentList;
}
