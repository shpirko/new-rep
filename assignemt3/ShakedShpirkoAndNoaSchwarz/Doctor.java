package ShakedShpirkoAndNoaSchwarz;
public class Doctor extends Lecturer implements Comparable{
    private String[] PublishedPapers; // Array of published papers
    private int numOfPapers; // Number of papers published by the doctor
    
    public Doctor (String name, String id, String degreeName, DegreeLevel degreeLevel, int salary) {
        super(name, id, degreeName, degreeLevel, salary);
        
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("Number of Published Papers: ").append(numOfPapers).append("\n");
        sb.append("Published Papers: ").append("\n");
        if (numOfPapers > 0) {
            sb.append("[");
            for (int i = 0; i < numOfPapers; i++) {
                sb.append(PublishedPapers[i]);
                if (i < numOfPapers - 1) {
                    sb.append(", ");
                }
            }
            sb.append("]");
        } else {
            sb.append("null");
        }
        sb.append("\n");
        return sb.toString();
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

    @Override
    public int compareTo(Object o) {
            Doctor otherDoctor = (Doctor) o;
            return Integer.compare(this.numOfPapers, otherDoctor.numOfPapers); 
    }

    public String[] getPublishedPapers() {
        return PublishedPapers;
    }

    public int getNumOfPapers() {
        return numOfPapers;
    }

    public void setPublishedPapers(String[] publishedPapers) {
        PublishedPapers = publishedPapers;
    }


    public void setNumOfPapers(int numOfPapers) {
        this.numOfPapers = numOfPapers;
    }

    
}


