package bsu.comp152;
public class Main {
    public static void main(String[] args) {
        Professor p1 = new Professor("Jessi", "Science");
        Student s1 = new Student("Kush", p1, 1);
        s1.addClassToTranscript(4,4.0);
        System.out.println(s1.toString());
        s1.addClassToTranscript(8, 2.0);
        System.out.println(s1.toString());
    }
}
