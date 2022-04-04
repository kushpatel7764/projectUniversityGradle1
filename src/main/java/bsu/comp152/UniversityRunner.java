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
        do {
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
                case 2:
                    AdmitStudent();
                case 3:
                    ProcessGrad();
                case 4:
                    FindStudent();
                case 5:
                    FacultyList();
            }
        }while(choice != 6);
    }

    void HireProf (){
        System.out.print("Professor's Name: ");
        String profName = keyboard.nextLine();
        System.out.print("Professor's Department: ");
        String profDepartment = keyboard.nextLine();
        Professor professor = new Professor(profName, profDepartment);
        university.hireProfessor(professor);
        runUniversity();
    }
     void AdmitStudent (){
        int n = 1;
        if (university.getFaculty().size() <= 0){
            System.out.print("No professor available");
            runUniversity();
        }
         System.out.print("Student's Name: ");
         String studentName = keyboard.nextLine();

         Random rand = new Random();
         Professor prof = university.getFaculty().get(rand.nextInt(university.getFaculty().size()));

         Student student = new Student(studentName, prof, n); // ask what to do for id
         n++;
         university.getFaculty().get(university.getFaculty().indexOf(prof)).addAdvisee(student);
         university.admitStudent(student);
         runUniversity();
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
        runUniversity();
     }

     void FindStudent (){
         System.out.print("Please enter StudentID: ");
         String studentID = keyboard.nextLine();
         int StudentID = Integer.parseInt(studentID);
         if (university.findStudent(StudentID).size() <= 0){
             System.out.println("Student was not found");
         }
         if (university.findStudent(StudentID).size() > 0) {
             university.findStudent(StudentID).get(0).toString();
             StudentMenu(university.findStudent(StudentID).get(0));
         }
         runUniversity();
     }

     void StudentMenu (Student student){
        int choice = 0;
            System.out.print("1. Add a class to the transcript \n" +
                    "2. Assign an advisor to the student \n" +
                    "3. Exit \n" +
                    "Please type the number with your choice: ");
            choice = keyboard.nextInt();
            keyboard.nextLine();
            switch (choice) {
                case 1:
                    Transcript(student);
                case 2:
                    Advisor(student);
                case 3: runUniversity();
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
         StudentMenu(student);
     }

     void Advisor (Student student) {
         for (Professor professor : university.getFaculty()){
             System.out.println(professor.toString() + "\n");
         }
         System.out.print("Enter the name for the advisor: ");
         String advisor = keyboard.nextLine();
         if (advisor.equals(university.getFaculty().get(university.getFaculty().indexOf(advisor)).name)){
            student.getAdvisor().removeAdvisee(student);
            student.changeAdvisor(university.getFaculty().get(university.getFaculty().indexOf(advisor)));
             university.getFaculty().get(university.getFaculty().indexOf(advisor)).addAdvisee(student);
         }
         else {
             System.out.println("No Professor found");
         }
         StudentMenu(student);
     }
}
