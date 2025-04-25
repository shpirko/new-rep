package ShakedShpirkoAndNoaSchwarz;

public class Department {
    private String name; 
    private int numOfStudents;
    Lecturer[] lecturers; // Array of Lecturer objects
    private int numOfLecturers; // Number of lecturers in the department

    public Department(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    

}
