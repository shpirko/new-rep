package ShakedShpirkoAndNoaSchwarz;

public class Lecturer {
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
    protected int numOfCommittees; // Number of committees the lecturer is in
    protected Committee[] committees;

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

    public int getNumOfCommittees() {
        return numOfCommittees;
    }

    public void setNumOfCommittees(int numOfCommittees) {
        this.numOfCommittees = numOfCommittees;
    }

    public Committee[] getCommittees() {
        return committees;
    }

    public void setCommittees(Committee[] committees) {
        this.committees = committees;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Lecturer: ").append(name).append(", ID: ").append(id).append(", Degree Name: ").append(degreeName)
                .append(", Degree Level: ").append(degreeLevel.getDisplayName()).append(", Salary: ").append(salary)
                .append(", Department: ").append(department != null ? department.getName() : "null")
                .append(", Number of Committees: ").append(numOfCommittees).append(", Committees: ");
        if (committees != null) {
            for (int i = 0; i < numOfCommittees; i++) {
                sb.append(committees[i].getName());
                if (i < numOfCommittees - 1) {
                    sb.append(", ");
                }
            }
        } else {
            sb.append("null");
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
                this.salary == other.salary && this.department.equals(other.department) &&
                this.numOfCommittees == other.numOfCommittees && this.committees.equals(other.committees);
    }
    
    public void tostring() {
        System.out.println("name: " + name);
        System.out.println("id: " + id);
        System.out.println("degreeName: " + degreeName);
        System.out.println("degreeLevel: " + degreeLevel.getDisplayName());
        System.out.println("salary: " + salary);
        if (department != null) {
            System.out.println("department: " + department.getName());
        } else {
            System.out.println("department: null");
        }
        System.out.println("numOfCommittees: " + numOfCommittees);
        if (committees != null) {
            System.out.println("committees: ");
            for(int i = 0; i < numOfCommittees; i++) {
                System.out.println(committees[i].getName());
            }
        } else {
            System.out.println("committees: null");
        }
        System.out.println("--------------------------------------------------");

    }

    



    
   
}
