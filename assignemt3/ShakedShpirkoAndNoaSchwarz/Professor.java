package ShakedShpirkoAndNoaSchwarz;

public class Professor extends Doctor {
    private String nameOfInstitution; 
    private String[] PublishedPapers; 
    private int numOfPapers; 

    public Professor (String name, String id, String degreeName, DegreeLevel degreeLevel, int salary) {
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
        sb.append(super.toString()).append("Name of Institution: ").append(nameOfInstitution);
        sb.append("\n");
        return sb.toString();
    }
    
    public String getNameOfInstitution() {
        return nameOfInstitution;
    }

    
    public void setNameOfInstitution(String nameOfInstitution) {
        this.nameOfInstitution = nameOfInstitution;
    }



    


}
