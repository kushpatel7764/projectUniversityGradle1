package bsu.comp152;

import java.util.*;

public class University {

    ArrayList<Student> studentList;
    int nextStudentID;
    ArrayList<Professor> faculty;

    public University() {
        studentList = new ArrayList<Student>();
        faculty = new ArrayList<Professor>();
        nextStudentID = 2000;
    }

    public ArrayList<Professor> getFaculty() {
        return null;
    }

    public void hireProfessor(Professor professor) {
        faculty.add(professor);
    }

    public void admitStudent(Student student) {
        studentList.add(student);
        nextStudentID++;
    }

    public int getNextStudentID() {
        return nextStudentID;
    }

    public ArrayList<Student> findStudent(int id) {
        ArrayList<Student> foundStudent = new ArrayList<Student>();
        for (int i = 0; i < studentList.size(); i++){
            if (studentList.get(i).studentID == id){
                foundStudent.add(studentList.get(i));
            }
        }
        return foundStudent;
    }

    public List<Student> graduateStudents() {
        return null;
    }

}

