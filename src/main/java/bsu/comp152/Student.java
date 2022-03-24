package bsu.comp152;

public class Student{
    int studentID;
    String name;
    int numberOfCredits;
    double gpa;
    Professor advisor;

    public Student(String studentName, Professor initialAdvisor, int id) {
        name = studentName;
        advisor = initialAdvisor;
        studentID = id;
        gpa = 0;
        numberOfCredits = 0;
    }

    public int getStudentID() {
        return studentID;
    }

    public String getName() {
        return name;
    }

    public int getCreditHours() {
        return numberOfCredits;
    }

    public double getGPA() {
        return gpa;
    }

    public Professor getAdvisor() {
        return advisor;
    }

    public void changeAdvisor(Professor newAdvisor) {
        advisor = newAdvisor;
    }

    public void addClassToTranscript(int credits, double grade) {
        double points =  credits * grade;
        gpa = points/credits;


    }
}
