package ShakedShpirkoAndNoaSchwarz;
// Shaked Shpirko 315142372 & Noa Schwarz 212840516
import java.util.Scanner;

import ShakedShpirkoAndNoaSchwarz.Lecturer.DegreeLevel;
public class Main {
    private static final String[] MENU = {
        "Exit",
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
        "Show All Info"
        //, "Compare Lecturers by Papers", 
        //, "Compare Committees", 
        //, "Duplicate Committee"
        
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
                case 12 -> showAll();
                //case 12 -> compareLecturersByPapers();
                //case 13 -> compareCommittee();
                //case 14 -> duplicateCommittee();
                default -> System.out.println("Incorrect input, please try again");
            }
        } while (userChosenNum != 0);
    }
    public static void main(String[] args) {
        // Noa Schwarz 212840516 & Shaked Shpirko 315142372
        s = new Scanner(System.in);
        System.out.println("Welcome to the system! please enter a college name: ");
        Main.manager = new Manager(s.nextLine());
        run();
        s.close();
    }

    private static void addLecturer() {
        
        try{
            System.out.println("Enter lecturer name: ");
            String name = s.nextLine();
            manager.isExistLecturer(name);
            System.out.println("Enter lecturer ID: ");
            String id = s.nextLine();
            System.out.println("Enter degree name: ");
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
            System.out.println("Enter salary: ");
            int salary = s.nextInt();
            s.nextLine();
            manager.createLecturer(name, id, degreename, elevel, salary);
            System.out.println("Lucturer added successfully!");
        }
        catch (LecturrerExistException e){
            System.out.println(e.getMessage());
            System.out.println("press 1 to change the Lecturer name or 2 to return to menu");
            if (s.nextInt() == 1) {
                s.nextLine(); 
                addLecturer ();
                
            }
        }

    }

   private static void addDepartment() {
        try{
            System.out.println("Enter department name: ");
            String name = s.nextLine();
            manager.isExistDepartment(name);
            manager.createDepartment(name);
            System.out.println("Department added successfully!");
        }
        catch(DepartmentExistException e)
        {
            System.out.println(e.getMessage());
            System.out.println("press 1 to change the Department name or 2 to return to menu");;
            if (s.nextInt() == 1) {   
              s.nextLine(); 
             addDepartment ();
                
            }
            
        }
        
    }

    private static void addCommittee(){
        try {
            System.out.println("Enter committee name: ");
            String name = s.nextLine();
            manager.isExistCommittee(name);
            System.out.println("Enter chairman name: ");
            String chairName = s.nextLine();
            manager.isNotExistLecturer(chairName);
            Lecturer chair = manager.getLecturerByName(chairName);
            manager.notProOrDoc(chair);
            manager.createCommittee(name, chair);
            System.out.println("Committee added successfully!");
        }
        catch (CommitteeExistException e) {
            System.out.println(e.getMessage());
            System.out.println("press 1 to retry or 2 to return to menu");;
            if (s.nextInt() == 1) {
                s.nextLine(); 
                addCommittee ();
            }
            
        }
        catch (LecturerNotExistException e) {
            System.out.println(e.getMessage());
            System.out.println("press 1 to add lecturrer to do system or 2 to return to menu");;
            if (s.nextInt() == 1) {
                s.nextLine(); 
                addLecturer ();
                
            }
        }
        catch (notProOrDocException e){
            System.out.println(e.getMessage());
            System.out.println("press 1 to retry or 2 to return to menu");  
            if (s.nextInt() == 1) {
                s.nextLine();
                addCommittee();
            }
        }
    }
            
    private static void updateChairOfCommittee(){
        try {
            System.out.println("Enter committee name: ");
            String comName = s.nextLine();
            manager.isNotExistCommittee(comName);
            Committee com = manager.getCommitteeByName(comName);
            System.out.println("Enter new chairman name: ");
            String chairName = s.nextLine();
            manager.isNotExistLecturer(chairName);
            Lecturer chair = manager.getLecturerByName(chairName);
            manager.notProOrDoc(chair);
            manager.isLecturrerInCommittee(chair, com);
            manager.isChairAlreadyChairOfCommittee(chair, com);
            manager.updateChairOfCommittee(com, chair);
            System.out.println("Chairman updated successfully!");
        }
        catch (CommitteeNotExistException e) {
            System.out.println(e.getMessage());
            System.out.println("press 1 to add Committee or 2 to return to menu");;
            if (s.nextInt() == 1) {
                s.nextLine(); 
                addCommittee ();
            }
        }
        catch (LecturerNotExistException e) {
            System.out.println(e.getMessage());
            System.out.println("press 1 to add lecturrer to do system or 2 to return to menu");;
            if (s.nextInt() == 1) {
                s.nextLine(); 
                addLecturer ();
                
            }
        }
        catch (notProOrDocException e){
            System.out.println(e.getMessage());
            System.out.println("press 1 to retry or 2 to return to menu");  
            if (s.nextInt() == 1) {
                s.nextLine();
                updateChairOfCommittee();
            }
        }
        catch (LecturrerAlreadyCairException e){
            System.out.println(e.getMessage());
            System.out.println("press 1 to retry or 2 to return to menu");  
            if (s.nextInt() == 1) {
                s.nextLine();
                updateChairOfCommittee();
            }
        }
        catch (LecturrerInCommitteeException e){
            System.out.println(e.getMessage());
            System.out.println("press 1 to retry or 2 to return to menu");  
            if (s.nextInt() == 1) {
                s.nextLine();
                updateChairOfCommittee();
            }
        }
        
        
        
    }

    private static void asignLecturerToCommittee()
    {
        try{
            System.out.println("Enter committee name: ");
            String comName = s.nextLine();
            manager.isNotExistCommittee(comName);
            Committee commmittee = manager.getCommitteeByName(comName);
            System.out.println("Enter lecturer name: ");
            String lectName = s.nextLine();
            manager.isNotExistLecturer(lectName);
            Lecturer lect = manager.getLecturerByName(lectName);
            manager.isLecturrerInCommittee(lect, commmittee);
            manager.isChairAlreadyChairOfCommittee(lect, commmittee);
            manager.asignLecturerToCommittee(lect, commmittee);
            System.out.println("Lecturer added to committee successfully!");
        }
        catch (CommitteeNotExistException e) {
            System.out.println(e.getMessage());
            System.out.println("press 1 to add Committee or 2 to return to menu");;
            if (s.nextInt() == 1) {
                s.nextLine(); 
                addCommittee ();
                
            }
        }
        catch (LecturerNotExistException e) {
            System.out.println(e.getMessage());
            System.out.println("press 1 to add lecturrer to do system or 2 to return to menu");;
            if (s.nextInt() == 1) {
                s.nextLine(); 
                addLecturer ();
                
            }
        }
        catch (LecturrerAlreadyCairException e){
            System.out.println(e.getMessage());
            System.out.println("press 1 to retry or 2 to return to menu");  
            if (s.nextInt() == 1) {
                s.nextLine();
                asignLecturerToCommittee();
            }
        }
        catch (LecturrerInCommitteeException e){
            System.out.println(e.getMessage());
            System.out.println("press 1 to retry or 2 to return to menu");  
            if (s.nextInt() == 1) {
                s.nextLine();
                asignLecturerToCommittee();
            }
        }
    }
   
    private static void asignLecturerToDepartment(){
        try {
            System.out.println("Enter lecturer name: ");
            String lectName = s.nextLine();
            manager.isNotExistLecturer(lectName);
            Lecturer lect = manager.getLecturerByName(lectName);
            System.out.println("Enter department name: ");
            String depName = s.nextLine();
            manager.isNotExistDepartment(depName);
            Department dep = manager.getDepartmentByName(depName);
            manager.isLecturerInDepartment(lect, dep);
            manager.asignLecturerToDepartment(lect, dep);
            System.out.println("Lecturer assigned to department successfully!");
        }
        catch (LecturerNotExistException e) {
            System.out.println(e.getMessage());
            System.out.println("press 1 to add lecturrer to do system or 2 to return to menu");;
            if (s.nextInt() == 1) {
                s.nextLine(); 
                addLecturer ();
                
            }
        }
        catch (DepartmentNotExistException e) {
            System.out.println(e.getMessage());
            System.out.println("press 1 to add Department to do system or 2 to return to menu");;
            if (s.nextInt() == 1) {
                s.nextLine(); 
                addDepartment ();
                
            }
        }
        catch (LecturrerInDepartmentException e) {
            System.out.println(e.getMessage());
            System.out.println("press 1 to asign a diffrent lecturer to the department or 2 to return to menu");  
            if (s.nextInt() == 1) {
                s.nextLine();
                asignLecturerToDepartment();
            }
        }


        
        
        
    }
   
    private static void removeLecturerFromCommittee() {
        try {
            System.out.println("Enter committee name: ");
            String comName = s.nextLine();
            manager.isNotExistCommittee(comName);
            Committee com = manager.getCommitteeByName(comName);
            System.out.println("Enter lecturer name: ");
            String lectName = s.nextLine();
            manager.isNotExistLecturer(lectName);
            Lecturer lect = manager.getLecturerByName(lectName);
            manager.isLecturrerNotInCommittee(lect, com);
            manager.removeLecturerFromCommittee(lect, com);
            System.out.println("Lecturer removed from committee successfully!");
        }
        catch (CommitteeNotExistException e) {
            System.out.println(e.getMessage());
            System.out.println("press 1 to add Committee or 2 to return to menu");;
            if (s.nextInt() == 1) {
                s.nextLine(); 
                addCommittee ();
                
            }
        }
        catch (LecturerNotExistException e) {
            System.out.println(e.getMessage());
            System.out.println("press 1 to add lecturrer to do system or 2 to return to menu");;
            if (s.nextInt() == 1) {
                s.nextLine(); 
                addLecturer ();
                
            }
        }
        catch (LecturrerNotInCommitteeException e){
            System.out.println(e.getMessage());
            System.out.println("press 1 to retry or 2 to return to menu");  
            if (s.nextInt() == 1) {
                s.nextLine();
                removeLecturerFromCommittee();
            }
        }
    }
   
    private static void showAverageSalaryOfAllLecturers(){
        System.out.println(manager.calcAvgSalary());
    }

    private static void showAverageSalaryOfLecturersInDepartment(){
        try {
            System.out.println("Enter department name: ");
            String depName = s.nextLine();
            manager.isNotExistDepartment(depName);
            Department dep = manager.getDepartmentByName(depName);
            System.out.println(manager.calcAvgDep(dep));
        }
        catch (DepartmentNotExistException e) {
            System.out.println(e.getMessage());
            System.out.println("press 1 to add Department to do system or 2 to return to menu");;
            if (s.nextInt() == 1) {
                s.nextLine(); 
                addDepartment ();
                
            }
        }
    }

    private static void showAllLecturersInfo(){
        System.out.println("--------------------------------------------------");
        System.out.println("Presenting all lecturers info: ");
        System.out.println(manager.LecturersInfo());
    }

    private static void showAllCommitteesInfo(){
        System.out.println("--------------------------------------------------");
        System.out.println("Presenting all committies info: ");
        System.out.println(manager.committeesInfo());

    }

    private static void showAll() {
        System.out.println("--------------------------------------------------");
        System.out.println("Presenting all info: ");
        System.out.println(manager.allInfo());
    }

}
