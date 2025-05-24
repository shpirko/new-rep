package ShakedShpirkoAndNoaSchwarz;
public class Doctor extends Lecturer {
    private String[] PublishedPapers; // Array of published papers
    private int numOfPapers; // Number of papers published by the doctor
    
    public Doctor (String name, String id, String degreeName, DegreeLevel degreeLevel, int salary) {
        super(name, id, degreeName, degreeLevel, salary);
        
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Doctor doctor = (Doctor) obj;
        return super.equals(obj) && numOfPapers == doctor.numOfPapers;
    }
}


