package ShakedShpirkoAndNoaSchwarz;

import java.util.ArrayList;

import ShakedShpirkoAndNoaSchwarz.Lecturer.DegreeLevel;
import ShakedShpirkoAndNoaSchwarz.Committee.DegreeType;

public class Manager {
    private String collegeName;
    private ArrayList<Lecturer> lecturers;
    private ArrayList<Department> departments;
    private ArrayList<Committee> committees;
    

    public Manager(String collegeName) {
        this.collegeName = collegeName;
        this.lecturers = new ArrayList<Lecturer>();
        this.departments = new ArrayList<Department>();
        this.committees = new ArrayList<Committee>(); 
        
    }

   public void isLecturerInDepartment(Lecturer lecturer, Department department) throws LecturrerInDepartmentException {
        if(department.equals(lecturer.getDepartment())) {
            throw new LecturrerInDepartmentException("Lecturer " + lecturer.getName() + " is already in department " + department.getName() + ".");
        }
        
    }
    
    public void isLecturrerInCommittee(Lecturer lecturer, Committee committee) throws LecturrerInCommitteeException {
        if(!lecturer.getCommittees().isEmpty() && lecturer.getCommittees().contains(committee)) {
            throw new LecturrerInCommitteeException("Lecturer " + lecturer.getName() + " is already in committee " + committee.getName() + ".");
        }
        
    }

    public void isLecturrerNotInCommittee(Lecturer lecturer, Committee committee) throws LecturrerNotInCommitteeException {
        if(committee.getMembers().isEmpty() && !committee.getMembers().contains(lecturer)){
            throw new LecturrerNotInCommitteeException("Lecturer " + lecturer.getName() + " is not in committee " + committee.getName() + ".");
        }
    }

    public void removeLecturerFromCommittee(Lecturer lecturer, Committee committee) {
        lecturer.getCommittees().remove(committee);
        committee.getMembers().remove(lecturer);
    }
    
    public void updateChairOfCommittee(Committee committee, Lecturer newChair) {
        committee.setChair(newChair);
    }
    
    public void removeLecturerFromDepartment(Lecturer lecturer, Department department) {
        
        lecturer.setDepartment(null);
        department.getLecturers().remove(lecturer);
    }
 
    public void asignLecturerToDepartment (Lecturer lecturer, Department department) {
        if(lecturer.getDepartment() != null){
            removeLecturerFromDepartment(lecturer, lecturer.getDepartment());
        }
        lecturer.setDepartment(department);
        department.addLecturer(lecturer);
        
    }

    public void asignLecturerToCommittee(Lecturer lecturer, Committee committee) {
        lecturer.addCommittee(committee);
        committee.addMember(lecturer); 
    }

    public void createLecturer(String name, String id, String degreeName, Lecturer.DegreeLevel degreeLevel, int salary){
        if (degreeLevel.equals(Lecturer.DegreeLevel.PHD)) {
            Doctor newLecturer = new Doctor(name, id, degreeName, degreeLevel, salary);
            lecturers.add(newLecturer);
            return;
        }
        if (degreeLevel.equals(Lecturer.DegreeLevel.PROFESSOR)) {
            Professor newLecturer = new Professor(name, id, degreeName, degreeLevel, salary);
            lecturers.add(newLecturer);
            return;     
        }

        Lecturer lecturer = new Lecturer(name, id, degreeName, degreeLevel, salary);
        lecturers.add(lecturer);
        
    }
   
    

    public void isExistLecturer(String name) throws LecturrerExistException {
        for (Lecturer lecturer : lecturers) {
            if (lecturer.getName().equals(name)) {
                throw new LecturrerExistException("Lecturer with name " + name + " already exists.");
            }
        }
        
    }

    public void isNotExistLecturer(String name) throws LecturerNotExistException {
        for (Lecturer lecturer : lecturers) {
            if (lecturer.getName().equals(name)) {
                return; // Lecturer exists
            }
        }
        throw new LecturerNotExistException("Lecturer with name " + name + " does not exist.");
    }

    public Lecturer getLecturerByName(String name) {
        for (Lecturer lecturer : lecturers) {
            if (lecturer.getName().equals(name)) {
                return lecturer; // Lecturer found
            }
        }
        return null;
    }

    public String calcAvgSalary() {
        if (lecturers.isEmpty()) {
            return "No lecturers in the system.";
        }
        float sum = 0;
        for (Lecturer lecturer : lecturers) {
            sum += lecturer.getSalary();
        }
        float avg = sum / lecturers.size();
        return String.format("Average Salary of Lecturers: %.2f", avg);
    }
    
    public String LecturersInfo() {
        if (lecturers.isEmpty()) {
            return "There are no lecturers in the system.";
        }
        StringBuilder info = new StringBuilder();
        for (Lecturer lecturer : lecturers) {
            info.append(lecturer.toString()).append("\n");
        }
        return info.toString();
    }

    public void createDepartment(String name){
        Department newDepartment = new Department(name);
        departments.add(newDepartment);
    }

    
    
