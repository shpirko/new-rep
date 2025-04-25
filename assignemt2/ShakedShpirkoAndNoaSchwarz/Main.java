package ShakedShpirkoAndNoaSchwarz;
import java.util.Scanner;

import ShakedShpirkoAndNoaSchwarz.Lecturer.DegreeLevel;
public class Main {
    private static final String[] MENU = {
        "Exit Program",
        "Add Lecturer",
        "Add Committee",
        "Add Department",
        "Update Chair of Committee",
        "Remove Lecturer from Committee",
        "Assign Lecturer to Committee",
        "Assign Lecturer to Department",
        "Show Average Salary of All Lecturers",
        "Show Average Salary of Lecturers in Department",
        "Show All Lecturers Info",
        // Add more options
    };
    
    private static Scanner s;
    private static int userChosenNum;
    Manager manager;


    private int showMenu(Scanner s) {
        System.out.println("\n====== Menu =======");
        for (int i = 0; i < MENU.length; i++) {
            System.out.println(i + ". " + MENU[i]);
        }
        System.out.println("Please select an action : ");
        return s.nextInt();
    }

    private void run() {
        do {
            userChosenNum = showMenu(s);
            switch (userChosenNum) {
                case 0 -> System.out.println("Exiting program");
                case 1 -> addLecturer();
                case 2 -> addCommittee();
                case 3 -> addDepartment();
                /*case 4 -> updateChairOfCommittee();
                case 5 -> removeLecturerFromCommittee();
                case 6 -> asignLecturerToCommittee();
                case 7 -> asignLecturerToDepartment();
                case 8 -> showAverageSalaryOfAllLecturers();
                case 9 -> showAverageSalaryOfLecturersInDepartment();
                case 10 -> showAllLecturersInfo();
*/                default -> System.out.println("Incorrect input, please try again");
            }
        } while (userChosenNum != 0);
    }


    public void main(String[] args) {
        // Shaked Shpirko and Noa Schwarz
        // 315142372 and 212840516
        s = new Scanner(System.in);
        System.out.println("Welcome to the system! please enter a college name: ");
        Manager manager = new Manager(s.nextLine());
        run(); // Start the program
        s.close(); // Close the scanner to prevent resource leaks
        
    }

    private void addLecturer() {
        System.out.println("Enter lecturer name: ");
        String name = s.nextLine();
        if(manager.isExistLecturer(name)){
            System.out.println("\nLecturer name already exists in the system");
            System.out.println("press 1 to change the Lecturer name or 2 to return to menu");;
            if (s.nextInt() == 1) {
                addLecturer ();
            }
        }
        else{
            System.out.println("Enter lecturer ID: ");
            String id = s.nextLine();
            System.out.println("Enter degree name");
            String degreename = s.nextLine();
            System.out.println("Choose degree level by number: 1. Bachelor 2. Master 3. PhD 4. Professor");
            int degreeLevel = s.nextInt();
            s.nextLine();
            DegreeLevel elevel = null;
            switch (degreeLevel) {
                case 1 -> elevel = DegreeLevel.BACHELOR;
                case 2 -> elevel = DegreeLevel.MASTER;
                case 3 -> elevel = DegreeLevel.PHD;
                case 4 -> elevel = DegreeLevel.PROFESSOR;
                default -> System.out.println("Invalid number");
            }
            System.out.println("Enter salary");
            int salary = s.nextInt();
            s.nextLine();

            Lecturer newLecturer = new Lecturer(name, id, degreename, elevel, salary);
            manager.addLecturer(newLecturer);
        }
        
    }

    private void addCommittee(){

    }

    private void addDepartment(){

    }


}
