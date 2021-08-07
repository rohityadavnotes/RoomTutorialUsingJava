package com.room.tutorial.using.java.ui;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import com.room.tutorial.using.java.DataProvider;
import com.room.tutorial.using.java.R;
import com.room.tutorial.using.java.local.SQLiteImporterExporter;
import com.room.tutorial.using.java.local.dao.SchoolDao;
import com.room.tutorial.using.java.local.database.MyRoomDatabase;
import com.room.tutorial.using.java.local.entity.Principal;
import com.room.tutorial.using.java.local.entity.School;
import com.room.tutorial.using.java.local.entity.Student;
import com.room.tutorial.using.java.local.entity.Subject;
import com.room.tutorial.using.java.local.entity.Teacher;
import com.room.tutorial.using.java.local.entity.User;
import com.room.tutorial.using.java.local.relations.SchoolWithPrincipal;
import com.room.tutorial.using.java.local.relations.SchoolWithTeacher;
import com.room.tutorial.using.java.local.relations.StudentWithTeacher;
import com.room.tutorial.using.java.local.relations.TeacherStudentCrossRef;
import com.room.tutorial.using.java.local.relations.TeacherWithStudent;
import com.room.tutorial.using.java.local.relations.TeacherWithSubject;
import com.room.tutorial.using.java.ui.base.BaseActivity;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class SchoolActivity extends BaseActivity {

    public static final String TAG = SchoolActivity.class.getSimpleName();

    private Button insertSchoolButton;
    private Button insertPrincipalButton;
    private Button insertTeacherButton;
    private Button insertSubjectButton;
    private Button insertStudentButton;
    private Button insertTeacherStudentCrossRefButton;
    private Button updateButton;
    private Button deleteButton;
    private Button readButton;
    private Button readSchoolWithPrincipalButton;
    private Button readSchoolWithTeacherButton;
    private Button readTeacherWithStudentButton;
    private Button readStudentWithTeacherButton;
    private Button readTeacherStudentCrossRefButton;
    private Button exportButton;

    private MyRoomDatabase myRoomDatabase;
    private SchoolDao schoolDao;
    private DataProvider dataProvider;

    private SQLiteImporterExporter sqLiteImporterExporter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getLayoutID() {
        return R.layout.activity_school;
    }

    @Override
    protected void initializeView() {
        insertSchoolButton                  = findViewById(R.id.insertSchoolButton);
        insertPrincipalButton               = findViewById(R.id.insertPrincipalButton);
        insertTeacherButton                 = findViewById(R.id.insertTeacherButton);
        insertSubjectButton                 = findViewById(R.id.insertSubjectButton);
        insertStudentButton                 = findViewById(R.id.insertStudentButton);
        insertTeacherStudentCrossRefButton  = findViewById(R.id.insertTeacherStudentCrossRefButton);
        updateButton                        = findViewById(R.id.updateButton);
        deleteButton                        = findViewById(R.id.deleteButton);
        readButton                          = findViewById(R.id.readButton);
        readSchoolWithPrincipalButton       = findViewById(R.id.readSchoolWithPrincipalButton);
        readSchoolWithTeacherButton         = findViewById(R.id.readSchoolWithTeacherButton);
        readTeacherWithStudentButton        = findViewById(R.id.readTeacherWithStudentButton);
        readStudentWithTeacherButton        = findViewById(R.id.readStudentWithTeacherButton);
        readTeacherStudentCrossRefButton    = findViewById(R.id.readTeacherStudentCrossRefButton);
        exportButton                        = findViewById(R.id.exportButton);
    }

    @Override
    protected void initializeObject() {
        myRoomDatabase = MyRoomDatabase.getInstance(this);
        schoolDao = myRoomDatabase.schoolDao();

        dataProvider = new DataProvider();

        sqLiteImporterExporter      = new SQLiteImporterExporter(getApplicationContext(), "RoomSchool.db");
    }

    @Override
    protected void initializeToolBar() {
    }

    @Override
    protected void initializeCallbackListener() {
        sqLiteImporterExporter.setOnImportListener(new SQLiteImporterExporter.ImportListener() {
            @Override
            public void onSuccess(String message) {
                Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Exception exception) {
                Toast.makeText(getApplicationContext(), exception.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        sqLiteImporterExporter.setOnExportListener(new SQLiteImporterExporter.ExportListener() {
            @Override
            public void onSuccess(String message) {
                Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Exception exception) {
                Toast.makeText(getApplicationContext(), exception.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void addTextChangedListener() {
    }

    @Override
    protected void setOnClickListener() {
        insertSchoolButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               //insertSchool();
              insertUser();
            }
        });

        insertPrincipalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertPrincipal();
            }
        });

        insertTeacherButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertTeacher();
            }
        });

        insertSubjectButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertSubject();
            }
        });

        insertStudentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertStudent();
            }
        });

        insertTeacherStudentCrossRefButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertTeacherStudentCrossRef();
            }
        });

        updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // updateAllSchool();
               // updateSchool();
                getTeacherWithSubject("T1");
            }
        });

        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //deleteAllSchool();
                //deleteSchool("S1");
                //deleteStudent("Stu11");
                deleteTeacher("T1");
            }
        });

        readButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                getSchool();