    public void isExistDepartment(String name) throws DepartmentExistException {
        for (Department department : departments) {
            if (department.getName().equals(name)) {
                throw new DepartmentExistException("Department with name " + name + " already exists.");
            }
        }
    }
    
    public void isNotExistDepartment(String name) throws DepartmentNotExistException {
        for (Department department : departments) {
            if (department.getName().equals(name)) {
                return; // Department exists
            }
        }
        throw new DepartmentNotExistException("Department with name " + name + " does not exist.");
    }
    
    public Department getDepartmentByName(String name) {
        for (Department department : departments) {
            if (department.getName().equals(name)) {
                return department; // Department found
            }
        }
        return null;
    }   

    public String calcAvgDep(Department department) {
        if (department.getLecturers().isEmpty()) {
            return "No lecturers in the department " + department.getName() + ".";
        }
        float sum = 0;
        for (Lecturer lecturer : department.getLecturers()) {
            sum += lecturer.getSalary();
        }
        float avg = sum / department.getLecturers().size();
        return String.format("Average Salary of Lecturers in Department %s: %.2f", department.getName(), avg);
    }

    public void createCommittee(String name, Lecturer chair, DegreeType degreeType){
        Committee newCommittee = new Committee(name,chair, degreeType);
        committees.add(newCommittee);
    }


    public void isExistCommittee(String name) throws CommitteeExistException {
        for (Committee committee : committees) {
            if (committee.getName().equals(name)) {
                throw new CommitteeExistException("Committee with name " + name + " already exists.");
            }
        }
    }

    public void isNotExistCommittee(String name) throws CommitteeNotExistException {
        for (Committee committee : committees) {
            if (committee.getName().equals(name)) {
                return; // Committee exists
            }
        }
        throw new CommitteeNotExistException("Committee with name " + name + " does not exist.");
    }

    public Committee getCommitteeByName(String name) {
        for (Committee committee : committees) {
            if (committee.getName().equals(name)) {
                return committee; // Committee found
            }
        }
        return null;    
    }

    public String committeesInfo(){
        if (committees.isEmpty()) {
            return "There are no committees in the system.";
        }
        StringBuilder info = new StringBuilder();
        for (Committee committee : committees) {
            info.append(committee.toString()).append("\n");
        }
        return info.toString();
    }
    
    public void notDoc(Lecturer lecturer) throws notDoctorException
    {
        if(!(lecturer instanceof Doctor))
            throw new notDoctorException("Lecturer " + lecturer.getName() + " is not a  Doctor.");
    }


    public void isChairAlreadyChairOfCommittee(Lecturer chair, Committee com) throws LecturrerAlreadyCairException {
        if (com.getChair().equals(chair)) 
            throw new LecturrerAlreadyCairException("Lecturer " + chair.getName() + " is already the chairman of committee " + com.getName() + ".");
            
    }

    public String CompareDoctorsbyPapers(Doctor lecturer1, Doctor lecturer2) {
        if (lecturer1.compareTo(lecturer2) > 0) 
            return lecturer1.getName() + " has more papers than " + lecturer2.getName();

        if (lecturer1.compareTo(lecturer2) < 0) 
            return lecturer2.getName() + " has more papers than " + lecturer1.getName();

        return lecturer1.getName() + " and " + lecturer2.getName() + " have the same number of papers.";
        
    }

    public String compareByMembers(Committee com1, Committee com2) {
        CompareByCommitteeMembers comparator = new CompareByCommitteeMembers();
        if (comparator.compare(com1, com2) > 0) {
            return com1.getName() + " has more members than " + com2.getName();
        } else if (comparator.compare(com1, com2) < 0) {
            return com2.getName() + " has more members than " + com1.getName();
        } else {
            return com1.getName() + " and " + com2.getName() + " have the same number of members.";
        }
    }

    public String compareByPapers(Committee com1, Committee com2) {
        CompareByCommitteePapers comparator = new CompareByCommitteePapers();

        if (comparator.compare(com1, com2) > 0) {
            return com1.getName() + " has more papers than " + com2.getName();
        } else if (comparator.compare(com1, com2) < 0) {
            return com2.getName() + " has more papers than " + com1.getName();
        } else {
            return com1.getName() + " and " + com2.getName() + " have the same number of papers.";
        }
    }

    public void duplicateCommittee(Committee committee) throws CloneNotSupportedException{
        Committee clonedCommittee = committee.clone();
        committees.add(clonedCommittee);
        clonedCommittee.setName(clonedCommittee.getName() + "-new");
        for (Lecturer member : clonedCommittee.getMembers()) {
            member.addCommittee(clonedCommittee);
        }
    }

    public void isLecturerTheSameDegreeType(Lecturer lect, Committee commmittee) throws NotSameDegreeTypeException {
        if (lect.getDegreeLevel().getDisplayName() != commmittee.getDegreeType().getDisplayName()) {
            throw new IllegalArgumentException("Lecturer " + lect.getName() + " does not match the degree type of committee " + commmittee.getName() + ".");
        }
    }
}

    

