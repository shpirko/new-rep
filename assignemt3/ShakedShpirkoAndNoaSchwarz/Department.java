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
    StringBuilder sb = new StringBuilder();
    sb.append("name: ").append(name).append("\n");
    sb.append("numOfLecturers: ").append(numOfLecturers).append("\n");
    sb.append("lecturers: ");
    if (lecturers != null && numOfLecturers > 0) {
        for (int i = 0; i < numOfLecturers; i++) {
            sb.append(lecturers[i].getName());
            if (i < numOfLecturers - 1) {
                sb.append(", ");
            }
        }
        sb.append("\n");
    } else {
        sb.append("null\n");
    }
    sb.append("--------------------------------------------------");
    return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Department department = (Department) obj;
        return name.equals(department.name);
    }

}
