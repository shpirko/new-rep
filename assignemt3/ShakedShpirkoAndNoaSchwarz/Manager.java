package ShakedShpirkoAndNoaSchwarz;

public class Manager {
    private String collegeName;
    private Lecturer[] lecturers; // Array of Lecturer objects
    private int numOfLecturers; // Number of lecturers in the college
    private Department[] departments; // Array of Department objects
    private int numOfDepartments; // Number of departments in the college
    private Committee[] committees; // Array of Commitee objects
    private int numOfCommittees; // Number of committees in the college


    

    public Manager(String collegeName) {
        this.collegeName = collegeName; 
        this.lecturers = new Lecturer[0];
        this.committees = new Committee[0];
        this.departments = new Department[0];
    }

   public void isLecturerInDepartment(Lecturer lecturer, Department department) throws LecturrerInDepartmentException {
        if(department.equals(lecturer.getDepartment())) {
            throw new LecturrerInDepartmentException("Lecturer " + lecturer.getName() + " is already in department " + department.getName() + ".");
        }
        
    }
    
    public void isLecturrerInCommittee(Lecturer lecturer, Committee committee) throws LecturrerInCommitteeException {
        for (int i = 0; i < committee.getNumOfMembers(); i++) {
            if (committee.getMembers()[i].getName().equals(lecturer.getName()))
                throw new LecturrerInCommitteeException("Lecturer " + lecturer.getName() + " is already in committee " + committee.getName() + ".");
        }
        
    }

    public void isLecturrerNotInCommittee(Lecturer lecturer, Committee committee) throws LecturrerNotInCommitteeException {
        for (int i = 0; i < committee.getNumOfMembers(); i++) {
            if (committee.getMembers()[i].getName().equals(lecturer.getName()))
                return;
        }
        throw new LecturrerNotInCommitteeException("Lecturer " + lecturer.getName() + " is not in committee " + committee.getName() + ".");
    }

    public void removeLecturerFromCommittee(Lecturer lec, Committee committee) {
        for (int i = 0; i < committee.getNumOfMembers(); i++) {
            if (committee.getMembers()[i].getName().equals(lec.getName())) {
                // Shift elements to the left to remove the member
                for (int j = i; j < committee.getNumOfMembers() - 1; j++) {
                    committee.getMembers()[j] = committee.getMembers()[j + 1];
                }
                committee.getMembers()[committee.getNumOfMembers() - 1] = null; // Clear the last element
                committee.setNumOfMembers(committee.getNumOfMembers() - 1); // Decrease the number of members in the committee
                break;
            }
        }

        for (int i = 0; i<lec.getNumOfCommittees(); i++){
            if (lec.getCommittees()[i].getName().equals(committee.getName())) {
                // Shift elements to the left to remove the committee
                for (int j = i; j < lec.getNumOfCommittees() - 1; j++) {
                    lec.getCommittees()[j] = lec.getCommittees()[j + 1];
                }
                lec.getCommittees()[lec.getNumOfCommittees() - 1] = null; // Clear the last element
                lec.setNumOfCommittees(lec.getNumOfCommittees() - 1); // Decrease the number of committees the lecturer is in
                break;
            }
        }
    }
    
    public void updateChairOfCommittee(Committee committee, Lecturer newChair) {
        committee.setChair(newChair);
    }
    
    public void removeLecturerFromDepartment(Lecturer lecturer, Department department) {
        
        for (int i = 0; i < department.getNumOfLecturers(); i++) {
            if (department.getLecturers()[i].getName().equals(lecturer.getName())) {
                // Shift elements to the left to remove the lecturer
                for (int j = i; j < department.getNumOfLecturers() - 1; j++) {
                    department.getLecturers()[j] = department.getLecturers()[j + 1];
                }
                department.getLecturers()[department.getNumOfLecturers() - 1] = null; // Clear the last element
                department.setNumOfMembers(department.getNumOfLecturers() - 1); // Decrease the number of lecturers in the department
                break;
            }
        }

        
        
    }
 
    public void asignLecturerToDepartment (Lecturer lecturer, Department department) {
        if(lecturer.getDepartment() != null){
            removeLecturerFromDepartment(lecturer, lecturer.getDepartment());
        }
        lecturer.setDepartment(department);
        if(department.getLecturers() == null){
            department.setLecturers(new Lecturer[0]);
        }
        if (department.getNumOfLecturers() == department.getLecturers().length) 
            department.setLecturers(copyArray(department.getLecturers(), department.getNumOfLecturers() ,department.getNumOfLecturers() == 0 ? 2 : department.getNumOfLecturers() * 2));

        department.getLecturers()[department.getNumOfLecturers()] = lecturer;
        department.setNumOfMembers(department.getNumOfLecturers() + 1);
        
    }

