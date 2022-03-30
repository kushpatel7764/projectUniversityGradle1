package bsu.comp152;
public class Main {
    public static void main(String[] args) {
       //Student
        System.out.println("------Student------");
        Professor p1 = new Professor("Jessi", "Science");
        Student s1 = new Student("Kush", p1, 1);
        Student s2 = new Student("Chris", p1, 2);
        Student s3 = new Student("Steve", p1, 3);
        s1.addClassToTranscript(4,4.0);
        System.out.println(s1.toString());
        s1.addClassToTranscript(8, 2.0);
        System.out.println(s1.toString());
        // Professor
        System.out.println("------Professor------");
        p1.addAdvisee(s1);
        p1.addAdvisee(s2);
        p1.addAdvisee(s3);
        System.out.println(p1);
        p1.removeAdvisee(s1);
        System.out.println(p1);
        p1.addAdvisee(s1);
        p1.removeAdvisee(s2);
        System.out.println(p1);
    }
}
