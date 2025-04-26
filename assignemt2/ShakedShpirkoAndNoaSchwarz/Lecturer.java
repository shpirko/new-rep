package ShakedShpirkoAndNoaSchwarz;

public class Lecturer {
    public enum DegreeLevel {
        BACHELOR("Bachelor"), 
        MASTER("Master"), 
        PHD("PhD"), 
        PROFESSOR("Professor");
    
        private final String displayName;  // Field
    
        DegreeLevel(String displayName) {  // Constructor
            this.displayName = displayName;
        }
    
        public String getDisplayName() {   // Method
            return displayName;
        }
    }


    private DegreeLevel degreeLevel; // Field
    private String name; 
    private String id;
    private String degreeName;
    private int salary;
    private Department department;
    private Committee[] committees;

    public Lecturer(String name, String id, String degreeName, Lecturer.DegreeLevel degreeLevel, int salary) {
        this.name = name;
        this.id = id;
        this.degreeName = degreeName;
        this.degreeLevel = degreeLevel;
        this.salary = salary;
        this.department = null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDegreeName() {
        return degreeName;
    }

    public void setDegreeName(String degreeName) {
        this.degreeName = degreeName;
    }

    public DegreeLevel getDegreeLevel() {
        return degreeLevel;
    }

    public void setDegreeLevel(DegreeLevel degreeLevel) {
        this.degreeLevel = degreeLevel;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Committee[] getCommittees() {
        return committees;
    }

    public void setCommittees(Committee[] committees) {
        this.committees = committees;
    }

    
}
