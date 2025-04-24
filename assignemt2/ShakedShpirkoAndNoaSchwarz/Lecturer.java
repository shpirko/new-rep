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
    

}
