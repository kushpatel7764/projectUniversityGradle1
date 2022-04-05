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
        int choice = 0;
            System.out.print("1. Hire a professor\n" +
                    "2. Admit a student\n" +
                    "3. Process graduation\n" +
                    "4. Look up a student\n" +
                    "5. Print a list of current faculty\n" +
                    "6. Exit \n" +
                    "Please type the number with your choice: ");
            choice = keyboard.nextInt();
            keyboard.nextLine();
            switch (choice) {
                case 1:
                    HireProf();
                    break;
                case 2:
                    AdmitStudent();
                    break;
                case 3:
                    ProcessGrad();
                    break;
                case 4:
                    FindStudent();
                    break;
                case 5:
                    FacultyList();
                    break;
                case 6: break;
            }
    }

    void HireProf (){
        System.out.print("Professor's Name: ");
        String profName = keyboard.nextLine();
        System.out.print("Professor's Department: ");
        String profDepartment = keyboard.nextLine();
        Professor professor = new Professor(profName, profDepartment);
        university.hireProfessor(professor);
    }
     void AdmitStudent (){
        if (university.getFaculty().size() <= 0){
            System.out.println("No professor available");
            runUniversity();
        }
         System.out.print("Student's Name: ");
         String studentName = keyboard.nextLine();

         Random rand = new Random();
         Professor prof = university.getFaculty().get(rand.nextInt((university.getFaculty().size())));

         Student student = new Student(studentName, prof, 2000); // ask what to do for id

         prof.addAdvisee(student);
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
         System.out.print("Please enter StudentID: ");
         int studentID = keyboard.nextInt();
         keyboard.nextLine();
         if (university.findStudent(studentID).size() <= 0){
             System.out.println("Student was not found");
         }
         if (university.findStudent(studentID).size() > 0) {
             university.findStudent(studentID).get(0).toString();
             StudentMenu(university.findStudent(studentID).get(0));
         }
     }

     void StudentMenu (Student student){
        int choice = 0;
            System.out.print("""
                    1. Add a class to the transcript\s
                    2. Assign an advisor to the student\s
                    3. Exit\s
                    Please type the number with your choice:\s""");
            choice = keyboard.nextInt();
            keyboard.nextLine();
            switch (choice) {
                case 1:
                    Transcript(student);
                    break;
                case 2:
                    Advisor(student);
                    break;
                case 3:
                    runUniversity();
                    break;

            }
     }

     void FacultyList (){
        for (Professor professor : university.getFaculty()){
            System.out.println(professor.toString() + "\n");
        }
     }

     void Transcript (Student student){
         System.out.print("Enter the number of credits for the class: ");
         int credits = keyboard.nextInt();
         keyboard.nextLine();
         System.out.print("Enter your grade for the class: ");
         double grade = keyboard.nextDouble();
         keyboard.nextLine();
         student.addClassToTranscript(credits, grade);
     }

     void Advisor (Student student) {
         for (Professor professor : university.getFaculty()){
             System.out.println(professor.toString() + "\n");
         }
         System.out.print("Enter the name for the advisor: ");
         String advisor = keyboard.nextLine();
         for (Professor professor: university.getFaculty()) {
             if (advisor.equals(professor.getName())) {
                 student.getAdvisor().removeAdvisee(student);
                 student.changeAdvisor(professor);
                 professor.addAdvisee(student);
             }
         }
         System.out.println("No Professor found");

     }
}
