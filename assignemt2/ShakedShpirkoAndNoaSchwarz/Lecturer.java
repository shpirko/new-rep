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
    private Commitee[] commitees;

    public Lecturer(String name, String id, String degreeName, Lecturer.DegreeLevel degreeLevel, int salary) {
        this.degreeLevel = degreeLevel;
        this.name = name;
        this.id = id;
        this.degreeName = degreeName;
        this.salary = salary;
    }
    

}
