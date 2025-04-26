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
    private static Manager manager;


    private static int showMenu(Scanner s) {
        System.out.println("\n====== Menu =======");
        for (int i = 0; i < MENU.length; i++) {
            System.out.println(i + ". " + MENU[i]);
        }
        System.out.println("Please select an action : ");
        return s.nextInt();
        
    }

    private static void run() {
        do {
            userChosenNum = showMenu(s);
            s.nextLine(); // Consume the newline character left by nextInt()
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


    public static void main(String[] args) {
        /*Main program = new Main();  // Create instance
        program.s = new Scanner(System.in);
        System.out.println("Welcome to the system! please enter a college name: ");
        program.manager = new Manager(program.s.nextLine());
        program.run();  // Call instance method
        program.s.close(); */


        s = new Scanner(System.in);
        System.out.println("Welcome to the system! please enter a college name: ");
        Main.manager = new Manager(s.nextLine());
        run();

        
    }

    private static void addLecturer() {
        System.out.println("Enter lecturer name: ");
        String name = s.nextLine();
        if(manager.isExistLecturer(name)){
            System.out.println("\nLecturer name already exists in the system");
            System.out.println("press 1 to change the Lecturer name or 2 to return to menu");;
            if (s.nextInt() == 1) {
                s.nextLine(); 
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


    private static void addDepartment() {
        System.out.println("Enter department name: ");
        String name = s.nextLine();
        if(manager.isExistDepartment(name)){
            System.out.println("\nDepartment name already exists in the system");
            System.out.println("press 1 to change the Department name or 2 to return to menu");;
            if (s.nextInt() == 1) {
                s.nextLine(); 
                addDepartment ();
                
            }
            
        }
        else{
            Department newDepartment = new Department(name);
            manager.addDepartment(newDepartment);
            System.out.println("Department added successfully!");
        }
        
    }



    private static void addCommittee(){
        System.out.println("Enter committee name: ");
        String name = s.nextLine();
        if(manager.isExistCommittee(name)){
            System.out.println("\nCommittee name already exists in the system");
            System.out.println("press 1 to change the Committee name or 2 to return to menu");;
            if (s.nextInt() == 1) {
                s.nextLine(); 
                addCommittee ();
                
            }
            
        }
        else{
            System.out.println("Enter chairman name: ");
            String chairName = s.nextLine();
            if(!manager.isExistLecturer(chairName))
            {
                System.out.println("Lecturrer does not exist in the system, please add him first");
                System.out.println("press 1 to add lecturrer to do system or 2 to return to menu");;
                if (s.nextInt() == 1) {
                    s.nextLine(); 
                    addLecturer ();
                    
                }
            }
            else{
                Lecturer chair = manager.getLecturerByName(chairName);
                if(chair.getDegreeLevel() == DegreeLevel.BACHELOR || chair.getDegreeLevel() == DegreeLevel.MASTER){
                    System.out.println("Chairman must be at least a PhD degree holder");
                    System.out.println("press 1 to add Committee or 2 to return to menu");  
                    if (s.nextInt() == 1) {
                        s.nextLine();
                        addCommittee();
                        
                    
            }
                }
                else{
                    Committee newCommittee = new Committee(name,chair);
                    manager.addCommittee(newCommittee);
                    System.out.println("Committee added successfully!");
                }
            }
        }
    }

    


}
