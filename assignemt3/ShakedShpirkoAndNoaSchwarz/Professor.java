package ShakedShpirkoAndNoaSchwarz;

public class Professor extends Doctor {
    private String nameOfInstitution; 

    public Professor(String name, String id, String degreeName, DegreeLevel degreeLevel, int salary) {
        super(name, id, degreeName, degreeLevel, salary);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Professor professor = (Professor) obj;
        return super.equals(obj) && 
               (nameOfInstitution != null ? nameOfInstitution.equals(professor.nameOfInstitution) : professor.nameOfInstitution == null);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("Name of Institution: ").append(nameOfInstitution != null ? nameOfInstitution : "null").append("\n");
        return sb.toString();
    }
    
    public String getNameOfInstitution() {
        return nameOfInstitution;
    }

    public void setNameOfInstitution(String nameOfInstitution) {
        this.nameOfInstitution = nameOfInstitution;
    }
}
