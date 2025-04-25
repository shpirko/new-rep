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


    
}
