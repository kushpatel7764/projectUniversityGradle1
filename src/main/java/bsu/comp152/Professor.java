package bsu.comp152;

import java.util.ArrayList;

public class Professor{
    ArrayList<Student> adviseeList;
    String name;
    String department;
    public Professor(String name, String department) {
        this.name = name;
        this.department = department;
        adviseeList = new ArrayList<Student>();
    }

    public void addAdvisee(Student advisee) {
        adviseeList.add(advisee);
    }

    public void removeAdvisee(Student advisee) {
        adviseeList.remove(advisee);
    }

    public ArrayList<Student> getAdviseeList() {
        return null;
    }

    public String getName() {
        return null;
    }

}