//                getSchool("S3");
//                getPrincipal("P1");
//                getPrincipal();
//                getTeacher();
                getUser("5");
                //getSubject();
            }
        });

        readSchoolWithPrincipalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSchoolWithPrincipals();
                getSchoolWithPrincipal("S3");
            }
        });

        readSchoolWithTeacherButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //getSchoolWithTeachers();
                getSchoolWithTeacher("S1");
            }
        });

        readTeacherWithStudentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getTeacherWithStudent("T1");
            }
        });

        readStudentWithTeacherButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getStudentWithTeacher("Stu6");
            }
        });

        readTeacherStudentCrossRefButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getTeachersStudentJoin();
            }
        });

        exportButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {

                    Uri sourceUri = MediaStore.Files.getContentUri(MediaStore.VOLUME_EXTERNAL);

                    ContentResolver contentResolver = getContentResolver();

                    ContentValues contentValues = new ContentValues();
                    contentValues.put(MediaStore.Files.FileColumns.TITLE, "RoomSchool");
                    contentValues.put(MediaStore.Files.FileColumns.DISPLAY_NAME, "RoomSchool.db");
                    contentValues.put(MediaStore.Files.FileColumns.MIME_TYPE, "application/x-sqlite3");

                    contentValues.put(MediaStore.Files.FileColumns.RELATIVE_PATH, Environment.DIRECTORY_DOCUMENTS + "/" + "exportDirectory");

                    Uri fileUri = contentResolver.insert(sourceUri, contentValues);
                    export(fileUri);
                }
            }
        });
    }

    private void insertSchool() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=0; i<dataProvider.getSchoolArrayList().size(); i++)
                {
                    School school = dataProvider.getSchoolArrayList().get(i);
                    long insert = schoolDao.insertSchool(school);
                    Log.e(TAG, " INSERT SCHOOL : "+school.schoolName+", 0 if not insert : "+insert);
                }
            }
        }).start();
    }

    private void insertPrincipal() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=0; i<dataProvider.getPrincipalArrayList().size(); i++)
                {
                    Principal principal = dataProvider.getPrincipalArrayList().get(i);
                    long insert = schoolDao.insertPrincipal(principal);
                    Log.e(TAG, " INSERT PRINCIPAL : "+principal.firstName+", 0 if not insert : "+insert);
                }
            }
        }).start();
    }

    private void insertTeacher() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=0; i<dataProvider.getTeacherArrayList().size(); i++)
                {
                    Teacher teacher = dataProvider.getTeacherArrayList().get(i);
                    long insert = schoolDao.insertTeacher(teacher);
                    Log.e(TAG, " INSERT TEACHER : "+teacher.firstName+", 0 if not insert : "+insert);
                }
            }
        }).start();
    }

    private void insertSubject() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=0; i<dataProvider.getSubjectArrayList().size(); i++)
                {
                    Subject subject = dataProvider.getSubjectArrayList().get(i);
                    long insert = schoolDao.insertSubject(subject);
                    Log.e(TAG, " INSERT SUBJECT : "+subject.subjectName+", 0 if not insert : "+insert);
                }
            }
        }).start();
    }

    private void insertStudent() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=0; i<dataProvider.getStudentArrayList().size(); i++)
                {
                    Student student = dataProvider.getStudentArrayList().get(i);
                    long insert = schoolDao.insertStudent(student);
                    Log.e(TAG, " INSERT STUDENT : "+student.firstName+", 0 if not insert : "+insert);
                }
            }
        }).start();
    }

    private void insertTeacherStudentCrossRef() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=0; i<dataProvider.getTeacherStudentCrossRefArrayList().size(); i++)
                {
                    TeacherStudentCrossRef teacherStudentCrossRef = dataProvider.getTeacherStudentCrossRefArrayList().get(i);
                    long insert = schoolDao.insertTeacherStudentCrossRef(teacherStudentCrossRef);
                    Log.e(TAG, " INSERT TEACHER STUDENT REFERENCE : Teacher Id : "+teacherStudentCrossRef.teacherId+" Student Id : "+teacherStudentCrossRef.rollNumber+", 0 if not insert : "+insert);
                }
            }
        }).start();
    }

    private void updateSchool() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                /* here address update to U.P */
                for (int i=0; i<dataProvider.getSchoolArrayListUpdate().size(); i++)
                {
                    School school = dataProvider.getSchoolArrayListUpdate().get(i);

                    int update = schoolDao.updateSchool(school);
                    Log.e(TAG, "UPDATE SCHOOL, number of updated row : "+update);
                }
            }
        }).start();
    }

    private void updateAllSchool() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                /* here address update to U.P */
                School school = dataProvider.getSchoolArrayListUpdate().get(0);
                School school1 = dataProvider.getSchoolArrayListUpdate().get(1);
                School school2 = dataProvider.getSchoolArrayListUpdate().get(2);

                int update = schoolDao.updateSchool(school, school1, school2);
                Log.e(TAG, "UPDATE ALL SCHOOL, number of updated row : "+update);
            }
        }).start();
    }

    private void deleteSchool(String schoolId) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                int delete = schoolDao.deleteSchool(schoolId);
                Log.e(TAG, "DELETE SCHOOL, number of row delete : "+delete);
            }
        }).start();
    }

    private void deleteAllSchool() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                int delete = schoolDao.deleteAllSchools();
                Log.e(TAG, "DELETE ALL SCHOOL, number of row delete : "+delete);
            }
        }).start();
    }

    private void deleteTeacher(String teacherId) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                int delete = schoolDao.deleteTeacher(teacherId);
                Log.e(TAG, "DELETE Teacher, number of row delete : "+delete);
            }
        }).start();
    }

    private void deleteStudent(String rollNumber) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                int delete = schoolDao.deleteStudent(rollNumber);
                Log.e(TAG, "DELETE Student, number of row delete : "+delete);
            }
        }).start();
    }

    private void getSchool() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                ArrayList<School> list = (ArrayList<School>) schoolDao.getSchools();
                Log.e(TAG, "=================Get List Of School==================");
                for (int i=0; i<list.size(); i++)
                {
                    School school = list.get(i);
                    Log.e(TAG, "School Id : "+school.schoolId);
                    Log.e(TAG, "School Type : "+school.schoolType);
                    Log.e(TAG, "School Name : "+school.schoolName);
                    Log.e(TAG, "School Street : "+school.address.street);
                    Log.e(TAG, "School State : "+school.address.state);
                    Log.e(TAG, "School City : "+school.address.city);
                    Log.e(TAG, "School PostCode : "+school.address.postCode);
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
                    Log.e(TAG, "Created Date and Time : "+simpleDateFormat.format(school.createdAt));
                    Log.e(TAG, "Update Date and Time : "+simpleDateFormat.format(school.updatedAt));
                }
            }
        }).start();
    }

    private void getSchool(String schoolId) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                School school = schoolDao.getSchoolUsingSchoolId(schoolId);

                if (school != null)
                {
                    Log.e(TAG, "=================Get School==================");
                    Log.e(TAG, "School Id : "+school.schoolId);
                    Log.e(TAG, "School Type : "+school.schoolType);
                    Log.e(TAG, "School Name : "+school.schoolName);
                    Log.e(TAG, "School Street : "+school.address.street);
                    Log.e(TAG, "School State : "+school.address.state);
                    Log.e(TAG, "School City : "+school.address.city);
                    Log.e(TAG, "School PostCode : "+school.address.postCode);
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
                    Log.e(TAG, "Created Date and Time : "+simpleDateFormat.format(school.createdAt));
                    Log.e(TAG, "Update Date and Time : "+simpleDateFormat.format(school.updatedAt));
                }
            }
        }).start();
    }

    private void getPrincipal() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                ArrayList<Principal> list = (ArrayList<Principal>) schoolDao.getPrincipals();
                Log.e(TAG, "=================Get List Of Principal==================");
                for (int i=0; i<list.size(); i++)
                {
                    Principal principal = list.get(i);
                    Log.e(TAG, "School Id : "+principal.schoolId);
                    Log.e(TAG, "Principal First Name : "+principal.firstName);
                    Log.e(TAG, "Principal Last Name: "+principal.lastName);
                }
            }
        }).start();
    }

    private void getPrincipal(String principalId) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                Principal principal = schoolDao.getPrincipalUsingPrincipalId(principalId);
                if (principal != null)
                {
                    Log.e(TAG, "=================Get Principal==================");
                    Log.e(TAG, "School Id : "+principal.schoolId);
                    Log.e(TAG, "Principal First Name : "+principal.firstName);
                    Log.e(TAG, "Principal Last Name: "+principal.lastName);
                }
            }
        }).start();
    }

    private void getTeacher(String principalId) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                Teacher teacher = schoolDao.getTeacherUsingTeacherId(principalId);
                if (teacher != null)
                {
                    Log.e(TAG, "=================Get Teacher==================");
                    Log.e(TAG, "School Id : "+teacher.schoolId);
                    Log.e(TAG, "Teacher First Name : "+teacher.firstName);
                    Log.e(TAG, "Teacher Last Name: "+teacher.lastName);
                }
            }
        }).start();
    }

    private void getTeacher() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                ArrayList<Teacher> list = (ArrayList<Teacher>) schoolDao.getTeachers();
                Log.e(TAG, "=================Get List Of Teachers==================");
                for (int i=0; i<list.size(); i++)
                {
                    Teacher teacher = list.get(i);
                    Log.e(TAG, "School Id : "+teacher.schoolId);
                    Log.e(TAG, "Teacher First Name : "+teacher.firstName);
                    Log.e(TAG, "Teacher Last Name: "+teacher.lastName);
                }
            }
        }).start();
    }

    private void getSchoolWithPrincipal(String schoolId) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                SchoolWithPrincipal schoolWithPrincipal = schoolDao.getSchoolWithPrincipalUsingSchoolId(schoolId);

                if (schoolWithPrincipal != null)
                {
                    Log.e(TAG, "=================Get SchoolWithPrincipal==================");
                    Log.e(TAG, "School Name : "+schoolWithPrincipal.school.schoolName);

                    if (schoolWithPrincipal.principal != null)
                    {

                        Log.e(TAG, "School Principal : "+schoolWithPrincipal.principal);
                    }
                }
            }
        }).start();
    }

    private void getSchoolWithPrincipals() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                ArrayList<SchoolWithPrincipal> list = (ArrayList<SchoolWithPrincipal>) schoolDao.getSchoolsWithPrincipals();

                Log.e(TAG, "=================SchoolWithPrincipals Size"+list.size()+"==================");

                for (int i=0; i<list.size(); i++)
                {
                    SchoolWithPrincipal schoolWithPrincipal = list.get(i);

                    Log.e(TAG, "=================Get SchoolWithPrincipals==================");
                    Log.e(TAG, "School Name : "+schoolWithPrincipal.school.schoolName);
                    if (schoolWithPrincipal.principal != null)
                    {

                        Log.e(TAG, "School Principal : "+schoolWithPrincipal.principal.firstName);
                    }
                    else
                    {
                        Log.e(TAG, "Principal Not Added");
                    }
                }
            }
        }).start();
    }

    private void getSchoolWithTeacher(String schoolId) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                SchoolWithTeacher schoolWithTeacher = schoolDao.getSchoolWithTeachersUsingSchoolId(schoolId);

                if (schoolWithTeacher != null)
                {
                    Log.e(TAG, "=================Get SchoolWithTeachers==================");
                    Log.e(TAG, "School Name : "+schoolWithTeacher.school.schoolName);

                    if (schoolWithTeacher.teacherList != null)
                    {
                        for (int j=0; j<schoolWithTeacher.teacherList.size(); j++)
                        {
                            Log.e(TAG, "School Teacher : "+schoolWithTeacher.teacherList.get(j).firstName);
                        }
                    }
                    else
                    {
                        Log.e(TAG, "Teachers Not Added");
                    }
                }
            }
        }).start();
    }

    private void getSchoolWithTeachers() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                ArrayList<SchoolWithTeacher> list = (ArrayList<SchoolWithTeacher>) schoolDao.getSchoolsWithTeachers();

                Log.e(TAG, "=================SchoolWithPrincipals Size"+list.size()+"==================");

                for (int i=0; i<list.size(); i++)
                {
                    SchoolWithTeacher schoolWithTeacher = list.get(i);

                    Log.e(TAG, "=================Get SchoolWithTeachers==================");
                    Log.e(TAG, "School Name : "+schoolWithTeacher.school.schoolName);

                    if (schoolWithTeacher.teacherList != null)
                    {
                        for (int j=0; j<schoolWithTeacher.teacherList.size(); j++)
                        {
                            Log.e(TAG, "School Teacher : "+schoolWithTeacher.teacherList.get(j).firstName);
                        }
                    }
                    else
                    {
                        Log.e(TAG, "Teachers Not Added");
                    }
                }
            }
        }).start();
    }

    private void getTeacherWithSubject(String teacherId) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                TeacherWithSubject teacherWithSubject = schoolDao.geTeacherWithSubjectsUsingTeacherId(teacherId);

                if (teacherWithSubject != null)
                {
                    Log.e(TAG, "=================Get TeacherWithSubject==================");
                    Log.e(TAG, "Teacher Name : "+teacherWithSubject.teacher.firstName);

                    if (teacherWithSubject.subjectList != null)
                    {
                        for (int j=0; j<teacherWithSubject.subjectList.size(); j++)
                        {
                            Log.e(TAG, "Teacher Subjects : "+teacherWithSubject.subjectList.get(j).subjectId);
                        }
                    }
                    else
                    {
                        Log.e(TAG, "TeacherWithSubject Not Added");
                    }
                }
            }
        }).start();
    }

    private void getTeacherWithSubject() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                ArrayList<TeacherWithSubject> list = (ArrayList<TeacherWithSubject>) schoolDao.getTeachersWithSubjects();

                Log.e(TAG, "=================TeacherWithSubject Size"+list.size()+"==================");

                for (int i=0; i<list.size(); i++)
                {
                    TeacherWithSubject teacherWithSubject = list.get(i);

                    Log.e(TAG, "=================Get TeacherWithSubject==================");
                    Log.e(TAG, "Teacher Name : "+teacherWithSubject.teacher.firstName);

                    if (teacherWithSubject.subjectList != null)
                    {
                        for (int j=0; j<teacherWithSubject.subjectList.size(); j++)
                        {
                            Log.e(TAG, "Teacher Subjects: "+teacherWithSubject.subjectList.get(j).subjectId);
                        }
                    }
                    else
                    {
                        Log.e(TAG, "TeacherWithSubject Not Added");
                    }
                }
            }
        }).start();
    }

    private void getSubject() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                ArrayList<Subject> list = (ArrayList<Subject>) schoolDao.getSubject();
                Log.e(TAG, "=================Get List Of School==================");
                for (int i=0; i<list.size(); i++)
                {
                    Subject subject = list.get(i);
                    Log.e(TAG, "Subject Id : "+subject.subjectId);
                    Log.e(TAG, "Subject Code : "+subject.subjectCode);
                    Log.e(TAG, "Subject Name : "+subject.subjectName);
                }
            }
        }).start();
    }

    private void getSubject(String subjectId) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                Subject subject = schoolDao.getSubject(subjectId);

                if (subject != null)
                {
                    Log.e(TAG, "Subject Id : "+subject.subjectId);
                    Log.e(TAG, "Subject Code : "+subject.subjectCode);
                    Log.e(TAG, "Subject Name : "+subject.subjectName);
                }
            }
        }).start();
    }

    private void getTeacherWithStudent(String teacherId) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                ArrayList<TeacherWithStudent> list = (ArrayList<TeacherWithStudent>) schoolDao.getTeacherWithStudentsUsingTeacherId(teacherId);

                Log.e(TAG, "=================TeacherWithStudent Size"+list.size()+"==================");

                for (int i=0; i<list.size(); i++)
                {
                    TeacherWithStudent teacherWithStudent = list.get(i);

                    Log.e(TAG, "=================Get TeacherWithStudents==================");
                    Log.e(TAG, "School Teacher : "+teacherWithStudent.teacher.teacherId);

                    if (teacherWithStudent.studentList != null)
                    {
                        for (int j=0; j<teacherWithStudent.studentList.size(); j++)
                        {
                            Log.e(TAG, "Teacher students : "+teacherWithStudent.studentList.get(j).rollNumber);
                        }
                    }
                    else
                    {
                        Log.e(TAG, "Teachers Not Added");
                    }
                }
            }
        }).start();
    }

    private void getStudentWithTeacher(String rollNumber) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                ArrayList<StudentWithTeacher> list = (ArrayList<StudentWithTeacher>) schoolDao.getStudentWithTeachersUsingStudentRollNumber(rollNumber);

                Log.e(TAG, "=================TeacherWithStudent Size"+list.size()+"==================");

                for (int i=0; i<list.size(); i++)
                {
                    StudentWithTeacher studentWithTeacher = list.get(i);

                    Log.e(TAG, "=================Get TeacherWithStudents==================");
                    Log.e(TAG, "School Student : "+studentWithTeacher.student.rollNumber);

                    if (studentWithTeacher.teacherList != null)
                    {
                        for (int j=0; j<studentWithTeacher.teacherList.size(); j++)
                        {
                            Log.e(TAG, "Student teachers : "+studentWithTeacher.teacherList.get(j).teacherId);
                        }
                    }
                    else
                    {
                        Log.e(TAG, "Students Not Added");
                    }
                }
            }
        }).start();
    }

    private void getTeachersStudentJoin() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                ArrayList<TeacherStudentCrossRef> list = (ArrayList<TeacherStudentCrossRef>) schoolDao.getTeacherStudentJoin();

                Log.e(TAG, "=================TeacherStudentCrossRef Size"+list.size()+"==================");

                for (int i=0; i<list.size(); i++)
                {
                    TeacherStudentCrossRef teacherStudentCrossRef= list.get(i);
                    long insert = schoolDao.insertTeacherStudentCrossRef(teacherStudentCrossRef);
                    Log.e(TAG, " TEACHER STUDENT REFERENCE : Teacher Id : "+teacherStudentCrossRef.teacherId+" Student Id : "+teacherStudentCrossRef.rollNumber+", 0 if not insert : "+insert);
                }
            }
        }).start();
    }

    private void insertUser() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=0; i<dataProvider.getUserArrayList().size(); i++)
                {
                    User user = dataProvider.getUserArrayList().get(i);
                    long insert = schoolDao.insertUser(user);
                    Log.e(TAG, " INSERT USER : "+user.firstName+", 0 if not insert : "+insert);
                }
            }
        }).start();
    }

    private void getUser(String userId) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                Log.e(TAG, "====Start Current Time ===="+System.currentTimeMillis());
                User user = schoolDao.getUser(userId);
                if (user != null)
                {
                    Log.e(TAG, "====End Current Time ======"+System.currentTimeMillis());

                    Log.e(TAG, "=================Get User==================");
                    Log.e(TAG, "User Id : "+user.userId);
                    Log.e(TAG, "User First Name : "+user.firstName);
                    Log.e(TAG, "User Last Name: "+user.lastName);
                    Log.e(TAG, "User Age: "+user.age);
                }
            }
        }).start();
    }

    private void export(Uri SDCardRealPathWhereToStoreDBFile) {
        if (sqLiteImporterExporter.isDataBaseExists())
        {
            try {
                sqLiteImporterExporter.exportDataBase(SDCardRealPathWhereToStoreDBFile);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else
        {
            Toast.makeText(getApplicationContext(), "DB Doesn't Exists", Toast.LENGTH_SHORT).show();
        }
    }
}