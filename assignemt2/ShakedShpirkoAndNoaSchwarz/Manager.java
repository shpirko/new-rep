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

    public boolean isLecturrerInCommittee(Lecturer lecturer, Committee committee) {
        for (int i = 0; i < committee.getNumOfMembers(); i++) {
            if (committee.getMembers()[i].getName().equals(lecturer.getName()))
                return true;
        }
        return false;
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
    
    public void removeLecturerFromDepartment(Lecturer lecturer, Department department) {
        if (department != null) {
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
    }
    public void asignLecturerToDepartment (Lecturer lecturer, Department department) {
        lecturer.setDepartment(department);
        if (department.getNumOfLecturers() == department.getLecturers().length) 
            department.setLecturers(copyArray(department.getLecturers(), department.getNumOfLecturers() ,department.getNumOfLecturers() == 0 ? 2 : department.getNumOfLecturers() * 2));
        department.getLecturers()[department.getNumOfLecturers()] = lecturer;
        
    }

    public void asignLecturerToCommittee(Lecturer lecturer, Committee committee) {
        if (lecturer.getNumOfCommittees() == lecturer.getCommittees().length) 
            lecturer.setCommittees(copyArray(lecturer.getCommittees(), lecturer.getNumOfCommittees() ,lecturer.getNumOfCommittees() == 0 ? 2 : lecturer.getNumOfCommittees() * 2));
        lecturer.getCommittees()[lecturer.getNumOfCommittees()] = committee;
        lecturer.setNumOfCommittees(lecturer.getNumOfCommittees() + 1);
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


    public boolean isExistLecturer(String name) {
        for (int i = 0; i < numOfLecturers; i++) {
            if (lecturers[i].getName().equals(name))
                return true;
        }
        return false;
    }


    public Lecturer getLecturerByName(String name) {
        for (int i = 0; i < numOfLecturers; i++) {
            if (lecturers[i].getName().equals(name))
                return lecturers[i];
        }
        return null;
    }

    public int calcAvgSalary() {
        int sum = 0;
        if (numOfLecturers == 0) {
            System.out.println("No lecturers in the system yet.");
            return 0;
        }
        for (int i = 0; i < numOfLecturers; i++) {
            sum += lecturers[i].getSalary();
        }
        return sum / numOfLecturers;
    }

    public void lucturersInfo(){
        for (int i = 0; i < numOfLecturers; i++){
            System.out.println("Lucturer: " + lecturers[i].getName());
            System.out.println("ID: " + lecturers[i].getId());
            System.out.println("Degree name: " + lecturers[i].getDegreeName());
            System.out.println("Degree level: " + lecturers[i].getDegreeLevel());
            System.out.println("Salary: " + lecturers[i].getSalary());
            System.out.println("Departmnet: " + lecturers[i].getDepartment());
            System.out.println("Committiees: " + lecturers[i].getCommittees()+ "\n");
        }
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
    

    public boolean isExistDepartment(String name) {
        for (int i = 0; i < numOfDepartments; i++) {
            if (departments[i].getName().equals(name))
                return true;
        }
        return false;
    }



    public Department getDepartmentByName(String name) {
        for (int i = 0; i < numOfDepartments; i++) {
            if (departments[i].getName().equals(name))
                return departments[i];
        }
        return null;
    }   


    public int calcAvgDep(String depName) {
        int sum = 0;
        Department department = getDepartmentByName(depName);
        Lecturer[] lecturers = department.getLecturers();
        for (int i = 0; i < department.getNumOfLecturers(); i++) { 
                sum += lecturers[i].getSalary();
            
        }
        if (sum == 0)
            return 0;
        return sum / department.getNumOfLecturers();
        
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

    public boolean isExistCommittee(String name) {
        for (int i = 0; i < numOfCommittees; i++) {
            if (committees[i].getName().equals(name))
                return true;
        }
        return false;
    }

    public Committee getCommitteeByName(String name) {
        for (int i = 0; i < numOfCommittees; i++) {
            if (committees[i].getName().equals(name))
                return committees[i];
        }
        return null;    
    
    }

    public void committeesInfo(){
        for (int i = 0; i < numOfCommittees; i++){
           System.out.println("Committee name: " + committees[i].getName()); 
           System.out.println("Chairman name: " + committees[i].getChairName());
           System.out.println("Members: " + committees[i].getMembers());
        }
    }

    
    public void updateChairOfCommittee(Committee commiitte, Lecturer newChair) {
        commiitte.setChair(newChair);
    }

    

    

    

    
    
}
