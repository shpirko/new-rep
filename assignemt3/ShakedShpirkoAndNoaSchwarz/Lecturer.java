package ShakedShpirkoAndNoaSchwarz;

import java.util.ArrayList;

public class Lecturer implements Cloneable{
    public enum DegreeLevel {
        BACHELOR("Bachelor"), 
        MASTER("Master"), 
        PHD("PhD"), 
        PROFESSOR("Professor");
    
        private final String displayName;  
    
        DegreeLevel(String displayName) {  // Constructor
            this.displayName = displayName;
        }
    
        public String getDisplayName() {   // Method
            return displayName;
        }

        public boolean equals(DegreeLevel other) { // Method
            if (this.displayName.equals(other.displayName)) {
                return true;
            }
            return false;
        }
    }

    protected DegreeLevel degreeLevel; // Field
    protected String name; 
    protected String id;
    protected String degreeName;
    protected int salary;
    protected Department department;
    protected ArrayList<Committee> committees = new ArrayList<>();

    public Lecturer(String name, String id, String degreeName, Lecturer.DegreeLevel degreeLevel, int salary) {
        this.name = name;
        this.id = id;
        this.degreeName = degreeName;
        this.degreeLevel = degreeLevel;
        this.salary = salary;
        this.department = null;
        this.committees = new ArrayList<>();
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

    public int getNumOfCommittees() {
        return committees.size();
    }

    public ArrayList<Committee> getCommittees() {
        return committees;
    }

    public void setCommittees(ArrayList<Committee> committees) {
        this.committees = committees;
    }

    public void addCommittee(Committee committee) {
        if (!committees.contains(committee)) {
            committees.add(committee);
        }
    }

    public void removeCommittee(Committee committee) {
        committees.remove(committee);
    }

    @Override
    protected Lecturer clone() throws CloneNotSupportedException{
        Lecturer cloned = (Lecturer) super.clone();
        cloned.committees = new ArrayList<>(this.committees);
        return cloned;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("name: ").append(name).append("\n");
        sb.append("ID: ").append(id).append("\n");
        sb.append("degreeName: ").append(degreeName).append("\n");
        sb.append("degreeLevel: ").append(degreeLevel.getDisplayName()).append("\n");
        sb.append("salary: ").append(salary).append("\n");
        sb.append("department: ").append(department != null ? department.getName() : "null").append("\n");
        sb.append("numOfCommittees: ").append(getNumOfCommittees()).append("\n");
        sb.append("committees: ");
        if (committees != null && !committees.isEmpty()) {
            for (int i = 0; i < committees.size(); i++) {
                sb.append(committees.get(i).getName());
                if (i < committees.size() - 1) {
                    sb.append(", ");
                }
            }
            sb.append("\n");
        } else {
            sb.append("null\n");
        }
        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || this.getClass() != obj.getClass()) return false;
        Lecturer other = (Lecturer) obj;
        return this.name.equals(other.name) && this.id.equals(other.id) &&
                this.degreeName.equals(other.degreeName) && this.degreeLevel.equals(other.degreeLevel) &&
                this.salary == other.salary && 
                ((this.department == null && other.department == null) || 
                 (this.department != null && this.department.equals(other.department))) &&
                this.committees.equals(other.committees);
    }
}
