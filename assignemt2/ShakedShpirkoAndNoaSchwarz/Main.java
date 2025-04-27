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
        "Show All Committees Info",
        "testing",
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
                case 4 -> updateChairOfCommittee();
                case 5 -> removeLecturerFromCommittee();
                case 6 -> asignLecturerToCommittee();
                case 7 -> asignLecturerToDepartment();
                case 8 -> showAverageSalaryOfAllLecturers();
                case 9 -> showAverageSalaryOfLecturersInDepartment();
                case 10 -> showAllLecturersInfo();
                case 11 -> showAllCommitteesInfo();
                case 12 -> testing();
                default -> System.out.println("Incorrect input, please try again");
            }
        } while (userChosenNum != 0);
    }
    public static void main(String[] args) {
        s = new Scanner(System.in);
        System.out.println("Welcome to the system! please enter a college name: ");
        Main.manager = new Manager(s.nextLine());
        run();
        s.close();
    }

    private static void testing(){
        Lecturer newLecturer = new Lecturer("stav", "1", "degreename", DegreeLevel.BACHELOR, 109);
            manager.addLecturer(newLecturer);
        Lecturer newLecturer2 = new Lecturer("shaked", "2", "degreename", DegreeLevel.MASTER, 115);
            manager.addLecturer(newLecturer2);
        Lecturer newLecturer3 = new Lecturer("noa", "3", "degreename", DegreeLevel.PROFESSOR, 154);
            manager.addLecturer(newLecturer3);

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
            DegreeLevel elevel;
            switch (degreeLevel) {
                case 1 -> elevel = DegreeLevel.BACHELOR;
                case 2 -> elevel = DegreeLevel.MASTER;
                case 3 -> elevel = DegreeLevel.PHD;
                case 4 -> elevel = DegreeLevel.PROFESSOR;
                default -> {System.out.println("Invalid number"); 
                return;}

            }
            System.out.println("Enter salary");
            int salary = s.nextInt();
            s.nextLine();
            Lecturer newLecturer = new Lecturer(name, id, degreename, elevel, salary);
            manager.addLecturer(newLecturer);
            System.out.println("Lucturer added successfully!");
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

    private static void updateChairOfCommittee(){
        System.out.println("Enter committee name: ");
        String comName = s.nextLine();
        if(!manager.isExistCommittee(comName)){
            System.out.println("\nThe committee does not exist in the system");
            System.out.println("press 1 to create a Committee or 2 to return to menu");;
            if (s.nextInt() == 1) {
                s.nextLine(); 
                addCommittee ();
                
            }    
        }
        else{
            Committee commmittee = manager.getCommitteeByName(comName);
            System.out.println("Enter new chairman name: ");
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
                    manager.updateChairOfCommittee(commmittee, chair);
                    System.out.println("Chairman updated successfully!");
                }
            }
        }

    }

    private static void removeLecturerFromCommittee(){
        System.out.println("Enter committee name: ");
        String comName = s.nextLine();
        if(!manager.isExistCommittee(comName)){
            System.out.println("\nThe committee does not exist in the system");
            System.out.println("press 1 to create a Committee or 2 to return to menu");;
            if (s.nextInt() == 1) {
                s.nextLine(); 
                addCommittee ();
                
            }    
        }
        else{
            Committee commmittee = manager.getCommitteeByName(comName);
            System.out.println("Enter lecturer name: ");
            String lectName = s.nextLine();
            if(!manager.isExistLecturer(lectName))
            {
                System.out.println("Lecturrer does not exist in the system, please add him first");
                System.out.println("press 1 to add lecturrer to do system or 2 to return to menu");;
                if (s.nextInt() == 1) {
                    s.nextLine(); 
                    addLecturer ();
                    
                }
            }
            else{
                Lecturer lect = manager.getLecturerByName(lectName);
                if (!manager.isLecturrerInCommittee(lect, commmittee)){
                    System.out.println("Lecturer is not in the committee");
                    System.out.println("Press 1 to remove a new lecturer from cimmittee or 2 to return to menu");  
                    if (s.nextInt() == 1) {
                        s.nextLine();
                        removeLecturerFromCommittee();
                        
                    }   
                }
                else{
                    manager.removeLecturerFromCommittee(lect, commmittee);
                    System.out.println("Lecturer removed from committee successfully!");
                }
            }
        }


    }

    private static void asignLecturerToCommittee(){
        System.out.println("Enter committee name: ");
        String comName = s.nextLine();
        if(!manager.isExistCommittee(comName)){
            System.out.println("\nThe committee does not exist in the system");
            System.out.println("press 1 to create a Committee or 2 to return to menu");;
            if (s.nextInt() == 1) {
                s.nextLine(); 
                addCommittee ();
                
            }    
        }
        else{
            Committee commmittee = manager.getCommitteeByName(comName);
            System.out.println("Enter lecturer name: ");
            String lectName = s.nextLine();
            if(!manager.isExistLecturer(lectName))
            {
                System.out.println("Lecturrer does not exist in the system, please add him first");
                System.out.println("press 1 to add lecturrer to do system or 2 to return to menu");;
                if (s.nextInt() == 1) {
                    s.nextLine(); 
                    addLecturer ();
                    
                }
            }
            else{
                Lecturer lect = manager.getLecturerByName(lectName);
                if (manager.isLecturrerInCommittee(lect, commmittee)){
                    System.out.println("Lecturer is already in the committee");
                    System.out.println("Press 1 to asign a new lecturer to cimmittee or 2 to return to menu");  
                    if (s.nextInt() == 1) {
                        s.nextLine();
                        asignLecturerToCommittee();
            }   
                }
                else{
                    manager.asignLecturerToCommittee(lect, commmittee);
                    System.out.println("Lecturer added to committee successfully!");
                }
            }
        }
        
    }

    private static void asignLecturerToDepartment(){
        System.out.println("Enter department name: ");
        String depName = s.nextLine();
        if(!manager.isExistDepartment(depName)){
            System.out.println("\nThe department does not exist in the system");
            System.out.println("press 1 to create a Department or 2 to return to menu");;
            if (s.nextInt() == 1) {
                s.nextLine(); 
                addDepartment ();
                
            }    
        }
        else{
            Department department = manager.getDepartmentByName(depName);
            System.out.println("Enter lecturer name: ");
            String lectName = s.nextLine();
            if(!manager.isExistLecturer(lectName))
            {
                System.out.println("Lecturrer does not exist in the system, please add him first");
                System.out.println("press 1 to add lecturrer to do system or 2 to return to menu");;
                if (s.nextInt() == 1) {
                    s.nextLine(); 
                    addLecturer ();
                    
                }
            }
            else{
                Lecturer lect = manager.getLecturerByName(lectName);
                if (lect.getDepartment() != null && lect.getDepartment().getName().equals(depName)){
                    System.out.println("Lecturer is already in the department");
                    System.out.println("Press 1 to asign a new lecturer to Department or 2 to return to menu");  
                    if (s.nextInt() == 1) {
                        s.nextLine();
                        asignLecturerToDepartment();
                        
                    }   
                }
                else{
                    manager.removeLecturerFromDepartment(lect, lect.getDepartment());
                    manager.asignLecturerToDepartment(lect, department);
                    System.out.println("Lecturer added to department successfully!");
                }
            }
        }
        
    }
        
    private static void showAverageSalaryOfAllLecturers(){
        float avg = manager.calcAvgSalary();
        System.out.println("The average salary of all lecturers is: " + avg);
    }

    private static void showAverageSalaryOfLecturersInDepartment(){
        System.out.println("Which departmnet average would you like to see?");
        String depName = s.nextLine();
        if(!manager.isExistDepartment(depName)){
            System.out.println("\nThe department does not exist in the system");
            System.out.println("press 1 to create a Department or 2 to return to menu");;
            if (s.nextInt() == 1) {
                s.nextLine(); 
                addDepartment ();
                
            }    
        }
        else{
            float avg = manager.calcAvgDep(depName); 
            System.out.println("The average salary for " + depName + " is: " + avg);
        }
    }

    private static void showAllLecturersInfo(){
        System.out.println("Presenting all lecturers info: ");
        manager.lucturersInfo();
    }

    private static void showAllCommitteesInfo(){
        System.out.println("Presenting all committies info: ");
        manager.committeesInfo();

    }


}
