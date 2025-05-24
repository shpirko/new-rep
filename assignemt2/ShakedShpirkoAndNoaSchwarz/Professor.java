package ShakedShpirkoAndNoaSchwarz;

public class Professor extends Lecturer {
    private String nameOfInstitution; 
    private String[] PublishedPapers; 
    private int numOfPapers; 

    public Professor(String name, String id, String degreeName, DegreeLevel degreeLevel, int salary) {
        super(name, id, degreeName, degreeLevel, salary);
        
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Professor professor = (Professor) obj;
        return super.equals(obj) && nameOfInstitution.equals(professor.nameOfInstitution) && numOfPapers == professor.numOfPapers;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Professor: ").append(super.toString()).append(", Name of Institution: ").append(nameOfInstitution)
                .append(", Number of Papers: ").append(numOfPapers).append(", Published Papers: ");
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
        return sb.toString();
    }

    


}
