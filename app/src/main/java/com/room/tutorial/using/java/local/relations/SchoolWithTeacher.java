package com.room.tutorial.using.java.local.relations;

import androidx.room.Embedded;
import androidx.room.Relation;
import com.room.tutorial.using.java.local.entity.School;
import com.room.tutorial.using.java.local.entity.Teacher;
import java.util.List;

public class SchoolWithTeacher {

    @Embedded
    public School school;

    @Relation(
            parentColumn = "school_id",
            entityColumn = "t_school_id"
    )
    public List<Teacher> teacherList;
}