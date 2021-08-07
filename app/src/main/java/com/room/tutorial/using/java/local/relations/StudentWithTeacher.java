package com.room.tutorial.using.java.local.relations;

import androidx.room.Embedded;
import androidx.room.Junction;
import androidx.room.Relation;
import com.room.tutorial.using.java.local.entity.Student;
import com.room.tutorial.using.java.local.entity.Teacher;
import java.util.List;

public class StudentWithTeacher {

    @Embedded
    public Student student;

    @Relation(
            parentColumn = "roll_number",
            entity = Teacher.class,
            entityColumn = "teacher_id",
            associateBy = @Junction(TeacherStudentCrossRef.class)
    )
    public List<Teacher> teacherList;
}
