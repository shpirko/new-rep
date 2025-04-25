package ShakedShpirkoAndNoaSchwarz;

public class Manager {
    private int userChosenNum;
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


    private static boolean isExist(String name, Committee[] arr, int size) {
        for (int i = 0; i < size; i++) {
            if (arr[i].getName().equals(name))
                return true;
        }
        return false;
    } 


    private static boolean isExist(String name, Department[] arr, int size) {
        for (int i = 0; i < size; i++) {
            if (arr[i].getName().equals(name))
                return true;
        }
        return false;
    } 




    

}
