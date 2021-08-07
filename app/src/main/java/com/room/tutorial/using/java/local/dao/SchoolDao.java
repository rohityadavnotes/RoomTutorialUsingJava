package com.room.tutorial.using.java.local.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.Update;
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
import java.util.List;

@Dao
public interface SchoolDao {

    /*============================================ Insert ========================================*/
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertSchoolReturnVoid(School school);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertSchoolReturnVoid(School... schools);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long insertSchool(School school);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long[] insertSchool(School... schools);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long insertPrincipal(Principal principal);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long insertTeacher(Teacher teacher);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long insertSubject(Subject subject);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long insertStudent(Student students);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long insertTeacherStudentCrossRef(TeacherStudentCrossRef teacherStudentCrossRef);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long insertUser(User user);
    /**
     * It is also possible to insert multiple rows with a single method — we just have to use a List
     * as a method parameter of the insert method:
     */
    @Insert
    void insertAll(List<User> users);
    /*============================================ Update ========================================*/
    @Update(onConflict = OnConflictStrategy.REPLACE)
    public void updateSchoolReturnVoid(School school);

    @Update(onConflict = OnConflictStrategy.REPLACE)
    public void updateSchoolReturnVoid(School... schools);

    @Update(onConflict = OnConflictStrategy.REPLACE)
    public int updateSchool(School school);

    @Update(onConflict = OnConflictStrategy.REPLACE)
    public int updateSchool(School... schools);
    /*============================================= Read =========================================*/
    @Query("SELECT * FROM school")
    public List<School> getSchools();

    @Query("SELECT * FROM school WHERE school_id = :schoolId")
    public School getSchoolUsingSchoolId(String schoolId);

    @Query("SELECT * FROM principal")
    public List<Principal> getPrincipals();

    @Query("SELECT * FROM principal WHERE principal_id = :principalId")
    public Principal getPrincipalUsingPrincipalId(String principalId);

    @Query("SELECT * FROM teacher")
    public List<Teacher> getTeachers();

    @Query("SELECT * FROM teacher WHERE teacher_id = :teacherId")
    public Teacher getTeacherUsingTeacherId(String teacherId);

    @Query("SELECT * FROM subject")
    public List<Subject> getSubject();

    @Query("SELECT * FROM subject WHERE subject_id = :subjectId")
    public Subject getSubject(String subjectId);

    @Query("SELECT * FROM teacher_student_join")
    public List<TeacherStudentCrossRef> getTeacherStudentJoin();

    @Query("SELECT * FROM user")
    public List<User> getUsers();

    @Query("SELECT * FROM user WHERE user_id = :id")
    public User getUser(String id);
    /*============================================ Delete ========================================*/
    @Delete
    public void deleteSchoolReturnVoid(School school);

    @Delete
    public void deleteSchoolReturnVoid(School... schools);

    @Delete
    public int deleteSchool(School school);

    @Delete
    public int deleteSchool(School... schools);

    @Query("DELETE FROM school")
    int deleteAllSchools();

    @Query("DELETE FROM school WHERE school_id = :schoolId")
    public int deleteSchool(String schoolId);

    @Query("DELETE FROM teacher WHERE teacher_id = :teacherId")
    public int deleteTeacher(String teacherId);

    @Query("DELETE FROM student WHERE roll_number = :rollNumber")
    public int deleteStudent(String rollNumber);
    /*==================================== One to One Relationship ===============================*/
    @Transaction
    @Query("SELECT * FROM school")
    public List<SchoolWithPrincipal> getSchoolsWithPrincipals();

    @Transaction
    @Query("SELECT * FROM school WHERE school_id = :schoolId")
    public SchoolWithPrincipal getSchoolWithPrincipalUsingSchoolId(String schoolId);
    /*==================================== One to Many Relationship ===============================*/
    @Transaction
    @Query("SELECT * FROM school")
    public List<SchoolWithTeacher> getSchoolsWithTeachers();

    @Transaction
    @Query("SELECT * FROM school WHERE school_id = :schoolId")
    public SchoolWithTeacher getSchoolWithTeachersUsingSchoolId(String schoolId);

    @Transaction
    @Query("SELECT * FROM teacher")
    public List<TeacherWithSubject> getTeachersWithSubjects();

    @Transaction
    @Query("SELECT * FROM teacher WHERE teacher_id = :teacherId")
    public TeacherWithSubject geTeacherWithSubjectsUsingTeacherId(String teacherId);
    /*=================================== Many to Many Relationship ==============================*/
    @Transaction
    @Query("SELECT * FROM student WHERE roll_number = :rollNumber")
    List<StudentWithTeacher> getStudentWithTeachersUsingStudentRollNumber(String rollNumber);

    @Transaction
    @Query("SELECT * FROM teacher WHERE teacher_id = :teacherId")
    public List<TeacherWithStudent> getTeacherWithStudentsUsingTeacherId(String teacherId);
}