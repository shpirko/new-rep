package ShakedShpirkoAndNoaSchwarz;

public class Manager {
    private int userChosenNum;
    private String collegeName;
    private Lecturer[] lecturers; // Array of Lecturer objects
    private int numOfLecturers; // Number of lecturers in the college
    private Department[] departments; // Array of Department objects
    private int numOfDepartments; // Number of departments in the college
    private Commitee[] committees; // Array of Commitee objects
    private int numOfCommittees; // Number of committees in the college

    

    public Manager(String collegeName) {
        this.collegeName = collegeName;
    }

    public void addLecturer(Lecturer lecturer) {
        
    }

    private static boolean isExsit(Object name, Object[] arr, int size) {
        for (int i = 0; i < size; i++) {
            if (arr[i].equals(name))
                return true;
        }
        return false;
    } 

    



    

}