    public void asignLecturerToCommittee(Lecturer lecturer, Committee committee) {
        if(lecturer.getCommittees() == null)
            lecturer.setCommittees(new Committee[0]);

        if (lecturer.getNumOfCommittees() == lecturer.getCommittees().length) 
                lecturer.setCommittees(copyArray(lecturer.getCommittees(), lecturer.getNumOfCommittees() ,lecturer.getNumOfCommittees() == 0 ? 2 : lecturer.getNumOfCommittees() * 2));

        lecturer.getCommittees()[lecturer.getNumOfCommittees()] = committee;
        lecturer.setNumOfCommittees(lecturer.getNumOfCommittees() + 1);

        if (committee.getMembers() == null)
            committee.setMembers(new Lecturer[0]);

        if (committee.getNumOfMembers() == committee.getMembers().length) 
            committee.setMembers(copyArray(committee.getMembers(), committee.getNumOfMembers() ,committee.getNumOfMembers() == 0 ? 2 : committee.getNumOfMembers() * 2));

        committee.getMembers()[committee.getNumOfMembers()] = lecturer;
        committee.setNumOfMembers(committee.getNumOfMembers() + 1);    

    }

    public void createLecturer(String name, String id, String degreeName, Lecturer.DegreeLevel degreeLevel, int salary){
        if (degreeLevel.equals(Lecturer.DegreeLevel.PHD)) {
            Doctor newLecturer = new Doctor(name, id, degreeName, degreeLevel, salary);
            addLecturer(newLecturer);
            return;
        }
        if (degreeLevel.equals(Lecturer.DegreeLevel.PROFESSOR)) {
            Professor newLecturer = new Professor(name, id, degreeName, degreeLevel, salary);
            addLecturer(newLecturer);
            return;     
        }

        Lecturer lecturer = new Lecturer(name, id, degreeName, degreeLevel, salary);
        addLecturer(lecturer);
        
    }
   
    public void addLecturer(Lecturer lecturer) {
        if (numOfLecturers == lecturers.length) 
            lecturers = copyArray(lecturers, numOfLecturers ,numOfLecturers == 0 ? 2 : numOfLecturers * 2);
        lecturers[numOfLecturers] = lecturer;
        numOfLecturers++;
    }

    public Lecturer[] copyArray(Lecturer[] arr, int currentSize, int newSize) {
        Lecturer[] newArr = new Lecturer[newSize];  // Create new array with newSize
        for (int i = 0; i < currentSize; i++) {  // Copy existing elements
            newArr[i] = arr[i];
        }
        return newArr;
    }

    public void isExistLecturer(String name) throws LecturrerExistException {
        for (int i = 0; i < numOfLecturers; i++) {
            if (lecturers[i].getName().equals(name))
                throw new LecturrerExistException("Lecturer with name " + name + " already exists.");
        }
        
    }

    public void isNotExistLecturer(String name) throws LecturerNotExistException {
        for (int i = 0; i < numOfLecturers; i++) {
            if (lecturers[i].getName().equals(name))
                return;
        }
        throw new LecturerNotExistException("Lecturer with name " + name + " does not exist.");
    }

    public Lecturer getLecturerByName(String name) {
        for (int i = 0; i < numOfLecturers; i++) {
            if (lecturers[i].getName().equals(name))
                return lecturers[i];
        }
        return null;
    }

    public String calcAvgSalary() {
        if (numOfLecturers == 0) {
            return "No lecturers in the system.";
        }
        float sum = 0;
        for (int i = 0; i < numOfLecturers; i++) {
            sum += lecturers[i].getSalary();
        }
        float avg = sum / numOfLecturers;
        return String.format("Average Salary of Lecturers: %.2f", avg);
    }
    
    public String LecturersInfo() {
        if (numOfLecturers == 0) {
            return "There are no lecturers in the system.";
        }
        StringBuilder info = new StringBuilder();
        for (int i = 0; i < numOfLecturers; i++) {
            info.append(lecturers[i].toString()).append("\n");
        }
        return info.toString();
    }

    public void createDepartment(String name){
        Department newDepartment = new Department(name);
        addDepartment(newDepartment);
    }

    public void addDepartment(Department department) {
        if (numOfDepartments == departments.length) 
            departments = copyArray(departments, numOfDepartments ,numOfDepartments == 0 ? 2 : numOfDepartments * 2);
        departments[numOfDepartments] = department;
        numOfDepartments++;
     }

    public Department[] copyArray(Department[] arr, int currentSize, int newSize) {
        Department[] newArr = new Department[newSize];  // Create new array with newSize
        for (int i = 0; i < currentSize; i++) {  // Copy existing elements
            newArr[i] = arr[i];
        }
        return newArr;
    }
    
