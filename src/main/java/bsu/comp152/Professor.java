package bsu.comp152;

import java.util.ArrayList;

public class Professor{  ArrayList<Student> adviseeList;
    String name;
    String department;
    public Professor(String name, String department) {
        this.name = name;
        this.department = department;
        adviseeList = new ArrayList<>();
    }

    public void addAdvisee(Student advisee) {
        adviseeList.add(advisee);
    }

    public void removeAdvisee(Student advisee) {
        adviseeList.remove(advisee);
    }

    public ArrayList<Student> getAdviseeList() {
        return adviseeList;
    }

    public String getName() {
        return name;
    }

    public String toString() {
        String output = "";
        for (int i = 0; i < adviseeList.size(); i++){
            output += adviseeList.get(i).getName() + " ";
        }
        return "Professor's name: " + name + "\n" + "Department: " + department + "\n" + "Advisee List: " + output;
    }
}
