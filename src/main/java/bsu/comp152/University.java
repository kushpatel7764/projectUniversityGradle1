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
        return faculty;
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
        for (Student student : studentList) {
            if (student.getStudentID() == id) {
                foundStudent.add(student);
            }

        }
        return foundStudent;
    }

    public List<Student> graduateStudents() {
        ArrayList<Student> graduatedStudents = new ArrayList<Student>();
        for (Student student : studentList) {
                if (student.getGPA() >= 2.0 && student.getCreditHours() >= 20){
                    graduatedStudents.add(student);
                }

        }
        for (Student student: graduatedStudents){
            studentList.remove(student);
            student.getAdvisor().removeAdvisee(student);
        }
        return graduatedStudents;
    }
     /*
//Having a hard time with this.
public List<Student> graduateStudents() {
    int listSize = studentList.size();
    ArrayList<Student> graduatedStudents = new ArrayList<Student>();
    //if(studentList.size() == 0) return graduatedStudents;
    for (int i = listSize-1; i >=0; i--) {
        Student currentStudent = studentList.get(i);
        if (currentStudent.getGPA() >= 2.0 && currentStudent.getCreditHours() >= 20) {

            graduatedStudents.add(currentStudent);
            studentList.remove(currentStudent);
            currentStudent.getAdvisor().removeAdvisee(currentStudent);

        }

    }
    return graduatedStudents;
}
    */

}

