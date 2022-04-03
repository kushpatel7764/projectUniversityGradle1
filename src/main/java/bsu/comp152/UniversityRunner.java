package bsu.comp152;

import java.sql.SQLOutput;
import java.util.Random;
import java.util.Scanner;

public class UniversityRunner {
    University university;
    Scanner keyboard;
    public UniversityRunner(University university) {
        keyboard = new Scanner(System.in);
        this.university = university;
    }

    public University getUniversity() {
        return university;
    }

    public void runUniversity(){

    }

    void HireProf (){
        System.out.println("Professor's Name: ");
        String profName = keyboard.nextLine();
        System.out.println("Professor's Department: ");
        String profDepartment = keyboard.nextLine();
        Professor professor = new Professor(profName, profDepartment);
        university.hireProfessor(professor);
    }
     void AdmitStudent (){
        int n = 1;
        if (university.getFaculty().size() <= 0){
            System.out.println("No professor available");
            // return to the main menu
        }
         System.out.println("Student's Name: ");
         String studentName = keyboard.nextLine();

         Random rand = new Random();
         Professor prof = university.getFaculty().get(rand.nextInt(university.getFaculty().size()));

         Student student = new Student(studentName, prof, n); // ask what to do for id
         n++;
         university.getFaculty().get(university.getFaculty().indexOf(prof)).addAdvisee(student);
         university.admitStudent(student);
     }

     void ProcessGrad (){
        for (Student student : university.graduateStudents()){
            System.out.println("Congratulations " + student.getName() + "!!!");
            if (student.getGPA() > 3.7f) {
                System.out.println(student.getName() + " graduated with high honors.");
            }
            else if (student.getGPA() > 3.3f){
                System.out.println(student.getName() + " graduated with honors.");
            }
        }
     }

     void FindStudent (){
         System.out.println("Please enter StudentID: ");
         String studentID = keyboard.nextLine();
         int StudentID = Integer.parseInt(studentID);
         if ( university.findStudent(StudentID).size() <= 0){
             System.out.println("Student was not found");
         }
         if (university.findStudent(StudentID).size() > 0) {
             university.findStudent(StudentID).get(0).toString();
             // Open student menu for the student above
         }
     }

     void FacultyList (){
        for (Professor professor : university.getFaculty()){
            System.out.println(professor.toString() + "\n");
        }
     }

     void Exit (){
        System.exit(0);
     }

     void StudentMenu (){

     }
}
