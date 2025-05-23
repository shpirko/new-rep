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

    public void addPublishedPaper(String paper) {
        if (numOfPapers == 0) {
            PublishedPapers = new String[2];
        } else {
            String[] newPublishedPapers = new String[numOfPapers + 1];
            System.arraycopy(PublishedPapers, 0, newPublishedPapers, 0, numOfPapers);
            PublishedPapers = newPublishedPapers;
        }
    }
}


