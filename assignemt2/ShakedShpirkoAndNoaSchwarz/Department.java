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

    public int getNumOfLecturers() {
        return numOfLecturers;
    }

    public void setNumOfMembers(int numOfLecturers) {
        this.numOfLecturers = numOfLecturers;
    }

    public Lecturer[] getLecturers() {
        return lecturers;
    }

    public void setLecturers(Lecturer[] lecturers) {
        this.lecturers = lecturers;
    }

    @Override
    public String toString() {
    return "Department: " + name;
    }


}
