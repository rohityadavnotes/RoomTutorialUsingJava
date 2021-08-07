package com.room.tutorial.using.java.local.database;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.room.tutorial.using.java.local.converter.DateConverter;
import com.room.tutorial.using.java.local.dao.SchoolDao;
import com.room.tutorial.using.java.local.entity.Principal;
import com.room.tutorial.using.java.local.entity.School;
import com.room.tutorial.using.java.local.entity.Student;
import com.room.tutorial.using.java.local.entity.Subject;
import com.room.tutorial.using.java.local.entity.Teacher;
import com.room.tutorial.using.java.local.entity.User;
import com.room.tutorial.using.java.local.relations.TeacherStudentCrossRef;

@Database(entities = {School.class, Principal.class, Teacher.class, Subject.class, Student.class, TeacherStudentCrossRef.class, User.class}, version = 1, exportSchema = true)
@TypeConverters({DateConverter.class})
public abstract class MyRoomDatabase extends RoomDatabase {

    private static final Object LOCK = new Object();

    private static volatile MyRoomDatabase INSTANCE;

    public static MyRoomDatabase getInstance(final Context context) {
        if (INSTANCE == null)
        {
            synchronized (LOCK)
            {
                if (INSTANCE == null)
                {
                    INSTANCE = Room
                            .databaseBuilder(context.getApplicationContext(), MyRoomDatabase.class, "RoomSchool.db")
                            .addCallback(roomCallback)
                            /* Allow CRUD Operation on MainThread */
                            .allowMainThreadQueries()
                            /* Migrate database usage */
                            //.addMigrations()
                            /* If an error occurs in the migration of the database, the database will be recreated instead of a crash */
                            //.fallbackToDestructiveMigration()
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    public static void destroyInstance() {
        INSTANCE = null;
    }

    private static Callback roomCallback = new Callback(){

        /* Called when creating a database for the first time, but after creating all tables */
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
        }

        /* Called when the database is opened */
        @Override
        public void onOpen(@NonNull SupportSQLiteDatabase db) {
            super.onOpen(db);
        }

        @Override
        public void onDestructiveMigration(@NonNull SupportSQLiteDatabase db) {
            super.onDestructiveMigration(db);
        }
    };

    public abstract SchoolDao schoolDao();
}
