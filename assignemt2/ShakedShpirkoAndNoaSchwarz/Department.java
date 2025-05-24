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
        if(numOfLecturers == 0) {
            return "Department: " + name + ", Number of Lecturers: " + numOfLecturers + ", Lecturers: null";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Department: ").append(name).append(", Number of Lecturers: ").append(numOfLecturers).append(", Lecturers: ");
        for (int i = 0; i < numOfLecturers; i++) {
            sb.append(lecturers[i].getName());
            if (i < numOfLecturers - 1) {
                sb.append(", ");
            }
        }
        return sb.toString();
    }

    
    public void tostring() {
        System.out.println("name: " + name);
        System.out.println("numOfLecturers: " + numOfLecturers);
        if (lecturers != null) {
            System.out.println("lecturers: ");
            for(int i = 0; i < numOfLecturers; i++) {
                System.out.println(lecturers[i].getName());
            }
        } else {
            System.out.println("lecturers: null");
        }
        System.out.println("--------------------------------------------------"); 
        
    
    }


}
