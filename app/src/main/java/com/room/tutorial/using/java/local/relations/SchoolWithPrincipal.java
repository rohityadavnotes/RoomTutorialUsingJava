package com.room.tutorial.using.java.local.relations;

import androidx.room.Embedded;
import androidx.room.Relation;
import com.room.tutorial.using.java.local.entity.Principal;
import com.room.tutorial.using.java.local.entity.School;

public class SchoolWithPrincipal {

    @Embedded
    public School school; /* parent entity */

    @Relation(
            parentColumn = "school_id", /* primary key of parent entity */
            entityColumn = "p_school_id" /* foreign key (refers to primary key of parent entity) */
    )
    public Principal principal; /* child entity */
}
