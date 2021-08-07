package com.room.tutorial.using.java.local.relations;

import androidx.room.Embedded;
import androidx.room.Relation;
import com.room.tutorial.using.java.local.entity.Subject;
import com.room.tutorial.using.java.local.entity.Teacher;
import java.util.List;

public class TeacherWithSubject {

    @Embedded
    public Teacher teacher;

    @Relation(
            parentColumn = "teacher_id",
            entityColumn = "sub_teacher_id"
    )
    public List<Subject> subjectList;
}