    public void isExistDepartment(String name) throws DepartmentExistException {
        for (int i = 0; i < numOfDepartments; i++) {
            if (departments[i].getName().equals(name))
                throw new DepartmentExistException("Department with name " + name + " already exists.");
        }
    }
    
    public void isNotExistDepartment(String name) throws DepartmentNotExistException {
        for (int i = 0; i < numOfDepartments; i++) {
            if (departments[i].getName().equals(name))
                return;
        }
        throw new DepartmentNotExistException("Department with name " + name + " does not exist.");
    }
    
    public Department getDepartmentByName(String name) {
        for (int i = 0; i < numOfDepartments; i++) {
            if (departments[i].getName().equals(name))
                return departments[i];
        }
        return null;
    }   

    public String calcAvgDep(Department department) {
        if (department.getNumOfLecturers() == 0) {
            return "No lecturers in the department " + department.getName() + ".";
        }
        float sum = 0;
        for (int i = 0; i < department.getNumOfLecturers(); i++) {
            sum += department.getLecturers()[i].getSalary();
        }
        float avg = sum / department.getNumOfLecturers();
        return String.format("Average Salary of Lecturers in Department %s: %.2f", department.getName(), avg);
    }

    public void createCommittee(String name, Lecturer chair){
        Committee newCommittee = new Committee(name,chair);
        addCommittee(newCommittee);
    }

    public void addCommittee(Committee committee) {
        if (numOfCommittees == committees.length) 
            committees = copyArray(committees, numOfCommittees ,numOfCommittees == 0 ? 2 : numOfCommittees * 2);
        committees[numOfCommittees] = committee;
        numOfCommittees++;
    }

    public Committee[] copyArray(Committee[] arr, int currentSize, int newSize) {
        Committee[] newArr = new Committee[newSize];  // Create new array with newSize
        for (int i = 0; i < currentSize; i++) {  // Copy existing elements
            newArr[i] = arr[i];
        }
        return newArr;
    }

    public void isExistCommittee(String name) throws CommitteeExistException {
        for (int i = 0; i < numOfCommittees; i++) {
            if (committees[i].getName().equals(name))
                throw new CommitteeExistException("Committee with name " + name + " already exists.");
        }
    }

    public void isNotExistCommittee(String name) throws CommitteeNotExistException {
        for (int i = 0; i < numOfCommittees; i++) {
            if (committees[i].getName().equals(name))
                return;
        }
        throw new CommitteeNotExistException("Committee with name " + name + " does not exist.");
    }

    public Committee getCommitteeByName(String name) {
        for (int i = 0; i < numOfCommittees; i++) {
            if (committees[i].getName().equals(name))
                return committees[i];
        }
        return null;    
    
    }

    public String committeesInfo(){
        if (numOfCommittees == 0) {
            return "There are no committees in the system.";
        }
        StringBuilder info = new StringBuilder();
        for (int i = 0; i < numOfCommittees; i++) {
            info.append(committees[i].toString()).append("\n");
        }
        return info.toString();
    }
    
    public void notDoc(Lecturer lecturer) throws notDoctorException
    {
        if(!(lecturer instanceof Doctor))
            throw new notDoctorException("Lecturer " + lecturer.getName() + " is not a  Doctor.");
    }

    /*public String allInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("College Name: ").append(collegeName).append("\n");
        sb.append("Number of Lecturers: ").append(numOfLecturers).append("\n");
        sb.append("Lecturers:\n");
        for (int i = 0; i < numOfLecturers; i++) {
            sb.append(lecturers[i].toString()).append("\n");
        }
        sb.append("Number of Departments: ").append(numOfDepartments).append("\n");
        sb.append("Departments:\n");
        for (int i = 0; i < numOfDepartments; i++) {
            sb.append(departments[i].toString()).append("\n");
        }
        sb.append("Number of Committees: ").append(numOfCommittees).append("\n");
        sb.append("Committees:\n");
        for (int i = 0; i < numOfCommittees; i++) {
            sb.append(committees[i].toString()).append("\n");
        }
        return sb.toString();
    }*/

    public void isChairAlreadyChairOfCommittee(Lecturer chair, Committee com) throws LecturrerAlreadyCairException {
        if (com.getChairman().equals(chair)) 
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
        clonedCommittee.setName(committee.getName() + "-new");

        Lecturer clonedChair = clonedCommittee.getChairman();
        Lecturer[] clonedMembers = clonedCommittee.getMembers();

        createCommittee(clonedCommittee.getName(), clonedChair);

        if (clonedMembers != null && clonedMembers.length != 0) {
            for (int i = 0; i < committee.getNumOfMembers(); i++) {
                asignLecturerToCommittee(clonedMembers[i], getCommitteeByName(clonedCommittee.getName()));
            }
        }
    }
}

