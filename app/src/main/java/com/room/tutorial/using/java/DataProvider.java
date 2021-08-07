package com.room.tutorial.using.java;

import com.room.tutorial.using.java.local.entity.Address;
import com.room.tutorial.using.java.local.entity.Principal;
import com.room.tutorial.using.java.local.entity.School;
import com.room.tutorial.using.java.local.entity.Student;
import com.room.tutorial.using.java.local.entity.Subject;
import com.room.tutorial.using.java.local.entity.Teacher;
import com.room.tutorial.using.java.local.entity.User;
import com.room.tutorial.using.java.local.relations.TeacherStudentCrossRef;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class DataProvider {

    public ArrayList<School> getSchoolArrayList() {
        Address address = new Address("529/6 Dr. Shyam Prasad Mukraji Nager", "M.P.", "Indore", 452015);

        ArrayList<School> list = new ArrayList<>();
        list.add(new School("S1", "Private", "National Public School", address, getCurrentDate(), getCurrentDate()));
        list.add(new School("S2", "Government", "Maharaja Sivaji Rao School", address, getCurrentDate(), getCurrentDate()));
        list.add(new School("S3", "Private", "Prestige Public School", address, getCurrentDate(), getCurrentDate()));

        return list;
    }

    public ArrayList<School> getSchoolArrayListUpdate() {
        Address address = new Address("529/6 Dr. Shyam Prasad Mukraji Nager", "U.P", "Indore", 452015);

        ArrayList<School> list = new ArrayList<>();
        list.add(new School("S1", "Private", "National Public School", address, getCurrentDate(), getCurrentDate()));
        list.add(new School("S2", "Government", "Maharaja Sivaji Rao School", address, getCurrentDate(), getCurrentDate()));
        list.add(new School("S3", "Private", "Prestige Public School", address, getCurrentDate(), getCurrentDate()));

        return list;
    }

    public ArrayList<Principal> getPrincipalArrayList() {
        ArrayList<Principal> list = new ArrayList<>();
        list.add(new Principal("P1", "Sunita", "Singh", "S1"));
        list.add(new Principal("P2", "Jasmine", "Josh", "S2"));
        list.add(new Principal("P3", "Harmanjit", "Kaur", "S3"));
        return list;
    }

    public ArrayList<Teacher> getTeacherArrayList() {
        ArrayList<Teacher> list = new ArrayList<>();
        list.add(new Teacher("T1", "Saroj", "Nagin", "S1"));
        list.add(new Teacher("T2", "Vishwas", "Srikaran", "S1"));
        list.add(new Teacher("T3", "Jasveer", "Khadri", "S2"));
        list.add(new Teacher("T4", "Shivani", "Sarma", "S2"));
        list.add(new Teacher("T5", "Madhukar", "Talwar", "S3"));
        list.add(new Teacher("T6", "Pravin", "Gandhi", "S3"));
        return list;
    }

    public ArrayList<Subject> getSubjectArrayList() {
        ArrayList<Subject> list = new ArrayList<>();
        list.add(new Subject("Sub1", "Math", "SCODE1", "T1"));
        list.add(new Subject("Sub2", "English", "SCODE2", "T1"));
        list.add(new Subject("Sub3", "Physics", "SCODE3", "T2"));
        list.add(new Subject("Sub4", "Chemistry", "SCODE4", "T2"));
        list.add(new Subject("Sub5", "Hindi", "SCODE5", "T3"));
        list.add(new Subject("Sub6", "Sanskrit", "SCODE6", "T4"));
        return list;
    }

    public ArrayList<Student> getStudentArrayList() {
        ArrayList<Student> list = new ArrayList<>();
        list.add(new Student("Stu6", "Aditi", "Musunur", "6th", "stu6gmail.com", "7898680304", "S1"));
        list.add(new Student("Stu7", "Advitiya", "Sujeet", "7th", "stu7gmail.com", "7898680304", "S2"));
        list.add(new Student("Stu8", "Amrish", "Ilyas", "8th", "stu8gmail.com", "7898680304", "S1"));
        list.add(new Student("Stu9", "Jayadev", "Mitali", "9th", "stu9gmail.com", "7898680304", "S2"));
        list.add(new Student("Stu10", "Vijai", "Sritharan", "10th", "stu10gmail.com", "7898680304", "S1"));
        list.add(new Student("Stu11", "Naveen", "Tikaram", "11th", "stu11gmail.com", "7898680304", "S2"));
        return list;
    }

    public ArrayList<TeacherStudentCrossRef> getTeacherStudentCrossRefArrayList() {
        ArrayList<TeacherStudentCrossRef> list = new ArrayList<>();
        list.add(new TeacherStudentCrossRef("T1", "Stu6"));
        list.add(new TeacherStudentCrossRef("T1", "Stu7"));
        list.add(new TeacherStudentCrossRef("T2", "Stu8"));
        list.add(new TeacherStudentCrossRef("T2", "Stu9"));
        list.add(new TeacherStudentCrossRef("T3", "Stu10"));
        list.add(new TeacherStudentCrossRef("T3", "Stu11"));
        list.add(new TeacherStudentCrossRef("T4", "Stu9"));
        list.add(new TeacherStudentCrossRef("T4", "Stu10"));
        list.add(new TeacherStudentCrossRef("T5", "Stu11"));
        return list;
    }

    public static Date getCurrentDate() {
        Calendar calendar = Calendar.getInstance();
        Date date = calendar.getTime();
        return date;
    }

    public ArrayList<User> getUserArrayList() {
        ArrayList<User> list = new ArrayList<>();
        list.add(new User("1","Aditi", "Musunur", "18"));
        list.add(new User("2","Advitiya", "Sujeet", "22"));
        list.add(new User("3","Amrish", "Ilyas", "43"));
        list.add(new User("4","Jayadev", "Mitali", "55"));
        list.add(new User("5","Vijai", "Sritharan", "19"));
        return list;
    }

    /*public ArrayList<User> getUserArrayList() {
        ArrayList<User> list = new ArrayList<>();
        list.add(new User("1", "Aditi", "Musunur"));
        list.add(new User("2", "Advitiya", "Sujeet"));
        list.add(new User("3", "Amrish", "Ilyas"));
        list.add(new User("4", "Jayadev", "Mitali"));
        list.add(new User("5", "Vijai", "Sritharan"));
        list.add(new User("6", "Naveen", "Tikaram"));
        list.add(new User("7", "Aditi", "Musunur"));
        list.add(new User("8", "Advitiya", "Sujeet"));
        list.add(new User("9", "Amrish", "Ilyas"));
        list.add(new User("10", "Jayadev", "Mitali"));
        list.add(new User("11", "Aditi", "Musunur"));
        list.add(new User("12", "Advitiya", "Sujeet"));
        list.add(new User("13", "Amrish", "Ilyas"));
        list.add(new User("14", "Jayadev", "Mitali"));
        list.add(new User("15", "Vijai", "Sritharan"));
        list.add(new User("16", "Naveen", "Tikaram"));
        list.add(new User("17", "Aditi", "Musunur"));
        list.add(new User("18", "Advitiya", "Sujeet"));
        list.add(new User("19", "Amrish", "Ilyas"));
        list.add(new User("20", "Jayadev", "Mitali"));
        list.add(new User("21", "Aditi", "Musunur"));
        list.add(new User("22", "Advitiya", "Sujeet"));
        list.add(new User("23", "Amrish", "Ilyas"));
        list.add(new User("24", "Jayadev", "Mitali"));
        list.add(new User("25", "Vijai", "Sritharan"));
        list.add(new User("26", "Naveen", "Tikaram"));
        list.add(new User("27", "Aditi", "Musunur"));
        list.add(new User("28", "Advitiya", "Sujeet"));
        list.add(new User("29", "Amrish", "Ilyas"));
        list.add(new User("30", "Jayadev", "Mitali"));
        list.add(new User("31", "Aditi", "Musunur"));
        list.add(new User("32", "Advitiya", "Sujeet"));
        list.add(new User("33", "Amrish", "Ilyas"));
        list.add(new User("34", "Jayadev", "Mitali"));
        list.add(new User("35", "Vijai", "Sritharan"));
        list.add(new User("36", "Naveen", "Tikaram"));
        list.add(new User("37", "Aditi", "Musunur"));
        list.add(new User("38", "Advitiya", "Sujeet"));
        list.add(new User("39", "Amrish", "Ilyas"));
        list.add(new User("40", "Jayadev", "Mitali"));
        return list;
    }*/
}
